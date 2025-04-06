package PlacementTime.CSES;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class CoinCombinationsI {
     public static void main(String[] args)throws IOException{
        // Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int sum = Integer.parseInt(st.nextToken());
            int[] coins = new int[n];
            st = new StringTokenizer(br.readLine());
            for(int i = 0 ; i < n ; i++) coins[i] = Integer.parseInt(st.nextToken());

            int MOD = (int)1e9 + 7 ; 
            long[] dp = new long[sum+1];
            dp[0] = 1; 
            //TLE 1e8 == 1e6*100coins
            for(int i = 1 ; i <= sum ; i++){
                for(int coin : coins){
                    if(coin <= i){
                        dp[i] = (dp[i] + dp[i-coin])%MOD ; 
                    }
                }
            }

            // for (int coin : coins) {
            //     for (int i = coin; i <= sum; i++) {
            //         dp[i] = (dp[i] + dp[i - coin]) % MOD;
            //     }
            // }
            bw.write(dp[sum] + " \n");
            br.close();
            bw.close();
    }
}
