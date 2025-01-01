package Graphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.* ;

public class StrangerPrinterII {
    class Solution {
    public boolean isPrintable(int[][] targetGrid) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] indegree = new int[61];
        // because 0 <= color<= 60 so maximum number of colors that the graph can have is 61
        for(int i = 0 ; i <= 60 ; i++) graph.add(new ArrayList<>());
        //Because the colors are starting from 1 to 60
        //we check for every color
        for(int i = 1 ; i <= 60 ; i++) search(targetGrid , i , graph , indegree);

        Queue<Integer> zeros = new LinkedList<>();
        Set<Integer> seen = new HashSet<>();
        for(int i = 0 ; i < indegree.length ; i++){
            if(indegree[i] == 0){
                zeros.add(i);
            }
        }
        //Normal Kahn Algorithm to find topological sort 
        while(!zeros.isEmpty()){
            int curr = zeros.poll();
            if(!seen.add(curr)) continue ;

            for(Integer neighbor : graph.get(curr)){
                indegree[neighbor]-- ;
                if(indegree[neighbor] == 0){
                    zeros.add(neighbor);
                }
            }
        }
        return seen.size() == 61 ;
    }
    private void search(int[][] grid , int color , List<List<Integer>> graph , int[] indegree){
        //This function is finding the maximum boundries of the color in the matrix
        int minX = Integer.MAX_VALUE ;
        int minY = Integer.MAX_VALUE ;
        int maxX = Integer.MIN_VALUE ;
        int maxY = Integer.MIN_VALUE ;

        for(int i = 0 ; i < grid.length ; i++) 
            for(int j = 0 ; j < grid[0].length ; j++){
                if(grid[i][j] == color){
                    minX = Math.min(minX , i);
                    minY = Math.min(minY , j);
                    maxX = Math.max(maxX , i);
                    maxY = Math.max(maxY , j);
                }
            }
//If minX == Integer.MAX_VALUE then this means that there was no tile of that color
        if(minX == Integer.MAX_VALUE) return ; 

//We are checking whether the rectangle formed is having 
//Homogeneous color or not 
//If not then we add the color to graph
//And increase its indegree 
        for(int i = minX ; i <= maxX ; i++)
            for(int j = minY ; j <= maxY ; j++){
                if(grid[i][j] != color){
                    graph.get(grid[i][j]).add(color);
                    indegree[color]++ ;
                }
            }
    }
}
}
