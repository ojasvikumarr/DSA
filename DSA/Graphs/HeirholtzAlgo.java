package Graphs;

import java.util.HashSet;
import java.util.Set;

public class HeirholtzAlgo {
    class Solution {
    Set<String> seen ; 
    StringBuilder ans  ; 
    public String crackSafe(int n, int k) {
        //so the nodes in the graph are from 0 to k-1 
        //the password is of n digits 
        //that is k^n different combinations 
        //------------------------------------------//
        //My approach will be to make all possible combinations and stor the edges between two digits in a 2d arrray called edges 
        seen = new HashSet<>();
        ans = new StringBuilder();

        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < n-1 ; i++){
            sb.append("0");
        }
        String start = sb.toString();
        dfs(start , k);
        ans.append(start);
        return new String(ans);
    }
    public void dfs(String node , int k){
        for(int i = 0 ; i < k ; i++){
            String neww = node + i ; 
            if(!seen.contains(neww)){
                seen.add(neww);
                dfs(neww.substring(1) , k);
                ans.append(i);
            }
        }
    }
}
}
