package Strings;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MaxKSUm {
    // import java.utils.* ; 
class Solution {
    public long maxSum(int[][] grid, int[] limits, int k) {
        PriorityQueue<PriorityQueue<Integer>> adjPq = new PriorityQueue<>((a , b) ->( b.peek() - a.peek()));
        int n = grid.length ; 
        
        for(int[] row : grid) {
            Integer[] roow = Arrays.stream(row).boxed().toArray(Integer[]::new);
            Arrays.sort(roow , (a , b) -> b - a);
            for(int i = 0 ;i < row.length ; i++) row[i] = roow[i];
        }
        
        for(int i = 0 ; i < n ; i++){
            int limit = limits[i];
            PriorityQueue<Integer> pq = new PriorityQueue<>((a , b) -> b - a);
            for(int j = 0 ; j < limit ; j++){
                pq.add(grid[i][j]);
            }
            if(!pq.isEmpty())
                adjPq.add(pq);
        }

        long sum = 0 ; 
        while(k > 0 && !adjPq.isEmpty()){
            PriorityQueue<Integer> q = adjPq.poll();
            sum += q.poll();
            if(!q.isEmpty()) adjPq.add(q);
            k-- ;
        }
        return sum ; 
    }
}
}
