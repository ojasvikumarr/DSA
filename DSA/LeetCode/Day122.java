package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class Day122 {
    class Solution {
    public int tupleSameProduct(int[] nums) {
        Map<Integer , Integer> map = new HashMap<>();
        int n = nums.length ;
        for(int i = 0 ; i < n ; i++){
            for(int j = i+1 ; j < n ; j++){
                int prod = nums[i]*nums[j];
                map.put(prod , map.getOrDefault(prod , 0)+1);
            }
        }
        int result = 0 ; 
        for(Integer key : map.keySet()){
            int freq = map.get(key);
            System.out.println(freq);
            if(freq > 1){
                result += (freq*(freq-1)*4) ; 
            }
        }
        return result ;
    }
}
}
