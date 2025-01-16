package LeetCode;

public class Day102 {
    class Solution {
        public int xorAllNums(int[] nums1, int[] nums2) {
            int n = nums1.length ; 
            int m = nums2.length ; 
            if(n%2 == 0 && m %2 == 0) return 0 ; 
            int ans = 0 ; 
            if(n%2 ==0){
                //Answer will be xor of all the elements of num1
                for(Integer num : nums1){
                    ans ^= num ;
                }
            }else if( m%2 == 0){
                //Answer will be xor of all the elements of num2 
                for(Integer num : nums2){
                    ans ^= num ;
                }
            }else{
                //Answer will be xor of num1 elements and num2 elements ;
                for(Integer num : nums2){
                    ans ^= num ;
                }
                for(Integer num : nums1){
                    ans ^= num ;
                }
            }
            return ans ; 
        }
    }
}
