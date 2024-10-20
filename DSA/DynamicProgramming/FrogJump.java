package DynamicProgramming;

public class FrogJump {
    public static int JumpRec(int idx , int[] arr){  //O(nlogn)
        if(idx == 0){
            return 0 ;
        }
        int left = JumpRec(idx-1, arr) + Math.abs(arr[idx] - arr[idx-1]);
        int right = JumpRec(idx-2, arr) + Math.abs(arr[idx] - arr[idx-2]);
        return Math.min(left, right);
    }
    public static int JumpDp(int idx , int[] arr , int dp[]){ // O(n) SC(n)
        if(idx < 0){
            return 0 ;
        }
        if(dp[idx] != -1){
            return dp[idx];
        }
        int left = JumpDp(idx-1 , arr , dp) + Math.abs(arr[idx] - arr[idx-1]);
        int right = Integer.MAX_VALUE ;
        if(idx > 1) right = JumpDp(idx-2 , arr , dp) + Math.abs(arr[idx] - arr[idx-2]);
        return dp[idx] = Math.min(left, right);
    }
    public static int JumpTab(int[] arr){
        int dp[] = new int[arr.length] ;
        dp[0] = 0 ;
        for(int i  = 1 ; i < arr.length ; i++){
            int left = dp[i-1] + Math.abs(arr[i] - arr[i-1]);
            int right = Integer.MAX_VALUE ;
            if(i > 1){
                right = dp[i-2] + Math.abs(arr[i] - arr[i-2]);
            }
            dp[i] = Math.min(left , right);
        }
        return dp[arr.length];
    }
    public static int JumpOptTab(int[] arr){
        int prev = 0 ;
        int prev2 = Integer.MAX_VALUE ;
        int curr = 0 ;
        for(int i = 1 ; i < arr.length ; i++){
            prev = prev + Math.abs(arr[i] - arr[i-1]);
            if(i > 1){
                prev2 = prev2 + Math.abs(arr[i] - arr[i-2]);
            }
            curr = Math.min(prev, prev2);
            prev2 = prev ;
            prev = curr ; 
        }   
        return prev ;
    }
    public static int JumpOpt2Tab(int[] arr){
        int prev = 0 ;
        int prev2 = Integer.MAX_VALUE ;
        int curr = 0 ;
        for(int i = 1 ; i < arr.length ; i++){
            int left = prev + Math.abs(arr[i] - arr[i-1]);
            int right = Integer.MAX_VALUE ;
            if(i > 1){
                right = prev2 + Math.abs(arr[i] - arr[i-2]);
            }
            curr = Math.min(left, right);
            prev2 = prev ;
            prev = curr ; 
        }   
        return prev ;
    }
}
