package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.* ;
public class MaxReply {
    class Solution {
    private int getLastSend(int d, int p) {
        if (p >= 2 * d) {
            return 0;
        }
        if ((2 * d) % p == 0) {
            return 2 * d - p;
        }
        return 2 * d - (2 * d) % p;
    }
    public int networkBecomesIdle(int[][] edges, int[] patience) {
        // Build adjacency list.
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < patience.length; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        // Perform BFS to find the min distance of each node from the root.
        int[] distance = new int[patience.length];
        boolean[] visited = new boolean[patience.length];
        visited[0] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        while (!queue.isEmpty()) {
            int node = queue.remove();
            for (int neighbor : graph.get(node)) {
                if (!visited[neighbor]) {
                    distance[neighbor] = 1 + distance[node];
                    queue.add(neighbor);
                    visited[neighbor] = true;
                }
            }
        }

        int maxTime = 0;
        for (int n = 1; n < patience.length; n++) {
            int lastSend = getLastSend(distance[n], patience[n]);
            int lastReceive = lastSend + 2 * distance[n];
            maxTime = Math.max(maxTime, lastReceive);
        }
        return maxTime + 1;
    }
    
    public int networkBecomesIdleII(int[][] edges, int[] patience) {
        // 0 is the master server
        // rest are data servers.
        // every message takes the least amount of time to arrive at the master server
        // the data server i will resend the message if patience[i] second(s) have elapsed 
        // Okay so we need to return the time when the system gets idle 
        // that is when all the data servers have recieved there reply 
        // And the messages takes the most optimal path right!! (As no wts thus shortest path)
        // so the data server that is farthest from the master will recieve the reply
        // At the last moment before the system gets idle 
        // thus 
        // we'll be using Dijsktra to find the node farthest away then double the weight 
        // is the answer
        int n = patience.length ;
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i = 0 ; i < n ; i++) adjList.add(new ArrayList<>());
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n];
        q.add(0);
        int[] dist = new int[n];
        Arrays.fill(dist , Integer.MAX_VALUE);
        dist[0] = 0 ; 
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0 ; i < size ; i++){
                int curr = q.poll();
                for(Integer neighbor : adjList.get(curr)){
                    if(visited[neighbor] == false){

                    visited[neighbor] = true ;
                    if(dist[curr] + 1 < dist[neighbor]){
                        dist[neighbor] = dist[curr] + 1 ; 
                        q.add(neighbor);
                    }
                    }
                }

            }
        }
        //Now the distance array is constructed 
        //Now we start polling the messags 
        Queue<Message> bfs = new LinkedList<>();
        for(int i = 0 ; i < n ; i++){
            if(patience[i] == 0) bfs.add(new Message(i ,2*dist[i]));
        }
        boolean[] reply = new boolean[n];
        int totalTime = 0 ; 
        while(!bfs.isEmpty()){
            int level = bfs.size();
            totalTime++ ;
            for(int i = 0 ; i < level ; i++){
                Message msg = bfs.poll();
                msg.time -= 1 ;
                for(int j = 1 ; j < n ; j++){
                    if((patience[j] == 0 ? true : (totalTime % patience[j] == 0 && reply[j] == false))){
                        bfs.add(new Message(j , 2*dist[j]));
                    }
                }
                if(msg.time <= 0){
                    reply[msg.node] = true ;
                    continue ;
                }else{
                    bfs.add(msg);
                }
            }
        }
        return totalTime ; 
    }
    class Message{
        int node ; 
        int time ; 
        public Message(int n , int t){
            this.node = n ; 
            this.time = t ; 
        }
    }
}
}
