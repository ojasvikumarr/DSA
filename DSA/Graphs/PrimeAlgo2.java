import java.util.*;

public class PrimeAlgo2 {
    static class Edge implements Comparable<Edge> {

        int dest;
        int cost;

        public Edge(int d, int w) {

            this.dest = d;
            this.cost = w;
        }

        @Override
        public int compareTo(Edge e) {
            return this.cost - e.cost;// ascending
        }
    }

    public static int connectCities(int cities[][]) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        boolean vis[] = new boolean[cities.length];

        pq.add(new Edge(0, 0));
        int finalcost = 0;
        while (!pq.isEmpty()) {
            Edge curr = pq.remove();
            if (!vis[curr.dest]) {
                vis[curr.dest] = true;
                finalcost += curr.cost;

                for (int i = 0; i < cities[curr.dest].length; i++) {
                    pq.add(new Edge(i, cities[curr.dest][i]));
                }
            }
        }

        return finalcost;
    }

    // Find the minimum cost for connecting all cities on the map.
    public static void main(String args[]) {
        int cities[][] = { { 0, 1, 2, 3, 4 },
                { 1, 0, 5, 0, 7 },
                { 2, 5, 0, 6, 0 },
                { 3, 0, 6, 0, 0 },
                { 4, 7, 0, 0, 0 } };

    }
}