package LeetCode ;


public class Day116 {
    class Solution {
        public boolean isArraySpecial(int[] nums) {
            int n = nums.length ; 
            if( n == 1 ) return true ; 
            boolean flag = nums[0] % 2 == 0 ? true : false; 
            for(int i = 1 ; i < n; i++){
                if(flag == true){
                    //we need to have an odd number 
                    if(nums[i] % 2 == 0){
                        //that we again have even 
                        return false ;
                    }else{
                        flag = false ; 
                    }
                }else{
                    //we need to have even now 
                    if(nums[i] % 2 != 0){
                        //that we again got odd 
                        return false ; 
                    }else{
                        flag = true ; 
                    }
                }
            }
            return true ; 
        }
    }
}
