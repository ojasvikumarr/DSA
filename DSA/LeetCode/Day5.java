import java.util.*;

class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int a : arr) {
            map.put(a, map.getOrDefault(map.get(a), 0) + 1);
        }
        Set<Integer> s = new HashSet<>();
        for (int x : map.values()) {
            s.add(x);
        }
        return map.size() == s.size();

    }

    // Number of provinces
    class Edge {
        int src;
        int dest;

        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    public void createGraph(int[][] matrix, ArrayList<Edge> graph[]) {
        for (int i = 0; i < matrix.length; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 1) {
                    graph[i].add(new Edge(i, j));
                    graph[j].add(new Edge(j, i));
                }
            }
        }
    }

    public static void Dfs(ArrayList<Edge> graph[], boolean vis[], int curr) {
        vis[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!vis[e.dest]) {
                Dfs(graph, vis, e.dest);
            }
        }
    }

    public int findCircleNum(int[][] isConnected) {
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[isConnected.length];
        createGraph(isConnected, graph);
        boolean[] vis = new boolean[graph.length];
        int count = 0;
        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                count++;
                Dfs(graph, vis, i);
            }
        }
        return count;
    }
    // Number of islands

    public void createGraphh(char[][] grid, ArrayList<Edge> graph[]) {
        for (int i = 0; i < grid.length; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                graph[i].add(new Edge(i, j));
            }
        }
    }

    public int numIslands(char[][] grid) {
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[grid.length];
        createGraphh(grid, graph);
        boolean[] vis = new boolean[grid.length];
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            if (!vis[i]) {
                count++;
                Dfs(graph, vis, i);
            }
        }
        return count;
    }

}
