import java.util.*  ;

public class cp48 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            int k = sc.nextInt();
            String s = sc.next();
            if(solve(s , k)){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
        sc.close();
    }
    public static boolean solve(String s ,int k){
        int[] freq = new int[26];
        for(char c : s.toCharArray()){
            freq[c-'a']++ ; 
        }
        int noOdds = 0 ; 
        int noEvens = 0 ; 
        for(int i = 0 ; i < 26 ; i++){
            if(freq[i] % 2 == 0){
                noEvens++ ;
            }else{
                noOdds++ ;
            }
        }
        if(noOdds > 1){
            if(k < noOdds-1){
                return false ; 
            }else{
                k -= (noOdds-1);
                noOdds = 1 ;
                return true ;
            }
        }else{
            //No or single Odds ; 
            // if(k % 2 == 0){
            //     return true ; 
            // }else if(noOdds == 1 && k % 2 != 0){
            //     return true ; 
            // }else{
            //     return false ;
            // }
            return true ; 
        }
    }
}
