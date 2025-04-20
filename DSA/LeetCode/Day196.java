package LeetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Day196 {
    class Solution {
    public int numRabbits(int[] answers) {
        Map<Integer , Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        for(int a : answers){
            map.put(a , map.getOrDefault(a , 0) + 1);
            set.add(a);
        }
        int res = 0 ; 
        for(int ele : set){
            int f = map.get(ele);
            int val = (int)(Math.ceil((double)f/(ele+1))*(ele+1));
            res += val ; 
        }
        return res ;
    }
}
}
