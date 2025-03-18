package LeetCode;

public class Day165 {
    class Solution {
        public int longestNiceSubarray(int[] nums) {
            int l = 0 ; 
            int r = 0 ; 
            int n = nums.length ; 
            int temp = 0 ; 
            int maxi = 0 ;
            while(r < n){
                while((temp&nums[r]) != 0){
                    temp ^= nums[l];
                    l++ ;
                }
                temp |= nums[r];
                maxi = Math.max(maxi , r-l+1);
                r++ ;
            }
            return maxi ; 
        }
    
        public int longestNiceSubarrayII(int[] nums) {
            int l = 0 ; 
            int r = 1 ; 
            int n = nums.length ; 
            int temp = nums[l] ;
            int maxi = 0 ; 
            while( r < n ){
                while(r < n && ((temp&nums[r]) == 0)){
                    temp = temp | nums[r];
                    r++ ;
                }
                maxi = Math.max(maxi , r - l );
                //Now either r has reached the end or we have broken the peace 
                while(r < n && l < n && (temp & nums[r]) != 0){
                    temp = (temp & ~nums[l]) ;
                    l++ ;
                }
            }
            return maxi ; 
        }
    }
}
