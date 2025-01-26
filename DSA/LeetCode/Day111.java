package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Day111 {
    class Solution {
    public int maximumInvitations(int[] favorite) {
        int people = favorite.length ; 
        List<List<Integer>> revGraph = new ArrayList<>();
        for(int i = 0 ; i < people ; i++){
            revGraph.add(new ArrayList<>());
        }
        for(int person = 0 ; person < people ; person++){
            revGraph.get(favorite[person]).add(person);
        }

        int longestCycle = 0 ; 
        int twoCycleInvitations = 0 ; 
        boolean[] visited = new boolean[people];

        for(int p = 0 ; p < people ; p++){
            if(!visited[p]){
                Map<Integer, Integer> visitedPersons = new HashMap<>();
                int currPerson = p ; 
                int dist = 0 ; 
                while(true){
                    if(visited[currPerson]) break ; 
                    visited[currPerson] = true ;
                    visitedPersons.put(currPerson , dist++);
                    int nextPerson = favorite[currPerson];

                    //cycle detected 
                    if(visitedPersons.containsKey(nextPerson)){
                        int cycleLength = dist - visitedPersons.get(nextPerson);
                        longestCycle = Math.max(longestCycle , cycleLength);

                        //Handle Cycle of length 2 
                        if(cycleLength == 2){
                            Set<Integer> visitedNodes = new HashSet<>();
                            visitedNodes.add(currPerson);
                            visitedNodes.add(nextPerson);
                            twoCycleInvitations += 2 + bfs(nextPerson , visitedNodes , revGraph) + bfs(currPerson , visitedNodes , revGraph);
                        }
                        break ; 
                    }
                    currPerson = nextPerson ; 
                }
            }
        }
        return Math.max(longestCycle , twoCycleInvitations);
    }
    public int bfs(int startNode , Set<Integer> visited , List<List<Integer>>revGraph){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{startNode , 0});
        int max = 0 ; 

        while(!q.isEmpty()){
            int[] curr = q.poll();
            int currNode = curr[0];
            int currDist = curr[1];
            for(int neighbor : revGraph.get(currNode)){
                if(visited.contains(neighbor)) continue ; 
                visited.add(neighbor);
                q.offer(new int[]{neighbor , currDist+1});
                max = Math.max(max , currDist+1);
            }
        }
        return max ;
    }
}
}
