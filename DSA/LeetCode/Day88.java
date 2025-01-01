package LeetCode;

public class Day88 {
    class Solution {
        public int maxScore(String s) {
            int n = s.length();
            int[] zeroSum = new int[n];
            int[] oneSum = new int[n];
            if(s.charAt(0) == '0') zeroSum[0] = 1 ;
            if(s.charAt(n-1) == '1') oneSum[n-1] = 1 ;
            for(int i = 1 ; i < n ; i++){
                if(s.charAt(i) == '0'){
                    zeroSum[i] = zeroSum[i-1] + 1 ;
                }else{
                    zeroSum[i] = zeroSum[i-1] ;
                }
                if(s.charAt(n-i-1) == '1'){
                    oneSum[n-i-1] = oneSum[n-i] + 1 ;
                }else{
                    oneSum[n-i-1] = oneSum[n-i] ;
                }
            }
    
            int maxi = 0 ; 
            for(int i = 0 ; i < n-1 ; i++){
                maxi = Math.max(maxi , zeroSum[i] + oneSum[i+1]);
            }
    
            return maxi ;
        }
    }
}
