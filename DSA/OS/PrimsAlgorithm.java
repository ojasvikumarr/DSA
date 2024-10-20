import java.util.*;

class Edge implements Comparable<Edge> {
    int src, dest, weight;

    public Edge(int src, int dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge other) {
        return this.weight - other.weight;
    }
}

class DisjointSet {
    int[] parent;

    public DisjointSet(int n) {
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        parent[rootX] = rootY;
    }
}

public class PrimsAlgorithm {

    public static List<Edge> primsMST(List<Edge> edges, int numVertices) {
        // Sort the edges by weight
        Collections.sort(edges);

        // Initialize disjoint set
        DisjointSet ds = new DisjointSet(numVertices);

        List<Edge> mst = new ArrayList<>();
        for (Edge edge : edges) {
            int srcRoot = ds.find(edge.src);
            int destRoot = ds.find(edge.dest);

            if (srcRoot != destRoot) {
                mst.add(edge);
                ds.union(srcRoot, destRoot);
            }
        }
        return mst;
    }

    public static void main(String[] args) {
        int numVertices = 5;
        List<Edge> edges = new ArrayList<>();
        edges.add(new Edge(0, 1, 2));
        edges.add(new Edge(0, 3, 6));
        edges.add(new Edge(1, 2, 3));
        edges.add(new Edge(1, 3, 8));
        edges.add(new Edge(1, 4, 5));
        edges.add(new Edge(2, 4, 7));
        edges.add(new Edge(3, 4, 9));

        List<Edge> mst = primsMST(edges, numVertices);

        System.out.println("Minimum Spanning Tree:");
        for (Edge edge : mst) {
            System.out.println(edge.src + " - " + edge.dest + " Weight: " + edge.weight);
        }
    }
}
