package PlacementTime.CSES;

import java.util.Scanner;

public class DiceCombination {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);  
        StringBuilder sb = new StringBuilder();      
        
            int n = sc.nextInt();
            
            int MOD = (int)1e9 +7 ;

            int[] dp = new int[n+1];
            dp[0] = 1; 
            for(int i = 1 ; i <= n ; i++){
                for(int j = 1 ; j <= 6 ; j++){
                    if(j <= i){
                        dp[i] =( dp[i] + dp[i-j] )%MOD; 
                    }
                }
            }
            sb.append(dp[n] + " \n");
        
        System.out.println(sb.toString());
        sc.close();
    }
}
