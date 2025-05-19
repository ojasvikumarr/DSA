package LeetCode;
public class Day225 {
    class Solution {
    public String triangleType(int[] nums) {
        int a = nums[0];
        int b = nums[1];
        int c = nums[2];
        if( a < b + c && b < c + a && c < b + a){
            int count = 0 ; 
            if(a == b)count++ ;
            if(b == c)count++ ;
            if(c == a)count++ ;
            if(count == 3){
                return "equilateral";
            }else if(count == 1){
                return "isosceles";
            }else{
                return "scalene";
            }
        }else{
            return "none";
        }
        //hello
        // return "";
    }
}
}
