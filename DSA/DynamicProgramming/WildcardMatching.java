package DynamicProgramming;

public class WildcardMatching {
    public boolean Tab(String s1 , String s2){
        char[] s = s1.toCharArray();
        char[] t = s2.toCharArray();
        int[][] dp = new int[s.length+1][t.length+1];
        dp[0][0] = 1 ;
        for(int i = 1 ; i<= s.length ; i++){
            for(int j = 1 ; j <= t.length ; j++){
                if(s[i-1] == t[j-1] || s[i-1] == '?'){
                    dp[i][j] = dp[i-1][j-1];
                }else if(s[i-1] == '*'){
                    dp[i][j] = 1 ;                    
                }else{
                    return false ;
                }
            }
        }

        return dp[s.length][t.length] == 1 ? true : false ;
    }

    public boolean func (String s1 , String s2){
        return recurr(s1.length(),s2.length() ,s1.toCharArray(), s2.toCharArray());
    }
    public boolean recurr(int i , int j , char[] s , char[] t){
        if(i < 0 && j < 0) return true ;
        if(j<0 && i>= 0){
            for(int k = 0 ; k <= i ; k++){
                if(s[k] != '*') return false ;
            }
            return true ;
        }
        if(j>=0 && i < 0){
            for(int k = 0 ; k <= j ; k++){
                if(t[k] != '*') return false ;
            }
            return true ;
        }
        if(s[i] == t[j] || s[i] == '?' || t[j] == '?'){
            return recurr(i-1, j-1, s, t);
        }
        if(s[i] == '*' || t[j] == '*'){
            return recurr(i-1, j, s, t) || recurr(i, j-1, s, t);
        }
        return false ;
    }
    public boolean tabulation(String s1 , String s2){
        char[] s = s1.toCharArray() ;
        char[] t = s2.toCharArray() ;

        int[][] dp = new int[s.length + 1][t.length + 1];
        for(int i = 1 ; i <= s.length ; i++){
            if(s[i-1] == '*'){
                dp[i][0] = 1 ;
            }
        }
        for(int i = 1 ; i <= t.length ; i++){
            if(t[i-1] == '*'){
                dp[0][i] = 1 ;
            }
        }
        dp[0][0] = 1 ;

        for(int i = 1 ; i <= s.length ; i++){
            for(int j = 1 ; j <= t.length ; j++){
                if(s[i-1] == t[j-1] || s[i-1] == '?' || t[j-1] == '?'){
                    dp[i][j] = dp[i-1][j-1];
                }
                if(s[i-1] == '*' || t[j-1] == '*'){
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
                dp[i][j] = 0 ;
            }
        }
        return dp[s.length][t.length] == 1 ? true : false ;
    }
}




//////////////////////////////////////
//failed dp approach
// class Solution {
//     public boolean isMatch(String s1 , String s2){
//         int[][] dp = new int[s1.length()][s2.length()];
//         for(int i = 0 ; i < s1.length() ; i++){
//             for(int j = 0 ; j < s2.length() ; j++){
//                 dp[i][j] = -1 ;
//             }
//         }
//         return recurr(s1.length()-1,s2.length()-1 ,s1.toCharArray(), s2.toCharArray() , dp);
//     }
//     public boolean recurr(int i , int j , char[] s , char[] t , int[][] dp){
//         if(dp[i][j] != -1) return dp[i][j] == 1 ? true : false ;
//         if(i < 0 && j < 0) return true ;
//         if(j<0 && i>= 0){
//             for(int k = 0 ; k <= i ; k++){
//                 if(s[k] != '*') return false ;
//             }
//             return true ;
//         }
//         if(j>=0 && i < 0){
//             for(int k = 0 ; k <= j ; k++){
//                 if(t[k] != '*') return false ;
//             }
//             return true ;
//         }

//         if(s[i] == t[j] || s[i] == '?' || t[j] == '?'){
//             return recurr(i-1, j-1, s, t , dp) ? dp[i][j] = 1 : dp[i][j] = 0;
//         }
//         if(s[i] == '*' || t[j] == '*'){
//             return (recurr(i-1, j, s, t , dp) || recurr(i, j-1, s, t , dp)) ? dp[i][j] = 1 : dp[i][j] = 0;
//         }
//         return false ;
//     }
// }