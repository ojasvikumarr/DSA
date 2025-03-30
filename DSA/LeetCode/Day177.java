package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day177 {
    class Solution {
    public List<Integer> partitionLabels(String s) {
        Map<Character , Integer> map = new HashMap<>();
        for(char c : s.toCharArray()){
            map.put(c , map.getOrDefault(c , 0)+1);
        }
        List<Integer> res = new ArrayList<>();
        int i = 0 ; 
        int n = s.length();
        Map<Character , Integer> sec = new HashMap<>();
        int sorted = 0 ; 
        int l = 0 ; 
        while(i < n){
            char c = s.charAt(i);
            sec.put(c , sec.getOrDefault(c , 0)+1);
            int freq = map.get(c);
            if(freq == 1){
                map.remove(c);
                sorted++ ; 
            }else{
                map.put(c , freq-1);
            }
            if(sorted == sec.size()){
                res.add(i-l+1);
                l = i+1 ; 
                sec = new HashMap<>();
                sorted = 0 ; 
            }
            i++ ;
        }
        return res ;
    }
}
}
