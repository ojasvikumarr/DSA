package PlacementTime.DP;

public class LongestCommonSubArray {
    class Solution {
        public int longestCommonSubstr(String s1, String s2) {
            // code here
            return tabulation(s1 , s2);
        }
        public int tabulation(String s , String t){
            int n = s.length();
            int m = t.length();
            int[][] tab = new int[n+1][m+1];
            int maxi = 0 ; 
            for(int i = 1 ; i <= n ; i++){
                for(int j = 1 ; j <= m ; j++){
                    if(s.charAt(i-1) == t.charAt(j-1)){
                        tab[i][j] = 1 + tab[i-1][j-1];
                    }
                    maxi = Math.max(maxi , tab[i][j]);
                }
            }
            return maxi ; 
        }
    }
}
