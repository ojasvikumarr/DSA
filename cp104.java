import java.nio.Buffer;
import java.io.* ;
import java.util.* ; 
import java.lang.StringBuilder ; 
import java.util.Arrays ;
public class cp104 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            int n = Integer.parseInt(br.readLine());

            long[][] dp = new long[n+1][2] ;
            dp[n][0] = 1 ;
            dp[n][1] = 1; 
            int Mod = 1000000007;
            for(int i = n-1 ; i >= 0 ; i--){
                dp[i][0] = (dp[i+1][0]*2 + dp[i+1][1]) % Mod;
                dp[i][1] = (dp[i+1][0] + dp[i+1][1]*4) % Mod;
            }
            sb.append(((dp[1][0] + dp[1][1])%Mod) );
            sb.append("\n");
        }
        System.out.print(sb.toString());
        br.close();
    }
    public static int gcd(int a , int b){
        if(b == 0) return a ; 
        return gcd(b , a%b);
    }
}

