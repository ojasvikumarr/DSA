package LeetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Day174 {
    class Solution {
    public int minOperations(int[][] grid, int x) {
        List<Integer> ls = new ArrayList<>();
        for(int i = 0 ; i < grid.length ; i++){
            for(int j = 0 ; j < grid[0].length ; j++){
                ls.add(grid[i][j]);
            }
        }
        Collections.sort(ls);
        int median = 0 ; 
        // if(ls.size() % 2 == 0){
            median = ls.get((ls.size()-1)/2);
        // }
        int changes = 0 ; 
        for(Integer ele : ls){
            int diff = Math.abs(ele-median) ;
            if(diff % x != 0) return -1 ; 
            changes += diff/x ;
        }
        return changes ;
    }
    public int minOperationsII(int[][] grid, int x) {
        if(grid.length == 1 && grid[0].length == 1) return 0 ; 
        List<Integer> ls = new ArrayList<>();
        long sum = 0 ; 
        for(int i = 0 ; i < grid.length ; i++){
            for(int j = 0 ; j < grid[0].length ; j++){
                ls.add(grid[i][j]);
                sum += grid[i][j];
                if(grid[i][j] % x != 0) return -1 ;
            }
        }
        //this ensure that all are the multiple of x in grid 
        int elements = ls.size();
        int avgMin = (int)Math.ceil(((double)sum/elements)/x);
        int avgMax = (int)Math.floor(((double)sum/elements)/x);

        int res1 = 0 ; 
        int res2 = 0 ; 
        for(Integer ele : ls){
            res1 += Math.abs(ele/x - avgMin) ; 
            res2 += Math.abs(ele/x - avgMax) ; 
        }
        return Math.min(res1 , res2);
    }
}
}
