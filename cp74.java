import java.util.* ; 
public class cp74 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t--  >0){
            String a = sc.next();
            String b = sc.next();

            int n = a.length();
            int m = b.length();
            int maxi = 0 ; 
            int[][] dp = new int[n+1][m+1]  ;
            for(int i = 1 ; i <= n ; i++){
                for(int j = 1 ; j <= m ; j++){
                    if(a.charAt(i-1) == b.charAt(j-1)){
                        dp[i][j] = dp[i-1][j-1]+ 1  ;
                    }
                    maxi = Math.max(maxi , dp[i][j]);
                }
            }

            System.out.println(n+m-2*maxi);
        }
        sc.close();
    }

   
}
