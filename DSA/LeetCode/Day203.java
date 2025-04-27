package LeetCode;

public class Day203 {
    class Solution {
        public int countSubarrays(int[] nums) {
            int n = nums.length ;
            int count = 0 ; 
            for(int i = 0 ; i < n-2 ; i++){
                int first = nums[i];
                int sec = nums[i+1];
                int thir = nums[i+2];
                if(sec/2 != (double)sec/2) continue ;
                if((first+thir) == sec/2) {
                    count++ ;
                    System.out.println(first +" "+ sec+" "+thir);
                 }
            }
            return count ; 
        }
    }
}
