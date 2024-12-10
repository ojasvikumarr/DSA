import java.util.ArrayList;
import java.util.List;

public class Day68 {
class Solution {
    static int timer = 0 ; 
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            adjList.add(new ArrayList<>());
        }
        for(List<Integer> connection : connections){
            adjList.get(connection.get(0)).add(connection.get(1));
            adjList.get(connection.get(1)).add(connection.get(0));
        }
        int[] disc = new int[n];
        int[] low = new int[n];
        int[] parent = new int[n];
        boolean[] visited = new boolean[n];

        Arrays.fill(disc , -1);
        Arrays.fill(low , -1);
        Arrays.fill(parent , -1);

        List<List<Integer>> ans = new ArrayList<>();

        for(int i = 0 ; i < n ; i++){
            if(!visited[i]){
                dfs(i , adjList , disc , low , parent , visited , ans );
            }
        }

        return ans ;
    }
        public static void dfs(int node , ArrayList<ArrayList<Integer>> adjList , int[] disc , int[] low , int[] parent , boolean[] visited, List<List<Integer>> ans){
            disc[node] = low[node] = timer++ ;
            visited[node] = true ;
            for(Integer neighbor : adjList.get(node)){
                if(neighbor == parent[node]) continue ;
                else if (!visited[neighbor]){
                    parent[neighbor] = node ; 
                    dfs(neighbor , adjList , disc , low , parent , visited , ans);

                    low[node] = Math.min(low[neighbor] , low[node]);
                    if(low[neighbor] > disc[node]){
                        // ans.add(Arrays.asList(node , neighbor));
                    }
                }else{
                    low[node] = Math.min(low[node] , disc[neighbor]);
                }
            }
        }
    
}
}
