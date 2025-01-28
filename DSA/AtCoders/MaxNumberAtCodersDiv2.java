package AtCoders;
// package AtCoders;
//Remove this package when submitting the answer 
import java.util.* ;
import java.lang.StringBuilder;
// import java.math.BigInteger; 
public class MaxNumberAtCodersDiv2 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        String s = sc.next() ;
        String t = sc.next();
        // System.out.println();
        solve(s, t, n, m);
        sc.close();
    }


    public static void solve(String s, String t , int n , int m){
        //We will sort the frequencies 
        //Or we can just make a freq map 
        int[] freq = new int[10];//1-9
        
        //We need to keep track of their index 
        //We will keep the max index in map 
        Map<Integer , Integer> map = new HashMap<>();
        for(int i = 0 ; i < m ; i++){
            char c = t.charAt(i);
            int num = c-'0';
            freq[num]++ ;
            map.put(num , Math.max(map.getOrDefault(num , 0) , i));
        }
        //Now we will traverse String s 
        StringBuilder sb = new StringBuilder(s);

        int maxi = -1 ; 
        int i = 0 ;
        for(int j = 9 ; j > 0 ; j--){
            while(freq[j] > 0){
                int num = j ; 
                boolean placed = false ;
                // System.out.println(j + " " + freq[j]);
                while(i < n){
                    if(sb.charAt(i) - '0' < num){
                        placed = true ;
                        sb.setCharAt(i , (char)(num+'0')) ; 
                        // System.out.println("Ping!!" + sb);
                        if(map.containsKey(num))
                        maxi = Math.max(maxi , map.get(num));
                        i++ ;
                        break ;
                    }
                    i++ ;
                }
                if(placed == false){
                    //that is the num is not placed we need to check maxi 
                    if(map.containsKey(num) && map.get(num) > maxi){
                        //we will place at last 
                        sb.setCharAt(sb.length()-1 , (char)(num+'0')) ;
                        maxi = map.get(num);
                    }
                }
                freq[j]-- ;
            }
        }
        // BigInteger result = new BigInteger(sb.toString());
        System.out.println(sb);
        return ;
    }
}
