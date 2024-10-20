package DynamicProgramming;

public class DiamonMining {
    public static int burstballoon(int i , int j , int[] arr){
        if(i > j) return 0;
        int max = Integer.MIN_VALUE ;
        for(int idx = i ; idx <= j ; idx++){
            int cost = arr[i-1]*arr[idx]*arr[j+1] + burstballoon(i, idx-1, arr) + burstballoon(idx+1, j, arr);
            if(max < cost) max = cost ;
        }
        return max ;
    }
    public static int DP(int i , int j , int[] arr , int[][] dp){
        if(i > j) return 0 ;
        if(dp[i][j] != -1) return dp[i][j] ;
        int max = Integer.MIN_VALUE ;
        for(int idx = i ; idx < j ; idx++){
            int cost = arr[i-1]*arr[idx]*arr[j+1] +DP(i, idx-1, arr, dp) + DP(idx+1, j, arr, dp) ;
            if(max < cost) max = cost ;
        }   
        return dp[i][j] = max ;
    }
    public static int Tab (int[] arr){
        int[][] dp = new int[arr.length-1][arr.length-1];

        for(int i = 0 ; i <arr.length ; i++){
            for(int j = 0 ; j <= arr.length-1 ; j++){
                if(i <j) dp[i][j] = 0 ;
            }
        }
        for(int i = arr.length-1 ; i > 0 ; i--){
            for(int j = 1 ; j <= arr.length-1 ; j++){
                if(i > j) continue ;
                int Max = Integer.MAX_VALUE ;
                for(int idx = i ; idx <= j ; idx++){
                    int cost = arr[i-1]*arr[idx]*arr[j+1] +DP(i, idx-1, arr, dp) + DP(idx+1, j, arr, dp) ;
                    if(Max < cost) Max = cost ;
                }
            }
        }
        return dp[1][arr.length+ 1];
    }
}
