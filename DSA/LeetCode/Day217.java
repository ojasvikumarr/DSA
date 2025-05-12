package LeetCode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Day217 {
    class Solution {
    public int[] findEvenNumbers(int[] digits) {
        Set<Integer> set = new HashSet<>();
        int n = digits.length ; 
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                for(int k = 0 ; k < n ; k++){
                    if(i == j || j == k || k == i){
                        continue ; 
                    }
                    int val = digits[i]*100 + digits[j]*10 + digits[k];
                    if(val >= 100 && val %2 == 0){
                        set.add(val);
                    }
                }
            }
        }
        int[] res = new int[set.size()];
        int i = 0 ; 
        for(int ele : set){
            res[i++] = ele;
        }
        Arrays.sort(res);
        return res ; 
    }
}
}
