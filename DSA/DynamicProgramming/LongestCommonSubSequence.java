package DynamicProgramming;
import java.util.* ;
public class LongestCommonSubSequence {
    public int recurr(int i, int j, char[] s, char[] t) {
        if (i < 0 || j < 0) {
            return 0;
        }
        if (s[i] == t[j]) {
            return 1 + recurr(i - 1, j - 1, s, t);
        }

        return Integer.max(recurr(i - 1, j, s, t), recurr(i, j - 1, s, t));
    }

    public int Dp(int i, int j, char[] s, char[] t, int[][] dp) {
        if (i < 0 || j < 0) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        if (s[i] == t[j]) {
            return dp[i][j] = 1 + recurr(i - 1, j - 1, s, t);
        }
        return dp[i][j] = Integer.max(recurr(i, j - 1, s, t), recurr(i - 1, j, s, t));
    }

    public int tab(char[] s, char[] t) {
        int[][] dp = new int[s.length + 1][t.length + 1];
        for (int i = 0; i <= s.length; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i <= t.length; i++) {
            dp[0][i] = 0;
        }
        for (int i = 1; i <= s.length; i++) {
            for (int j = 1; j <= t.length; j++) {
                if (s[i - 1] == t[j - 1]) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Integer.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[s.length][t.length];
    }

    public static void TabulationPrint(char s[], char t[]) {
        int[][] dp = new int[s.length + 1][t.length + 1];
        for (int i = 0; i <= s.length; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i <= t.length; i++) {
            dp[0][i] = 0;
        }
        for (int i = 1; i <= s.length; i++) {
            for (int j = 1; j <= t.length; j++) {
                if (s[i - 1] == t[j - 1]) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Integer.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        char ans[] = new char[26];
        for (int i = 0; i < dp[s.length][t.length]; i++) {
            ans[i++] = '$';
        }
        int index = dp[s.length][t.length];
        int i = s.length, j = t.length;
        while (i > 0 && j > 0) {
            if (s[i - 1] == t[j - 1]) {
                ans[index] = s[i - 1];
                index--;
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }
        for (int k = 0; k < dp[s.length][t.length]; k++) {
            System.out.print(ans[k]);
        }
    }

    public static int LongestComSubset(char[] s, char[] t) {
        int[][] dp = new int[s.length + 1][t.length + 1];
        for (int i = 0; i <= s.length; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i <= t.length; i++) {
            dp[0][i] = 0;
        }
        int max = 0;
        for (int i = 1; i <= s.length; i++) {
            for (int j = 1; j <= t.length; j++) {
                if (s[i - 1] == t[j - 1] && dp[i - 1][j - 1] != 0) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    if (dp[i][j] > max) {
                        max = dp[i][j];
                    }
                } else if (s[i - 1] == t[j - 1] && dp[i - 1][j - 1] == 0) {
                    dp[i][j] = 1;
                    if (dp[i][j] > max) {
                        max = dp[i][j];
                    }
                }
            }
        }
        return max;
    }
    public static int lcs(String str1, String str2){
        // Write your code here.
        char[] s = str1.toCharArray() ;
        char[] t = str2.toCharArray() ;

        return LongestComSubset(s , t);
    }


    public StringBuilder LCS(char[] s , char[] t){
        int[][] dp = new int[s.length+1][t.length+1];
        for(int i = 0 ; i <= s.length ; i++ ){
            dp[i][0] = 0 ;
        }
        for(int i = 0 ; i <= t.length ; i++ ){
            dp[0][i] = 0 ;
        }
        int max = 0 ;
        for(int i = 1 ; i <= s.length ; i++){
            for(int j = 1 ; j <= t.length ; j++){
                if(s[i-1] == t[j-1]){
                    dp[i][j] = 1 + dp[i-1][j-1];
                    if(dp[i][j] > max){
                        max = dp[i][j];
                    }
                }else{
                    dp[i][j] = 0 ;
                }
            }
        }
        int i = 0 , j = 0 ;
        while(dp[i][j] != max){
            i++ ; j++ ;
        }
        StringBuilder ans = new StringBuilder();
        while(max>0){
            ans.append(s[i--]);
        }
        return ans ;
    }


    public static int minInsertion(String str) {
        // Write your code here.
        char[] s = str.toCharArray() ;
        char[] t = str.toCharArray() ;
        Stack<Character> st = new Stack<>();
        for(int i = 0 ; i < t.length ; i++){
            st.push(t[i]);
        }
        for(int i = 0 ; i < t.length ; i++){
            t[i] = st.peek();
            st.pop();
        }
        int[][] dp = new int[s.length+1][t.length+1];
        for(int i = 0 ; i <= s.length ; i++){
            dp[i][0] = 0 ;
        }
        for(int i = 0 ; i <= t.length ; i++){
            dp[0][i] = 0 ;
        }
        int max = 0 ;
        for(int i = 1 ; i <= s.length ; i++){
            for(int j = 1 ; j <= t.length ; j++){
                if(s[i-1] == t[j-1]){
                    dp[i][j] = 1+ dp[i-1][j-1];
                    if(dp[i][j] > max){
                        max= dp[i][j];
                    }
                }else{
                    dp[i][j] = 0 ;
                }
            }
        }
        return s.length - max ;
    }
}
