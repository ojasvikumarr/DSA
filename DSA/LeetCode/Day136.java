package LeetCode;

import java.util.HashSet;
import java.util.Set;

public class Day136 {
    class Solution {
    public String findDifferentBinaryString(String[] nums) {
        Set<String> set = new HashSet<>();
        for(String str : nums) set.add(str);
        int n = nums[0].length();
        for(int i = 0 ; i < (1<<n) ; i++){
            String binaryString = String.format("%" + n + "s" ,Integer.toBinaryString(i)).replace(' ' , '0');
            if(!set.contains(binaryString)){
                return binaryString ;
            }
        }
        return "";
    }
}
}
