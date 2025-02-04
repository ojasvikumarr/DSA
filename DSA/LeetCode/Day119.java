package LeetCode ; 
import java.util.* ; 

public class Day119 {
    class Solution {
        public int maxAscendingSum(int[] nums) {
            int maxi = 0 ; 
            int count = 0 ; 
            int n = nums.length ;
            for(int i = 0 ; i < nums.length ; i++){
                count+= nums[i];
                maxi = Math.max(maxi , count);
                if(i+1 < n && nums[i] >= nums[i+1]){
                    count = 0 ; 
                }
            }
            return maxi ;
        }
    }
}
