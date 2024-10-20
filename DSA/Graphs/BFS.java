package Graphs;

import java.util.ArrayList;


import java.util.* ;

public class BFS {
        static class Edge{
        int src ;
        int dest ;
        int wt ;
        public Edge(int s , int d , int w){
            this.src = s ;
            this.dest = d ;
            this.wt = w ;
        }
    }
    public static void createGraph(ArrayList<Edge> graph[]){//O(V + E)
        for(int i = 0 ; i < graph.length ; i++){
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0 , 1 , 5));

        graph[1].add(new Edge(1 , 0 , 5));
        graph[1].add(new Edge(1 , 2 , 1));
        graph[1].add(new Edge(1 , 3 , 3));

        graph[2].add(new Edge(2 , 1 , 1));
        graph[2].add(new Edge(2 , 3 , 1));
        graph[2].add(new Edge(2 , 4 , 4));

        graph[3].add(new Edge(3 , 1 , 3));
        graph[3].add(new Edge(3 , 2 , 1));

        graph[4].add(new Edge(4 , 2 , 2));
    }

    public static void Bfs(ArrayList<Edge> graph[]){
        boolean vis[] = new boolean[graph.length];
        for( int i = 0 ; i < graph.length ; i++ ){
            if(!vis[i]){
                bfsutil(graph , vis);
            }
        }
    }
public static void bfsutil ( ArrayList<Edge> graph[] , boolean vis[]){
    Queue<Integer> q = new LinkedList<>();

    q.add(0);
    while(!q.isEmpty()){
        int curr = q.remove();
        if(!vis[curr]){
            System.out.print(curr+" ");
            vis[curr] = true ;
            for(int i = 0 ; i < graph[curr].size() ; i++ ){
                Edge e = graph[curr].get(i);
                q.add(e.dest);
            }
        }
    }
}
    public static void main(String args[]){
        int V = 5 ;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[V];//null -->...empty arraylist
        createGraph(graph);
        Bfs(graph);
    }
}

