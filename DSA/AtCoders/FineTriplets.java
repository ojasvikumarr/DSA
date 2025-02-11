package AtCoders;
import java.util.* ; 
public class FineTriplets {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] s = new int[n];
        for(int i = 0 ; i < n ; i++) s[i] = sc.nextInt();
        solve(s , n);
        sc.close();
    }
    public static void solve(int[] s , int n){
        Arrays.sort(s);
        // a 2B c
        HashMap<Integer , Integer> map = new HashMap<>();
        int result = 0 ;
        for(int i = 1; i < n-1 ; i++){
            int c = s[i+1];
            int b = s[i]*2 ;
            map.put(b , map.getOrDefault(b , 0 )+1);

            for(int j = 0 ; j < i ; j++){
                int aPlusc = s[j] + c ; 
                if(map.containsKey(aPlusc)){
                    result++ ; 
                }
            }
        }
        System.out.println(result);
    }
    public static void solveII(int[] s , int n ){
        Map<Integer , Integer> map = new HashMap<>();
        Arrays.sort(s);
        for(int i = 0 ; i < n-1 ; i++){
            int diff = s[i+1] - s[i];
            map.put(diff , map.getOrDefault(diff , 0)+1);
        }

        long result = 0 ; 
        for(Integer key : map.keySet()){
            long freq = map.get(key);
            result += (freq*(freq-1))/2 ; 
        }
        System.out.println(result);
    }
}
