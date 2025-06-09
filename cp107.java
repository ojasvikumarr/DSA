import java.nio.Buffer;
import java.io.* ;
import java.util.* ; 
import java.lang.StringBuilder ; 
import java.util.Arrays ;
public class cp107 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        // int tc = Integer.parseInt(br.readLine());
        // while(tc-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
           
            int[][] dp = new int[n+1][m+1];
            for(int i = 0 ; i <= n ; i++){
                for(int j=  0 ; j <= m; j++){
                    dp[i][j] = Integer.MAX_VALUE ;
                }
            }

            for(int i = 1 ; i <= n ; i++){
                for(int j = 1 ; j <= m ; j++){
                    if(i == j){
                        dp[i][j] = 0 ; 
                        continue ;
                    }

                    //Trying all vertical cuts 
                    for(int k = 1 ; k < j ; k++){
                        dp[i][j] = Math.min(dp[i][j] , dp[i][k] + dp[i][j-k] + 1);
                    }
                    for(int k = 1 ; k < i ; k++){
                        dp[i][j] = Math.min(dp[i][j] , dp[k][j] + dp[i-k][j] + 1);
                    }
                }
            }
            sb.append(dp[n][m]);
            System.out.println(sb.toString());
        // }
        // System.out.print(sb.toString());
        br.close();
    }
    public static int gcd(int a , int b){
        if(b == 0) return a ; 
        return gcd(b , a%b);
    }
}

