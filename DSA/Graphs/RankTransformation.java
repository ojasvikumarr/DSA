package Graphs;
import java.util.* ;
public class RankTransformation {
    class Solution {
        class Node {
            int id, val, rank;
            List<Integer> neighbors;
            public Node(int id, int val) {
                this.id = id;
                this.val = val;
                this.neighbors = new ArrayList<>();
            }
        }
        
        class DSU {
            int[] parent, rank;
            int size;
            public DSU(int n) {
                this.parent = new int[n];
                for (int i = 0; i < n; i++) parent[i] = i;
                this.rank = new int[n];
                this.size = n;
            }
    
            public boolean union(int[] a, int[] b) {
                return union(encode(a[0], a[1]), encode(b[0], b[1]));
            }
    
            public boolean union(int a, int b) {
                int p = find(a), q = find(b);
                if (p == q) return false;
                if (rank[p] > rank[q]) {
                    parent[q] = p;
                } else if (rank[p] < rank[q]) {
                    parent[p] = q;
                } else {
                    parent[p] = q;
                    rank[q]++;
                }
                size--;
                return true;
            }
    
            public int find(int r, int c) {
                return find(encode(r, c));
            }
    
            public int find(int a) {
                int root = a;
                while (root != parent[root]) {
                    root = parent[root];
                }
                while (root != a) {
                    int p = parent[a];
                    parent[a] = root;
                    a = p;
                }
                return root;
            }
    
            private int encode(int r, int c) {
                return r * cols + c;
            }
        }
    
        private int rows, cols;
        public int[][] matrixRankTransform(int[][] matrix) {
            this.rows = matrix.length;
            this.cols = matrix[0].length;
            DSU dsu = new DSU(rows * cols);
            
            connectCellWithEqualRank(dsu, matrix);
            
            Map<Integer, Node> graph = new HashMap<>();
            Node[] nodes = new Node[dsu.size];
            int[] in = new int[nodes.length];
            
            buildGraph(dsu, matrix, graph, nodes, in);
    
            assignRankThroughTopologicalSort(nodes, in);
            
            int[][] ranks = new int[rows][cols];
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    ranks[i][j] = graph.get(dsu.find(i, j)).rank;
                }
            }
            return ranks;
        }
    
        private void assignRankThroughTopologicalSort(Node[] nodes, int[] in) {
            Queue<Integer> queue = new LinkedList<>();
            int rank = 1;
            for (int i = 0; i < in.length; i++) {
                if (in[i] == 0) queue.offer(i);
            }
            while (!queue.isEmpty()) {
                int size = queue.size();
                while (size-- > 0) {
                    int cur = queue.poll();
                    nodes[cur].rank = rank;
                    for (int neighbor: nodes[cur].neighbors) {
                        if (--in[neighbor] != 0) continue;
                        queue.offer(neighbor);
                    }
                }
                rank++;
            }
        }
    
        private void buildGraph(DSU dsu, int[][] matrix, Map<Integer, Node> graph, Node[] nodes, int[] in) {
            int id = 0;
            // add nodes
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    int parent = dsu.find(i, j);
                    if (graph.containsKey(parent)) continue;
                    nodes[id] = new Node(id, matrix[i][j]);
                    graph.put(parent, nodes[id]);
                    id++;
                }
            }
            // add edges
            // 1. row by row
            for (int i = 0; i < rows; i++) {
                List<Node> curRow = new ArrayList<>();
                Set<Integer> seen = new HashSet<>();
                for (int j = 0; j < cols; j++) {
                    int parent = dsu.find(i, j);
                    if (seen.add(parent)) curRow.add(graph.get(parent));
                }
                curRow.sort(Comparator.comparingInt(a -> a.val));
                for (int m = 0; m < curRow.size() - 1; m++) {
                    int neighborId = curRow.get(m + 1).id;
                    curRow.get(m).neighbors.add(neighborId);
                    in[neighborId]++;
                }
            }
            // 2. col by col
            for (int j = 0; j < cols; j++) {
                List<Node> curCol = new ArrayList<>();
                Set<Integer> seen = new HashSet<>();
                for (int i = 0; i < rows; i++) {
                    int parent = dsu.find(i, j);
                    if (seen.add(parent)) curCol.add(graph.get(parent));
                }
                curCol.sort(Comparator.comparingInt(a -> a.val));
                for (int m = 0; m < curCol.size() - 1; m++) {
                    int neighborId = curCol.get(m + 1).id;
                    curCol.get(m).neighbors.add(curCol.get(m + 1).id);
                    in[neighborId]++;
                }
            }
        }
    
        private void connectCellWithEqualRank(DSU dsu, int[][] matrix) {
            Map<Integer, Map<Integer, List<int[]>>> map = new HashMap<>();
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    map.putIfAbsent(matrix[i][j], new HashMap<>());
                    map.get(matrix[i][j]).computeIfAbsent(i + 1, a -> new ArrayList<>()).add(new int[]{i, j});
                    map.get(matrix[i][j]).computeIfAbsent(-j - 1, a -> new ArrayList<>()).add(new int[]{i, j});
                }
            }
            for (Map<Integer, List<int[]>> nodesMap: map.values()) {
                for (List<int[]> nodes : nodesMap.values()) {
                    for (int i = 0; i < nodes.size() - 1; i++) {
                        dsu.union(nodes.get(i), nodes.get(i + 1));
                    }
                }
            }
        }
    }
}
