package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class Day245 {
    class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<>();
        for(int i = 1 ; i <= 9 ; i++){
            dfs(i , n , res);
        }
        return res ;
    }
    public void dfs(int curr , int limit , List<Integer> res){
        if(curr > limit) return ; 
        res.add(curr);
        for(int i = 0 ; i <= 9 ; i++){
            int next = curr*10 + i ; 
            if(curr <= limit){
                dfs(next , limit , res);
            }else{
                break ;
            }
        }
    }
}
}
