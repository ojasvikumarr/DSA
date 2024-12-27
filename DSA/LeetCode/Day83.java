package LeetCode;

public class Day83 {
    class Solution {
        public int maxScoreSightseeingPair(int[] values) {
            int n = values.length ;
            int[] preMax = new int[values.length];
            int[] sufMax = new int[values.length];
            
            for(int i = 0 ; i < n ; i++){
                preMax[i] = values[i] + i ; 
                sufMax[i] = values[i] - i ; 
            }
    
            //Now we'll be making the desired array 
    
            for(int i = 1 ; i < n ; i++){
                preMax[i] = Math.max(preMax[i] , preMax[i-1]);
                sufMax[n-i-1] = Math.max(sufMax[n-i-1] , sufMax[n-i]);
            }
            
            int maxi = 0 ;
    
            for(int i = 0 ; i < n-1 ; i++){
                maxi = Math.max(maxi , preMax[i] + sufMax[i+1]);
            }
    
            return maxi ;
        }
    }
}
