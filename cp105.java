import java.nio.Buffer;
import java.io.* ;
import java.util.* ; 
import java.lang.StringBuilder ; 
import java.util.Arrays ;
public class cp105 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        // int tc = Integer.parseInt(br.readLine());
        // while(tc-- > 0){
            String s = br.readLine();
            String t = br.readLine();

            int n = s.length();
            int m = t.length();

            long[][] dp = new long[n+1][m+1] ;
            for(int i = 0 ; i <= n ; i++){
                for(int j=  0 ; j <= m; j++){
                    dp[i][j] = Integer.MAX_VALUE ;
                }
            }
            for(int i = 0 ; i <= m ; i++){
                dp[0][i] = i ;
            }
            for(int i = 0 ; i <= n ; i++){
                dp[i][0] = i ;
            }
            dp[0][0] = 0 ; 

            for(int i = 1 ; i <= n ; i++){
                for(int j = 1 ; j <= m ; j++){
                    if(s.charAt(i-1) == t.charAt(j-1)){
                        dp[i][j] = dp[i-1][j-1];
                    }else{
                        dp[i][j] = dp[i-1][j-1] + 1 ;// remove 
                    }
                    //these two ops we need to perform randomly for matching the length 
                    dp[i][j] = Math.min(dp[i][j] , dp[i-1][j] + 1);
                    dp[i][j] = Math.min(dp[i][j] , dp[i][j-1] + 1);
                }
            }
            sb.append(dp[n][m]);
            sb.append("\n");
        // }
        System.out.print(sb.toString());
        br.close();
    }
    public static int gcd(int a , int b){
        if(b == 0) return a ; 
        return gcd(b , a%b);
    }
}

