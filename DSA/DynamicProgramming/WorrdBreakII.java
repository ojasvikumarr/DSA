package DynamicProgramming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WorrdBreakII {
    class Solution {
    List<String> res;
    Map<Integer, List<String>> memo;

    public List<String> wordBreak(String s, List<String> wordDict) {
        res = new ArrayList<>();
        memo = new HashMap<>();
        return backTrack(s, 0, wordDict);
    }

    public List<String> backTrack(String s, int idx, List<String> Dict) {
        if (memo.containsKey(idx)) {
            return memo.get(idx); 
        }
        List<String> result = new ArrayList<>();
        if (idx == s.length()) {
            result.add(""); 
            return result;
        }

        for (int i = idx; i < s.length(); i++) {
            String str = s.substring(idx, i + 1);
            if (Dict.contains(str)) {
                List<String> subResults = backTrack(s, i + 1, Dict);
                for (String sub : subResults) {
                    if (sub.isEmpty()) {
                        result.add(str);
                    } else {
                        result.add(str + " " + sub);
                    }
                }
            }
        }

        memo.put(idx, result); 
        return result;
    }
    // List<String> res ;
    // Map<Integer , StringBuilder> map ;
    // public List<String> wordBreak(String s, List<String> wordDict) {
    //     res = new ArrayList<>();
    //     map = new HashMap<>();
    //     backTrack(s , 0 , wordDict , new StringBuilder());
    //     return res ;
    // }
    // public void backTrack(String s , int idx , List<String> Dict , StringBuilder sb){
    //     if(idx == s.length()){
    //         res.add(sb.toString());
    //         return ;
    //     }
    //     if(map.containsKey(idx)) {
    //         sb.append(" "+map.get(idx));
    //         return ;
    //     }
    //     int lenBefore = sb.length();
    //     for(int i = idx ; i < s.length() ; i++){
    //         String str = s.substring(idx , i+1);
    //         if(Dict.contains(str)){
    //             if(sb.length() != 0) sb.append(" ");
    //             sb.append(str);
    //             backTrack(s , i+1 , Dict , sb);
    //             // sb.delete(sb.length() - i + idx -1 , sb.length()-1);
    //             map.put(idx , new StringBuilder(sb));
    //             sb.setLength(lenBefore);
    //         }
    //     }
    // }
}
}
