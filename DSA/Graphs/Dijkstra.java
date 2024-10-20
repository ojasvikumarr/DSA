package Graphs;

import java.util.*;
//We can use Set structure to make the Djsktra algo instead 
//Of priorityQueue But the catch is that if twe arre able to
//minimize to unwanted iteratons by deleting the pairs 
//but we will eventually be using that saved time in 
//deleting the elements from the set 
// As set requires LogN time to delete from it 
// And the saved time is LogN thus NUllify is
public class Dijkstra {
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

    // making a class called pair where we will store the node and its weight
    static class Pair implements Comparable<Pair> {
        int n;
        int path;

        public Pair(int n, int path) {
            this.n = n;
            this.path = path;
        }

        @Override
        public int compareTo(Pair p2) {
            return this.path - p2.path;// path based sorting for my pairs
        }
    }

    // as we are using priority queues thus we got a time complexity of O(V + ElogV)
    // here logV is of sorting in PQ
    // otherwuse ut would'vs been O(V^2)
    public static void Algorithm(ArrayList<Edge>[] graph, int src) {
        int dist[] = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (i != src) {
                dist[i] = Integer.MAX_VALUE;
            }
        }
        boolean vis[] = new boolean[graph.length];

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(src, 0));
        while (!pq.isEmpty()) {
            Pair curr = pq.remove();
            if (!vis[curr.n]) {
                vis[curr.n] = true;
                for (int i = 0; i < graph[curr.n].size(); i++) {
                    Edge e = graph[curr.n].get(i);
                    int u = e.src;
                    int v = e.dest;
                    int wt = e.wt;
                    if (dist[u] + wt < dist[v]) {
                        dist[v] = dist[u] + wt;
                        pq.add(new Pair(v, dist[v]));
                    }
                }
            }
        }

        // print all sources to vertices shortest dist
        for (int i = 0; i < dist.length; i++) {
            System.out.print(dist[i] + " ");
        }
        System.out.println();
    }

}
