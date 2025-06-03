package LeetCode;

import java.util.HashSet;
import java.util.Queue;
import java.util.Set;
import java.util.LinkedList;
public class Day240 {
    class Solution {
    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> keyAvailable = new HashSet<>();
        Set<Integer> boxAvailable = new HashSet<>();


        for (int box : initialBoxes) {
            boxAvailable.add(box);
            if (status[box] == 1) q.add(box);
        }

        int result = 0;

        while (!q.isEmpty()) {
            int box = q.poll();
            result += candies[box];

            // Add new keys to the keyAvailable set
            for (int key : keys[box]) {
                keyAvailable.add(key);
                if (boxAvailable.contains(key) && status[key] == 0) {
                    q.add(key);
                    status[key] = 1; // Unlock the box
                }
            }

            // Add contained boxes to the queue or mark them as available
            for (int containedBox : containedBoxes[box]) {
                boxAvailable.add(containedBox);
                if (status[containedBox] == 1 || keyAvailable.contains(containedBox)) {
                    q.add(containedBox);
                    status[containedBox] = 1; // Unlock the box
                }
            }
        }

        return result;
    }

    public int maxCandiesII(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        Queue<Integer> q = new LinkedList<>();
        for(Integer box : initialBoxes ){
            if(status[box] == 1 ) q.add(box);
        }
        Set<Integer> keyAvailable = new HashSet<>();
        int result = 0 ;
        boolean[] visited = new boolean[keys.length];
        boolean[] taken = new boolean[keys.length];
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0 ; i < size ; i++){
                int src = q.poll();
                result += candies[src];
                taken[src] = true ;
                for(Integer key : keys[src]) keyAvailable.add(key);
                for(Integer neighbor : containedBoxes[src]){
                    visited[neighbor] = true ;
                    if(status[neighbor] == 1 || (status[neighbor] == 0 && keyAvailable.contains(neighbor))){
                        q.add(neighbor);

                    }
                }
            }
        }
        for(Integer key : keyAvailable){
            if(status[key] == 0 && visited[key] == true && taken[key] == false){
                result += candies[key];
            }
        }
        return result ;
    }
}
}
