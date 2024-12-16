package DynamicProgramming;

public class RegexMatching {
    class Solution {
        public boolean isMatch(String s, String t) {
            int sL = s.length();
            int tL = t.length();
            boolean[][] dp = new boolean[sL+1][tL+1];
            dp[0][0] = true ;
            //to handle cases like a* , a*b*, a*b*c*....
            for(int i = 1 ; i <= tL ; i++){
                if(t.charAt(i-1) == '*'){
                    dp[0][i] = dp[0][i-2];
                }
            }
            for(int i = 1 ; i <= sL ; i++){
                for(int j = 1 ; j <= tL ; j++){
                    boolean flag = false ; 
                    if(s.charAt(i-1) == t.charAt(j-1) || t.charAt(j-1) == '.'){
                        flag = dp[i-1][j-1];
                    }else if(t.charAt(j-1) == '*'){
                        flag = dp[i][j-2];
                        if(t.charAt(j-2) == '.' || t.charAt(j-2) == s.charAt(i-1)){
                            flag = flag || dp[i-1][j];
                        }
                    }
                    dp[i][j] = flag ;
                }
            }
            return dp[sL][tL];
        }
    }
}
