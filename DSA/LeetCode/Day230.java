package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class Day230 {
    class Solution {
    public List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> ans = new ArrayList<>();
        for(int i = 0 ; i < words.length ; i++ ){
            String word = words[i];
            for(char c : word.toCharArray()){
                if(c == x){
                    ans.add(i);
                    break ; 
                }
            }
        }
        return ans ; 
    }
}
}
