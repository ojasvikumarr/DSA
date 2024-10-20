import java.util.*;

public class Kruskal {
    static class Edge implements Comparable<Edge> {
        int src;
        int dest;
        int wt;

        public Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }

        @Override
        public int compareTo(Edge e) {
            return this.wt - e.wt;
        }
    }

    public void createGraph(ArrayList<Edge> edges) {
        edges.add(new Edge(0, 1, 10));
        edges.add(new Edge(0, 2, 15));
        edges.add(new Edge(0, 3, 30));
        edges.add(new Edge(1, 3, 40));
        edges.add(new Edge(2, 3, 50));// here we are storing the edges
    }

    static int n = 4;
    static int par[] = new int[n];
    static int rank[] = new int[n];

    public static void init() {
        for (int i = 0; i < n; i++) {
            par[i] = i;
        }
    }

    public static int find(int x) {
        if (par[x] == x) {
            return x;
        }
        return par[x] = find(par[x]);
    }

    public static void union(int a, int b) {
        int parA = par[a];
        int parB = par[b];

        if (rank[parA] == rank[parB]) {
            par[parB] = parA;
            rank[parA]++;
        } else if (rank[parA] < rank[parB]) {
            par[parA] = parB;
        } else {
            par[parB] = parA;
        }
    }

    public static void kruskalsMST(ArrayList<Edge> edges, int V) {
        init();
        Collections.sort(edges);// O(ElogE)
        int mstCost = 0;
        int count = 0;
        // it could have been i<edge.length-1 but the loop would have run more times
        // than necessary
        for (int i = 0; count < V - 1; i++) {// O(v)
            Edge e = edges.get(i);

            int parA = find(e.src);
            int parB = find(e.dest);
            // if the parents are equal then we dont have to do anything
            if (parA != parB) {
                union(e.src, e.dest);
                mstCost += e.wt;
                count++;
            }
        }
        System.out.println(mstCost);
    }
}
// its like picking up those pairs whose wt is less and
// if they are not connected togehter the they are connected together
// if they are not connected togehter then they are connected by the union
// imagine making a tree with one root
// here the roots connected to the root have least weights because we had
// sorteed the edges before hand
// so we can connected all those edges together who have the least weaight