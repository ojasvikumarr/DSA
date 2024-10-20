package DynamicProgramming;

public class LeastCommonSubsequence {
    public static int LCS(String str1 , String str2 , int n , int m , int dp[][]){
        if(n == 0 || m == 0){
            return 0 ;
        }
        if(dp[n][m] != -1){
            return dp[n][m] ;
        }
        if(str1.charAt(n-1) == str2.charAt(m-1)){
            return dp[n][m] = LCS(str1, str2, n-1, m-1 , dp) + 1;
        }else{
            int ans1 = LCS(str1, str2, n, m-1 , dp) ;
            int ans2 = LCS(str1, str2, n-1, m , dp) ;
            return dp[n][m] = Math.max(ans1 , ans2);
        }
    }

    public static void main(String args[]){
        String str1 = "abcdge";
        String str2 = "abc";

        int n = str1.length() ;
        int m = str2.length() ; 
        int []dp[] = new int[n+1][m+1];
        System.out.println(LCS(str1, str2, n, m, dp));
    }
}
