package DynamicProgramming;

public class MaxNoneAdjSum {
    public static int MaxSum(int idx , int[] arr ){
        if(idx == 0 ){
            return arr[idx];
        }else if(idx < 0){
            return 0 ;
        }

        int pick = MaxSum(idx, arr) + MaxSum(idx-2, arr);
        int NotPick = MaxSum(idx-1, arr);

        return Math.max(pick , NotPick);
    }

    public static int MaxSumDp(int idx , int arr[] , int[] dp){
        if(idx == 0){
            return arr[idx];
        }else if(idx < 0){
            return 0 ;
        }
        if(dp[idx] != -1){
            return dp[idx];
        }

        int pick = MaxSumDp(idx, arr, dp) + MaxSumDp(idx-2, arr, dp);
        int NotPick = MaxSumDp(idx-1, arr, dp);

        return dp[idx] = Math.max(pick , NotPick);
    }

    public static int MaxSumTab(int[] arr){
        int[] dp = new int[arr.length];
        dp[0] = arr[0]; 
        for(int i = 1 ; i < arr.length ; i++){
            int pick = dp[i-1] ;
            int NotPick = dp[i]; 
            if(i > 1){
                NotPick = dp[i] + dp[i-2];
            }
            dp[i] = Math.max(pick , NotPick);
        }
        return dp[arr.length-1];
    }

    public static int MaxSumTabOpt(int[] arr){
        int n = arr.length ; 
        int prev = arr[0];
        int prev2 = 0 ;
        int curr = 0 ;
        for(int i = 0 ; i < n ; i++){
            int take = arr[i];
            if(i > 1){
                take = arr[i] + prev2;
            }
            int notTake = 0 + prev ;

            curr = Math.max(take , notTake);
            prev2 = prev ;
            prev = curr ;
        }
        return curr ;
    }
}
