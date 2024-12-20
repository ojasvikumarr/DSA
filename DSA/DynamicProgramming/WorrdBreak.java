package DynamicProgramming;

import java.util.Arrays;
import java.util.List;

public class WorrdBreak {
    class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int[] dp = new int[s.length()+1];
        Arrays.fill(dp , -1);
        return backTrack(s , 0 , wordDict , dp);
    }
    public boolean backTrack(String s , int idx , List<String> wordDict , int[] dp ){
        if(idx == s.length()){
            return true ;
        }

        if(dp[idx] != -1) return dp[idx] == 1 ? true : false ;

        boolean flag = false;
        for(int i = idx ; i < s.length() ; i++){
            String sub = s.substring(idx , i+1);
            if(wordDict.contains(sub)){
                flag |= backTrack(s , i+1 , wordDict , dp) ;
            }
        }
        dp[idx] = flag ? 1 : 0;
        return  dp[idx] == 1 ? true : false; 
    }
}
}
