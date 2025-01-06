package LeetCode ;

public class Day93 {
    class Solution {
        public int[] minOperations(String boxes) {
            int n = boxes.length() ;
            if(n == 1) return new int[]{0} ; 
            int[] leftSum = new int[n] ;
            int[] rightSum = new int[n] ;
            for(int i = 0 ; i < n ; i++){
                leftSum[i] = Integer.valueOf(boxes.charAt(i) - '0');
                rightSum[i] = Integer.valueOf(boxes.charAt(i) - '0');
            }
            //cumulative sum 
            for(int i = 1 ; i < n ; i++){
                leftSum[i] += leftSum[i-1] ;
                rightSum[n-i-1] += rightSum[n-i] ;
            }
            //cumulative sum again for knowning how many swaps
            for(int i = 1 ; i < n ; i++){
                leftSum[i] += leftSum[i-1] ;
                rightSum[n-i-1] += rightSum[n-i] ;
            }
    
            int[] result = new int[n];
            result[0] = rightSum[1];
            for(int i = 1 ; i < n-1 ; i++){
                result[i] = leftSum[i-1] + rightSum[i+1];
            }
            result[n-1] = leftSum[n-2];
            return result ;
        }
    }
}
