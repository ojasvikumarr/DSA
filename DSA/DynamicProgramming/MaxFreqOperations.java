package DynamicProgramming;

public class MaxFreqOperations {
    class Solution {
        public int maxFrequency(int[] nums, int k) {
            int maxi = 0 ; 
            //We need the freq 
            for(int i = 1 ; i <= 50 ; i++){
                maxi = Math.max(maxi , solve(nums , k , i));
            }
            return maxi ; 
        }
        public int solve(int[] nums , int k , int target){
            int maxi = 0 ; 
            int curr = 0 ; 
            int freqK = 0 ; 
            for(Integer num : nums){
                if(num == k){
                    curr -= 1 ; 
                    freqK++ ;
                }else if(num == target){
                    curr += 1 ;
                }
    
                if(curr <0){
                    curr = 0 ; 
                }
                maxi = Math.max(maxi , curr);
            }
            return maxi + freqK; 
        }
    }
}
