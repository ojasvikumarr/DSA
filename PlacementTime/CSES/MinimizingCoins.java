package PlacementTime.CSES;

import java.util.Scanner;

public class MinimizingCoins {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        
            int n = sc.nextInt();
            int target = sc.nextInt();
            int[] coins = new int[n];
            for(int i = 0 ; i < n ; i++){
                coins[i] = sc.nextInt();
            }   


            long[] dp = new long[target+1];
            for(int i = 0 ; i <= target ; i++){
                dp[i] = Long.MAX_VALUE;
            }
            dp[0] = 0 ; 
            for(int i = 1 ; i <= target ; i++){
                long mini = Long.MAX_VALUE ; 
                for(int coin : coins){
                    if(coin <= i){
                        mini = Math.min(mini , dp[i-coin]);
                    }
                }
                if(mini == Long.MAX_VALUE){
                    dp[i] = mini ; 
                }else{
                    dp[i] = mini+1 ; 
                }
            }
            
            if(dp[target] == Long.MAX_VALUE){
                System.out.println(-1);
            }else{
                System.out.println(dp[target]);
            }

        sc.close();
    }
}
