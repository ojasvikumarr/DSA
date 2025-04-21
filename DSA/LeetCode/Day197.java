package LeetCode;

public class Day197 {
    class Solution {
        public int numberOfArrays(int[] differences, int lower, int upper) {
            long mini = 0 ; 
            long maxi = 0 ; 
            long t = 0 ; 
            for(int ele : differences){
                t += ele ; 
                mini = Math.min(mini , t);
                maxi = Math.max(maxi , t);
            }
    
            // int upperLimit = upper - maxi ; 
            // int lowerLimit = lower - mini ; 
    
            // if(upperLimit < lower || lowerLimit > upper){
            //     return 0 ; 
            // }else{
            //     return Math.abs(lowerLimit - upperLimit) + 1;
            // }
            return (int)Math.max(0, (upper - maxi) - (lower - mini) + 1);
        }
    
    }
}
