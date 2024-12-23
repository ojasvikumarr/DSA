package Graphs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class GardenFlowering {
    class Solution {
    public int[] gardenNoAdj(int n, int[][] paths) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for(int i = 0 ;i < n ; i++) map.put(i , new HashSet<>());
        for(int[] path :paths){
            map.get(path[0] - 1).add(path[1] - 1);
            map.get(path[1] - 1).add(path[0] - 1);
        }
        int[] result = new int[n];
        for(int i = 0 ; i < n ; i++){
            int[] colors = new int[5];
            for(int j : map.get(i)){
                colors[result[j]] = 1 ; 
            }
            for(int c = 4 ; c > 0 ; c--){
                if(colors[c] == 0) result[i] = c ;
            }
        }
        return result ;
    }
}
}
