package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PossibleBipartition {
    class Solution {
    //Not a good approach 
    public boolean possibleBipartitionII(int n, int[][] dislikes) {
        List<Integer> grp1 = new ArrayList<>();
        List<Integer> grp2 = new ArrayList<>();
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i = 0 ; i <= n ; i++) adjList.add(new ArrayList<>());
        for(int[] dislike : dislikes){
            int a = dislike[0];
            int b = dislike[1];
            adjList.get(a).add(b);
            adjList.get(b).add(a);
        }
        for(int i = 1 ; i <= n ; i++){
            boolean flag1 = false ;
            boolean flag2 = false ;
            for(Integer disliked : adjList.get(i)){
                if(grp1.contains(disliked)) flag1 = true ;
                if(grp2.contains(disliked)) flag2 = true ;
            }
            if(!flag1){
                grp1.add(i);
            }else if(!flag2){
                grp2.add(i);
            }else{
                return false ;
            }
        }
        return true ;
    }
    public boolean possibleBipartition(int n, int[][] dislikes) {
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i = 0 ; i <= n ; i++) adjList.add(new ArrayList<>());
        for(int[] dislike : dislikes){
            int a = dislike[0];
            int b = dislike[1];
            adjList.get(a).add(b);
            adjList.get(b).add(a);
        }
        int[] color = new int[n+1];
        Arrays.fill(color , -1);

        for(int i = 1 ; i <= n ; i++){
            if(color[i] == -1 && !dfs(adjList , 0 , color , i)){
                return false ;
            }
        }
        return true ;
    }
    public boolean dfs(List<List<Integer>> adjList , int prevColor , int[] color , int src){
        color[src] = prevColor == 0 ? 1 : 0 ;
        for(Integer neighbor : adjList.get(src)){
            if(color[neighbor] == -1){
                if(!dfs(adjList , color[src] ,color , neighbor)) return false;
            }else if(color[neighbor] == color[src]){
                return false ;
            }
        }
        return true ;
    }
}
}
