package DynamicProgramming;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
    class Solution {
    List<String> ans  ;
    public List<String> generateParenthesis(int n) {
        ans = new ArrayList<>();
        recur(new StringBuilder() , 0 , 0 , n);
        return ans ; 
    }
    public void recur(StringBuilder sb , int open , int close , int n ){
        if(open == n && close == n){
            ans.add(sb.toString());
            return ;
        }
        if(open < n){
            sb.append("(");
            recur(sb , open+1 , close , n);
            sb.deleteCharAt(sb.length()-1);
        }
        if(close < open){
            sb.append(")");
            recur(sb , open , close+1 ,n);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
}
