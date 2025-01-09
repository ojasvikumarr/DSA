package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class MinCostToReachDest {
    class Solution {
    public int minCost(int maxTime, int[][] edges, int[] fee) {
    List<List<int[]>> adjList = new ArrayList<>();
    for (int i = 0; i < fee.length; i++) {
        adjList.add(new ArrayList<>());
    }
    for (int[] edge : edges) {
        int u = edge[0];
        int v = edge[1];
        int t = edge[2];
        adjList.get(u).add(new int[]{v, t});
        adjList.get(v).add(new int[]{u, t});
    }

    PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
        if (a[1] == b[1]) {
            return a[2] - b[2];
        }
        return a[1] - b[1];
    });

    pq.add(new int[]{0, fee[0], 0});

    int n = fee.length;
    int[] dist = new int[n];
    int[] times = new int[n];

    Arrays.fill(dist, Integer.MAX_VALUE);
    Arrays.fill(times, Integer.MAX_VALUE);

    dist[0] = 0;
    times[0] = 0;

    while (!pq.isEmpty()) {
        int[] curr = pq.poll();
        int node = curr[0];
        int cost = curr[1];
        int time = curr[2];

        if (time > maxTime) {
            continue;
        }

        if (node == n - 1) return cost;

        for (int[] neighbor : adjList.get(node)) {
            int neiNode = neighbor[0];
            int neiCost = fee[neiNode];

            if (cost + neiCost < dist[neiNode]) {
                dist[neiNode] = cost + neiCost;
                pq.add(new int[]{neiNode, cost + neiCost, time + neighbor[1]});
                times[neiNode] = time + neighbor[1];
            } else if (time + neighbor[1] < times[neiNode]) {
                pq.add(new int[]{neiNode, cost + neiCost, time + neighbor[1]});
                times[neiNode] = time + neighbor[1];
            }
        }
    }
    return dist[n - 1] == Integer.MAX_VALUE || times[n - 1] > maxTime ? -1 : dist[n - 1];
}
































    class Node implements Comparable<Node>{
        int vertex ; 
        int time ; 
        int cost ; 
        Node(int v , int t , int c){
            this.vertex= v ;
            this.time = t; 
            this.cost = c ;
        }

        public int compareTo(Node that){
            if(this.cost == that.cost){
                return this.time - that.time ;
            }
            return this.cost - that.cost ;
        }
    }

    @SuppressWarnings("unchecked")
    List<int[]>[] adj = new ArrayList[1001];
    int[] cost = new int[1001];
    int[] time = new int[1001];
    public int dijkstra(int src , int dest , int maxTime){
        Arrays.fill(cost ,Integer.MAX_VALUE);
        Arrays.fill(time , Integer.MAX_VALUE);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(src , 0 , cost[src]));

        cost[src] = 0 ; 
        time[src] = 0 ;
        while(!pq.isEmpty()){
            Node curr = pq.poll();

            int v = curr.vertex ; 
            int t = curr.time ; 
            int c = curr.cost ;

            for(int[] edge : adj[v]){
                int next = edge[0];
                int travelTime = edge[1];
                int travelCost = edge[2];

                if(t + travelCost <= maxTime){
                    if(cost[next] > c + travelCost){
                        cost[next] = c + travelCost ;
                        time[next] = t + travelTime ; 
                        pq.offer(new Node(next , time[next] , cost[next]));
                    }else if(time[next] > t + travelTime){
                        time[next] = t + travelTime ;
                        pq.offer(new Node(next , time[next] , c + travelCost));
                    }
                }
            }
        }
        return cost[dest];
    }
    
    public int minCostII(int maxTime, int[][] edges, int[] fee) {
        // maxTime is the max amount to reach n-1 node
        // Okay so Bellmen ford can find the minimum time req to reach the n-1 node 
        // Cost is the summation of the passing fees 

        //So all paths to the destination with time less than or equal 
        // to maxTime are allowed and we need to return the path which has the least 
        //Costing from the paths allowed 

        //SO find out all the paths to the destination rule out those 
        //who are taking more time than the limit 
        //Return the minimum cost path 

        //DFS to the n-1 node from src 
        //if total time succeeds the limit we will terminate the path 
        //If we reach successfully ill have the cost saved in a list 
        //And take out the least costing one 

        // int n = passingFees.length ;
        // List<List<Pair>> adjList = new ArrayList<>();
        // for(int i = 0 ; i < n ; i++){
        //     adjList.add(new ArrayList<>());
        // } 
        // for(int[] edge : edges){
        //     int u = edge[0];
        //     int v = edge[1];
        //     int t = edge[2];
        //     adjList.get(u).add(new Pair(v ,t));
        //     adjList.get(v).add(new Pair(u ,t));
        // }

        // visited = new boolean[n];
        // int costing = dfs(adjList , 0 , n-1 , passingFees , maxTime);
        // if(costing >= (int)10e8) return -1 ;
        // return passingFees[0] + costing ;


        for(int i = 0 ; i <= 1000 ; i++){
            adj[i] = new ArrayList<>();
        }
        for(int[] edge : edges){
            int x = edge[0];
            int y = edge[1];
            int t = edge[2];

            adj[x].add(new int[]{y , t ,fee[y]});
            adj[y].add(new int[]{x , t ,fee[x]});
        }

        cost[0] = 0 ; 
        time[0] = 0 ; 

        int result = dijkstra(0 , fee.length-1 ,maxTime);
        return result == Integer.MAX_VALUE ? -1 : result ;
    }

    class Pair{
        int node ; 
        int time ;
        public Pair(int n , int t){
            this.node = n ; 
            this.time = t ;
        }
    }
    boolean[] visited ;

    public int dfs(List<List<Pair>> adjList , int src , int dest , int[] fees , int limit){
        if(limit < 0) return Integer.MAX_VALUE ;
        if(src == dest){
            return 0 ;
        }
        visited[src] = true ;
        int mini = Integer.MAX_VALUE ; 
        for(Pair p  : adjList.get(src)){
            int neighbor = p.node ; 
            int time = p.time ;
            if(visited[neighbor] == false && limit - time >= 0){
                int cost = dfs(adjList , neighbor , dest , fees , limit - time) ;
                if(cost != Integer.MAX_VALUE)
                mini = Math.min(mini ,fees[neighbor]+ cost);
            }
        }
        // visited[src] = false ;
        return mini ;
    }
}
}
