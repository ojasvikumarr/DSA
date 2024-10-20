package DynamicProgramming;

public class SubsetSumEqualToK {
    // class pair{
    // int idx ;
    // int target ;
    // boolean status ;
    // public pair(int i , int t , boolean s){
    // this.idx = i ;
    // this.target = t ;
    // this.status = s ;
    // }
    // }
    public static boolean recursion(int[] arr, int idx, int target, int k, int[][] dp) {
        if (idx < 0) {
            if (target == 0) {
                return true;
            } else {
                return false;
            }
        }
        // if(dp[idx][target] != -1){
        // return dp[idx][target];
        // }
        boolean pick = recursion(arr, idx - 1, target - arr[idx], k, dp);
        boolean notPick = recursion(arr, idx - 1, target, k, dp);
        return pick || notPick;

    }

    public static void isTarget(int[] arr, int k) {
        int[][] dp = new int[arr.length][2];
        // for(int i = 0 ; i < arr.length ; i++){
        // for(int j = 0 ; j < 2 ; j++){
        // dp[i][j] = ;
        // }
        // }

        recursion(arr, k, k, k, dp);
    }

    // public static boolean Subset(int[]arr , int idx , int target , boolean[][]
    // dp){
    // if(target == 0){
    // return true ;
    // }
    // if(dp[idx][target].booleanValue() != null){
    // return dp[idx][target];
    // }

    // if(idx == 0)return arr[0] == target ;
    // boolean noTtake = Subset(arr, idx-1, target);
    // boolean Take = false ;
    // if(arr[idx] <= target) Take = Subset(arr, idx-1, target - arr[idx]);
    // return Take || noTtake ;
    // }

    public static void SubsetSum(int n, int k, int[] arr) {
        // int[][] dp = new int[n][k+1];
        // for(int i = 0 ; i < n; i++){
        // for(int j = 0 ; j <= k+1 ; j++){
        // dp[i][j] = -1 ;
        // }
        // }

        boolean[][] dp = new boolean[n][k + 1];

        // Subset(arr, n, k);
    }

    public static boolean Tabulation(int idx, int n, int taget, int[] arr) {
        boolean[][] dp = new boolean[n][taget + 1];

        for (int ix = 1; ix < n; ix++) {
            for (int target = 0; target < taget + 1; target++) {
                boolean notTake = dp[ix - 1][target];
                boolean take = false;
                if (arr[ix] <= target)
                    take = dp[ix - 1][target + arr[ix]];
                dp[ix][target] = take || notTake;
            }
        }

        return dp[n - 1][taget];
    }


    // public static void PartitionASetintoTwoSubsets(int[] arr , int n ){
    //     int totsum = 0 ;
    //     for(int i = 0 ; i < arr.length ; i++){
    //         totsum += arr[i];
    //     }
    //     int k = totsum ;

    //     boolean[][]
    // }
}
