package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

public class ColorFreq {
    class Solution {
    public int largestPathValue(String colors, int[][] edges) {
        int n = colors.length() ; 
        int[] indegree = new int[n];
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            graph.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            graph.get(edge[0]).add(edge[1]);
            indegree[edge[1]] ++ ;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0 ; i < n ; i++){
            if(indegree[i] == 0) q.add(i);
        }
        int[][] counts = new int[n][26];

        for(int i = 0 ; i < n ; i++){
            counts[i][colors.charAt(i) - 'a']++ ;
        }
        int maxCount = 0 ;
        int visited = 0 ; 
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0 ; i < size ; i++){
                int curr = q.poll();
                visited++ ;
                for(Integer neighbor : graph.get(curr)){
                    for(int color = 0 ; color < 26; color++){
                        counts[neighbor][color] = Math.max(counts[neighbor][color] , counts[curr][color] + (colors.charAt(neighbor) - 'a' == color ? 1 : 0));
                    }
                    indegree[neighbor]-- ; 
                    if(indegree[neighbor] == 0) q.add(neighbor);
                }
                maxCount = Math.max(maxCount , Arrays.stream(counts[curr]).max().getAsInt());
            }
        }

        return visited == n ? maxCount : -1 ;
    }
}
}
