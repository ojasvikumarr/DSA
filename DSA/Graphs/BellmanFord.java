package Graphs;

import java.util.*;

public class BellmanFord {
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

    public static void Bellman(ArrayList<Edge>[] graph, int src) {
        int dist[] = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (i != src) {
                dist[i] = Integer.MAX_VALUE;
            }
        }

        // Total complexity O(V*E)
        // also -- O(V)
        for (int i = 0; i < (graph.length - 1); i++) {
            // O(E)
            for (int j = 0; j < graph.length; j++) {
                for (int k = 0; k < graph[j].size(); k++) {
                    Edge e = graph[k].get(i);
                    int u = e.src;
                    int v = e.dest;
                    int wt = e.wt;
                    // relaxation
                    if (dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]) {// in java cpp if we add anything in
                                                                                 // max_value then it will give a
                                                                                 // negative value
                        dist[v] = dist[u] + wt;
                    }
                }
            }
        }
        for (int i = 0; i < graph.length; i++) {
            System.out.print(dist[i] + " ");
        }
        System.out.println();
    }
}
