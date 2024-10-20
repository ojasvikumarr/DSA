package DynamicProgramming;

public class GridMinPathSum {
    public static int MinPathSum(int i , int j , int[][] arr){
        if(i < 0 || j < 0){
            return Integer.MAX_VALUE ;
        }
        if(i == 0 && j == 0){
            return arr[0][0] ;
        }
        int up = MinPathSum(i-1, j, arr) + arr[i][j];
        int down = MinPathSum(i, j-1, arr) + arr[i][j];

        return Math.min(up , down);
    }

    public static int MinPathSumDp(int i , int j  , int[][] arr , int[][] dp){
        if( i < 0 || j < 0 ){
            return Integer.MAX_VALUE ; 
        }
        if( i == 0 && j == 0 ){
            return arr[0][0];
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        int up = MinPathSumDp(i, j, arr, dp) + arr[i][j];
        int left = MinPathSumDp(i, j, arr, dp) + arr[i][j];

        return dp[i][j] = Math.min(up , left);
    }

    public static int MinPathSumTab(int[][] arr){
        int[][] dp = new int[arr.length][arr[0].length];
        dp[0][0] = arr[0][0];
        int down = 0 ;
        int right = 0 ;
        for(int i = 1 ; i < arr.length ; i++){
            for(int j = 1 ; j < arr[0].length ; j++){
                if(j>0) right = arr[i][j] + dp[i][j-1];
                if(i>0) down = arr[i][j] + dp[i-1][j];
                dp[i][j] = Math.min(right , down);
            }
        }
        return dp[arr.length-1][arr[0].length-1];
    }

    public static int MinPathSumTabOpt(int[][] arr){
        int[] dp = new int[arr.length];
        dp[0] = arr[0][0];
        int down = 0 ;
        int right = 0 ;
        for(int i = 1 ; i < arr.length ; i++){
            int[] temp = new int[arr.length];
            for(int j = 1 ; j < arr[0].length ; j++){
                if(j>0) right = arr[i][j] + temp[j-1];
                if(i>0) down = arr[i][j] + dp[j];
                temp[j] = Math.min(right , down);
                dp = temp ;
            }
        }
        return dp[arr.length-1];
    }
    public boolean isPalindromic(String s){
        char[] ch = s.toCharArray();
        for(int i = 0 ; i < s.length() ; i++){
            if(ch[i] != ch[s.length() - i - 1]){
                return false ;
            }
        }
        return true ;
    }
    public String firstPalindrome(String[] words) {
        for(int i = 0 ; i < words.length ; i++){
            if(isPalindromic(words[i])){
                return words[i];
            }
        }
        String none = "";
        return  none; 
    }
}
