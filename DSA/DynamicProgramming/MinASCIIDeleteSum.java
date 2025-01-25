package DynamicProgramming;

public class MinASCIIDeleteSum {
    class Solution {
        public int minimumDeleteSum(String s1, String s2) {
            int n = s1.length();
            int m = s2.length();
            int[][] dp = new int[n+1][m+1];
    
            for(int i = 1 ; i <= n ; i++){
                for(int j = 1 ; j <= m ; j++){
                    if(s1.charAt(i-1) == s2.charAt(j-1)){
                        dp[i][j] = dp[i-1][j-1] + s1.charAt(i-1);
                    }else{
                        dp[i][j] = Math.max(dp[i-1][j] , dp[i][j-1]);
                    }
                }
            }
            //Now we have the ASCII of the LCS with highest ASCII value ;
    
            int ASCII = dp[n][m];
    
            int totalSum = 0 ; 
            for(char c : s1.toCharArray()) totalSum += c ; 
            for(char c : s2.toCharArray()) totalSum += c ; 
            return totalSum - 2*ASCII ;
        }
        public int minimumDeleteSumII(String s1, String s2) {
            int n = s1.length();
            int m = s2.length();
            int[][] tab = new int[n+1][m+1];
            for(int i = 1 ; i <= n ; i++){
                for(int j = 1 ; j <= m ;j++){
                    if(s1.charAt(i-1) == s2.charAt(j-1)){
                        tab[i][j] = tab[i-1][j-1] + 1 ;
                    }else{
                        tab[i][j] = Math.max(tab[i-1][j] , tab[i][j-1]);
                    }
                }
            }
            StringBuilder sb = new StringBuilder();
            int[] freqMain = new int[26];
            int count = 0 ;
            int i = n ; 
            int j = m ; 
            while( i > 0 && j > 0 ){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    sb.append(s1.charAt(i-1));
                    freqMain[s1.charAt(i-1) - 'a']++ ;
                    count += s1.charAt(i-1);
                    i-- ; 
                    j-- ; 
                }else if(tab[i-1][j] > tab[i][j-1]){
                    i-- ;
                }else if(tab[i-1][j] < tab[i][j-1]){
                    j-- ;
                }else{
                    if((s1.charAt(i-1) - s2.charAt(j-1)) > 0){
                        j-- ;
                    }else{
                        i-- ;
                    }
                } 
            }
            System.out.println(sb);
    
            
            //Now we got the LCS one so we need to compare the ramaining from the two strings 
            int totalASCII = 0 ; 
            int[] freqA = new int[26];
            for(char c : s1.toCharArray()){
                freqA[c-'a']++ ;
                totalASCII += c ;
            }
            
            int[] freqB = new int[26];
            for(char c : s2.toCharArray()){
                freqB[c-'a']++ ;
                totalASCII += c ; 
            }
            
            return totalASCII - 2*count ;
        }
    }
}
