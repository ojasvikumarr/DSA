public class weeklyy {
    private static boolean solve(int n, int[][] edges, int threshold, int start) {
        UnionFind uf = new UnionFind(n);
        int[] outDegree = new int[n];
        for (int i = start; i < edges.length; i++) {
            int u = edges[i][0], v = edges[i][1];
            if (outDegree[u] < threshold && outDegree[v] < threshold) {
                outDegree[u]++;
                outDegree[v]++;
                uf.union(u, v);
            }
        }
        for (int i = 1; i < n; i++) {
            if (!uf.isConnected(0, i)) {
                return false;
            }
        }

        return true;
    }
    static class UnionFind {
        private int[] parent, rank;

        public UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }

        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]); 
            }
            return parent[x];
        }

        public void union(int x, int y) {
            int rootX = find(x), rootY = find(y);
            if (rootX != rootY) {
                if (rank[rootX] > rank[rootY]) {
                    parent[rootY] = rootX;
                } else if (rank[rootX] < rank[rootY]) {
                    parent[rootX] = rootY;
                } else {
                    parent[rootY] = rootX;
                    rank[rootX]++;
                }
            }
        }

        public boolean isConnected(int x, int y) {
            return find(x) == find(y);
        }
    }
}
