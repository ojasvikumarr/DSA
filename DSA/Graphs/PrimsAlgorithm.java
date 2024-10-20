package Graphs;

import java.util.*;

public class PrimsAlgorithm {

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

    static class Pair implements Comparable<Pair> {
        int v;
        int cost;

        public Pair(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }

        // this isnt a static function
        public int compareTo(Pair p2) {
            return this.cost - p2.cost;// ascending
        }
    }

    public static void prims(ArrayList<Edge>[] graph) {
        boolean vis[] = new boolean[graph.length];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0, 0));
        int finalCost = 0;
        while (!pq.isEmpty()) {
            Pair curr = pq.remove();
            if (!vis[curr.v]) {
                vis[curr.v] = true;
                finalCost += curr.cost;
                for (int i = 0; i < graph[curr.v].size(); i++) {
                    Edge e = graph[curr.v].get(i);
                    pq.add(new Pair(e.dest, e.wt));// main game is of the priority queue which is sorting hte costs of
                                                   // the vertices at easch addition
                }
            }
        }
        System.out.println("Final(min) cost of MST = " + finalCost);
    }

    static class p implements Comparable<p> {
        int v;
        int cost;

        public p(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }

        public int compareTo(p P) {
            return this.cost - P.cost;// ascending
        }
    }

    public static void PPrim(ArrayList<Edge>[] graph) {
        boolean vis[] = new boolean[graph.length];
        PriorityQueue<p> pq = new PriorityQueue<>();
        pq.add(new p(0, 0));
        int Finalcost = 0;
        while (!pq.isEmpty()) {
            p curr = pq.remove();
            if (!vis[curr.v]) {
                Finalcost += curr.cost;
                for (int i = 0; i < graph[curr.v].size(); i++) {

                    Edge e = graph[curr.v].get(i);
                    pq.add(new p(e.dest, e.wt));
                }
            }
        }
    }
}
