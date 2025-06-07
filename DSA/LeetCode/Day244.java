package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class Day244 {
    class Solution {
    int[] parent ;
    int[] rank ;
    public void init(){
        parent = new int[26];
        rank = new int[26];
        for(int i = 0 ; i < 26 ; i++){
            rank[i] = i ; 
            parent[i] = i ; 
        }
    }
    public int find(int x){
        if(parent[x] == x){
            return x ; 
        }
        return parent[x] = find(parent[x]);
    }
    public void union(int u ,int v){
        int parU = find(u);
        int parV = find(v);
        if(parU != parV){
            if(parU > parV){
                parent[parU] = parV ;
            }else{
                parent[parV] = parU ;
            }
        }
    }

    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        int i = 0 ; 
        int n = s1.length() ; 
        init();
        while(i < n){
            int u = s1.charAt(i) - 'a';
            int v = s2.charAt(i) - 'a';
            union(u , v);
            i++ ;
        }

        List<Integer> ls = new ArrayList<>();
        for(char c : baseStr.toCharArray()){
            int val = find(c-'a');
            ls.add(val);
        }
        // for(i = 0 ; i < 26 ; i++){
        //     // find(i);
        //     System.out.print(parent[i] + " ");
        // }
        StringBuilder sb = new StringBuilder();
        for(int ele : ls){
            sb.append((char)(ele +'a'));
        }
        return sb.toString();
    }
}
}
