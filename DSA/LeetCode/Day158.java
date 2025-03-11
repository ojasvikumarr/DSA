package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class Day158 {
    class Solution {
    public int numberOfSubstrings(String s) {
        int l = 0 ; 
        int r = -1 ; 
        int n = s.length();
        int result = 0 ; 
        Map<Character , Integer> map = new HashMap<>();
        while(l < n && r < n){
            //we will increment r till we get the three occurences 
            while(map.size() != 3 && r < n){
                r++ ; 
                if(r == n) break ; 
                char c = s.charAt(r);
                map.put(c , map.getOrDefault(c , 0)+1);
            }
            if(map.size() == 3){
                result += n - r  ; 
                // System.out.println(n + " " + r + " " + 1);
                //Now we increment l and discard the eleent at l position 
                char c = s.charAt(l);
                int freq = map.get(c);
                if(freq == 1) map.remove(c);
                else map.put(c , freq-1);
            }
            l++ ; 
        }
        return result ;
    }
    public int numberOfSubstringsII(String s) {
        int result = 0 ; 
        int n = s.length();
        for(int i = 0 ; i < n ; i++){
            for(int j = i+1 ; j < n ; j++){
                if(checkStr(s.substring(i , j+1))){
                    result++ ; 
                }
            }
        }
        return result ; 
    }

    public boolean checkStr(String sub){
        boolean a = false ;
        boolean b = false ; 
        boolean C = false ;
        for(char c : sub.toCharArray()){
            if(c == 'a') a = true ;
            if(c == 'b') b = true ; 
            if(c == 'c') C = true ; 
        }
        return a && b && C ; 
    }
}
}
