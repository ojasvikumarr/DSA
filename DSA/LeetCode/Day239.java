package LeetCode;

public class Day239 {
    class Solution {
    public int candy(int[] nums) {
        int n = nums.length ; 
        int ans = 0 ; 
        int[] res = new int[n];
        for(int i = 1 ; i < n ; i++){
            if(nums[i-1] < nums[i]){
                res[i] = res[i-1] + 1; 
            }
        }

        for(int i = n-1 ; i > 0 ; i--){
            if(nums[i-1] > nums[i]){
                res[i-1] = Math.max(res[i] + 1 , res[i-1]);
            }
            ans += res[i-1];
        }
        return ans + n + res[n-1];
    }
    public int candyII(int[] nums) {
        int n = nums.length ;
        int[] res = new int[n];
        int counter = 0 ; 
        for(int i = 0 ; i < n-1 ; i++){
            if((nums[i] < nums[i+1]) || (i > 0 && (nums[i-1] < nums[i]) && (nums[i] == nums[i+1]))){
                res[i] = counter ; 
                counter++ ; 
            }else{
                counter = 0; 
            }
        }
        if(n > 1 && nums[n-2] < nums[n-1]){
            res[n-1] = counter ;
        }
        // for(int ele : res){
        //      System.out.print(ele + " ");
        //     //  ans += ele ;
        // } 
        // System.out.println();
        counter = 0 ; 
        for(int i = n-1 ; i > 0 ; i--){
            if(nums[i-1] > nums[i]){
                res[i-1] = res[i]+1; 
                if(i > 1 && res[i-2] != 0 && nums[i-2] < nums[i-1]){
                    res[i-1] = Math.max(res[i-2], res[i])+ 1 ;
                }
                // // counter++ ; 
            }else{
                counter = 0 ; 
            }
        }
        int ans = 0 ; 
        for(int ele : res){
            //  System.out.print(ele + " ");
             ans += ele ;
        } 
        ans += n ; 
        return ans ; 
    }
}
}
