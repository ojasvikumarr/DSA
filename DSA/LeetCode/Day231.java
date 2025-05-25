package LeetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Day231 {
    class Solution {
    public int longestPalindrome(String[] words) {
        Map<String , Integer> map = new HashMap<>();
        for(String word : words){
            map.put(word , map.getOrDefault(word , 0)+1);
        }

        int res = 0 ;   
        boolean flag = true ; 
        for(String key : map.keySet()){
            StringBuilder sb = new StringBuilder(key);
            sb.reverse();
            int freqA = map.get(key);
            int freqB = map.getOrDefault(sb.toString() , 0);
            int val = Math.min(freqA ,freqB)*2; 
            if(key.equals(sb.toString())&& freqA%2 !=0){
                //they are same and if the freq is odd , then this combination will only occur once    
                if(flag == true ){
                    res += val ; 
                    flag = false ; 
                }else{
                    res += val - 2; 
                }
            }
            else{
                res += val ;
            }
        }
        return res ;
    }
}
}
