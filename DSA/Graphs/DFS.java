
package Graphs;

import java.util.ArrayList;

import java.util.*;

public class DFS {
    static class Edge {
        int src;
        int dest;
        int wt;

        public Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]) {// O(V + E)
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1, 5));

        graph[1].add(new Edge(1, 0, 5));
        graph[1].add(new Edge(1, 2, 1));
        graph[1].add(new Edge(1, 3, 3));

        graph[2].add(new Edge(2, 1, 1));
        graph[2].add(new Edge(2, 3, 1));
        graph[2].add(new Edge(2, 4, 4));

        graph[3].add(new Edge(3, 1, 3));
        graph[3].add(new Edge(3, 2, 1));

        graph[4].add(new Edge(4, 2, 2));
    }

    public static void Dfs(ArrayList<Edge> graph[]) {
        boolean vis[] = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            Dfsutil(graph, i, vis);
        }
    }

    public static void Dfsutil(ArrayList<Edge> graph[], int curr, boolean vis[]) {
        System.out.print(curr + " ");
        vis[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!vis[curr]) {
                Dfsutil(graph, e.dest, vis);
            }
        }
    }

    public static void dffs(ArrayList<Edge> graph[], int curr, boolean[] vis) {
        System.out.print(curr + " ");
        vis[curr] = true;
        // now to check for its neighbours
        for (int i = 0; i < graph[curr].size(); i++) {

            if (!vis[graph[curr].get(i).dest]) {
                dffs(graph, graph[curr].get(i).dest, vis);
            }
        }
    }

    public static void main(String args[]) {
        int V = 5;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[V];// null -->...empty arraylist
        createGraph(graph);
        Dfs(graph);
    }
}
