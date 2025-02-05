package Graphs;

import java.util.* ;

public class tarjan {

    public static List<List<Integer>> findBridges(int[][] edges, int v, int e) {

        // Write your code here!
        int[] dist = new int[v];
        int[] low = new int[v];
        Arrays.fill(dist , -1);
        Arrays.fill(low , -1);

        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0 ; i < v ; i++) graph.add(new ArrayList<>());

        for(int[] edge : edges){
            int U = edge[0];
            int V = edge[1];
            graph.get(U).add(V);
            graph.get(V).add(U);
        }
        timer = 0 ; 
        result = new ArrayList<>();
        boolean[] visited = new boolean[v];
        for(int i = 0 ; i < v ; i++){
            if(visited[i] == false){
                dfs(graph , dist , low , -1 , i , visited);
            }
        }

        return result ; 
    }
    static int timer ;
    static List<List<Integer>> result ; 
    public static void dfs(List<List<Integer>> graph , int[] dist , int[] low , int parent , int curr , boolean[] visited){
        visited[curr] = true ; 
        dist[curr] = timer ; 
        low[curr] = timer ; 
        timer++ ;
        for(Integer neighbor : graph.get(curr)){
            if(neighbor == parent) continue ;
            if(visited[neighbor] == false){
                visited[neighbor] = true ;
                dfs(graph , dist , low , curr , neighbor , visited);

                low[curr] = Math.min(low[curr] , low[neighbor]);

                if(low[neighbor] > dist[curr]){
                    //this means that the edge is a back edge 
                    result.add(new ArrayList<>(Arrays.asList(curr , neighbor)));
                }
            }else{
                //We need to check if we got a visited negihbor 
                //Then wat is its lowest discovery at?
                //AkA BackEdge declaration
                low[curr] = Math.min(low[curr] , dist[neighbor]);
            }
        }
    }
}

