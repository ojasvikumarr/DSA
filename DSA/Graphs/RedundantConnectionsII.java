package Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class RedundantConnectionsII {
    int[] parent ; 
    int[] rank ; 
    public void init(int n){
        parent = new int[n];
        rank = new int[n];
        for(int i = 0 ; i < n ;i++){
            parent[i] = i ; 
        }
    }
    public int findUpar(int x){
        if(parent[x] == x) return x ;
        return parent[x] = findUpar(parent[x]);
    }
    public void union(int u , int v){
        int parU = findUpar(u);
        int parV = findUpar(v);
        if(rank[parU] == rank[parV]){
            parent[parU] = parV;
            rank[parV]++ ;
        }else if(rank[parU] > rank[parV]){
            parent[parV] = parU;
        }else{
            parent[parU] = parV;
        }
    }
    public int[] findRedundantDirectedConnectionII(int[][] edges) {
        int V = edges.length ;
        init(V+1);
        for(int[] edge : edges){
            int src = edge[0];
            int dest = edge[1];
            if(findUpar(src) == findUpar(dest)){
                return new int[]{src , dest};
            }
            union(src , dest);
        }
        return new int[]{0 , 0};
    }
    public int[] findRedundantDirectedConnectionIII(int[][] edges) {
        // Map<Integer , List<Integer>> adjList = new HashMap<>();
        List<List<Integer>> adjList = new ArrayList<>();
        int V = edges.length ;
        // for(int[] edge : edges){
        //     int u = edge[0];
        //     int v = edge[1];

        //     adjList.putIfAbsent(u , new ArrayList<>());
        //     adjList.get(u).add(v);
        // }
        for(int i = 0 ; i <= V ; i++){
            adjList.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            adjList.get(u).add(v);
        }
        boolean[] visited = new boolean[V+1];
        boolean[] parVis = new boolean[V+1];
        for (int i = 1; i <= V; i++) {
            if (!visited[i]) {
                int[] result = dfs(adjList, i, visited, parVis);
                if (result[0] != 0) {
                    return result; // Return the redundant edge
                }
            }
        }

        return new int[]{0, 0}; // No cycle found
    }
    public int[] dfs(List<List<Integer>> adjList ,int src , boolean[] visited , boolean[] parVis){
        visited[src] = true ;
        parVis[src] = true ;
        for(Integer neighbor : adjList.get(src)){
            if(!visited[neighbor]){
            int[] result = dfs(adjList, neighbor, visited, parVis);
                if (result[0] != 0) {
                    return result; // Propagate the cycle edge
                }
            }else if(parVis[neighbor]){
                return new int[]{src , neighbor};
            }
        }
        parVis[src] = false ;
        return new int[]{0 , 0};
    }



    public int[] findRedundantDirectedConnectionIIII(int[][] edges) {
        int V = edges.length;

        // Step 1: Find a node with two parents
        int[] parent = new int[V + 1];
        int[] conflictEdge1 = null, conflictEdge2 = null;

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            if (parent[v] == 0) {
                parent[v] = u;
            } else {
                // Found a node with two parents
                conflictEdge1 = new int[]{parent[v], v};
                conflictEdge2 = new int[]{u, v};
                edge[1] = 0; // Temporarily remove conflictEdge2
            }
        }

        // Step 2: Perform DFS to detect cycles
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i <= V; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            if (edge[1] != 0) { // Skip temporarily removed edge
                adjList.get(edge[0]).add(edge[1]);
            }
        }

        // Use visited and recursion stack for cycle detection
        boolean[] visited = new boolean[V + 1];
        boolean[] recStack = new boolean[V + 1];
        for (int i = 1; i <= V; i++) {
            if (!visited[i] && hasCycle(adjList, i, visited, recStack)) {
                // Cycle found
                return conflictEdge1 == null ? edges[i - 1] : conflictEdge1;
            }
        }

        // No cycle found, return the second conflicting edge
        return conflictEdge2;
    }

    private boolean hasCycle(List<List<Integer>> adjList, int node, boolean[] visited, boolean[] recStack) {
        visited[node] = true;
        recStack[node] = true;

        for (int neighbor : adjList.get(node)) {
            if (!visited[neighbor]) {
                if (hasCycle(adjList, neighbor, visited, recStack)) {
                    return true;
                }
            } else if (recStack[neighbor]) {
                return true;
            }
        }

        recStack[node] = false;
        return false;
    }

    public int[] findRedundantDirectedConnectionIIIII(int[][] edges) {
        int n = edges.length;
        int[] parent = new int[n + 1];
        int[] root = new int[n + 1];
        int[] edge1 = null, edge2 = null;

        // Step 1: Detect nodes with two parents
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            if (parent[v] != 0) {
                // Node v has two parents
                edge1 = new int[]{parent[v], v};
                edge2 = edge;
                edge[1] = 0; // Temporarily remove the second edge
            } else {
                parent[v] = u;
            }
        }

        // Step 2: Union-Find to check for cycles
        for (int i = 1; i <= n; i++) root[i] = i; // Initialize DSU roots

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            if (v == 0) continue; // Skip the removed edge

            int rootU = findRoot(root, u);
            int rootV = findRoot(root, v);

            if (rootU == rootV) {
                // Cycle detected
                if (edge1 == null) return edge; // If no two-parent issue, return this edge
                return edge1; // Otherwise, return the first edge of the two-parent node
            }

            root[rootV] = rootU; // Union
        }

        // Step 3: If no cycle, return the second edge of the two-parent node
        return edge2;
    }
    private int findRoot(int[] root, int x) {
        if (root[x] != x) root[x] = findRoot(root, root[x]); // Path compression
        return root[x];
    }
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int N = edges.length;
        Map<Integer, Integer> parent = new HashMap();
        List<int[]> candidates = new ArrayList();
        for (int[] edge: edges) {
            if (parent.containsKey(edge[1])) {
                candidates.add(new int[]{parent.get(edge[1]), edge[1]});
                candidates.add(edge);
            } else {
                parent.put(edge[1], edge[0]);
            }
        }

        int root = orbit(1, parent).node;
        if (candidates.isEmpty()) {
            Set<Integer> cycle = orbit(root, parent).seen;
            int[] ans = new int[]{0, 0};
            for (int[] edge: edges) {
                if (cycle.contains(edge[0]) && cycle.contains(edge[1])) {
                    ans = edge;
                }
            }
            return ans;
        }

        Map<Integer, List<Integer>> children = new HashMap();
        for (int v: parent.keySet()) {
            int pv = parent.get(v);
            if (!children.containsKey(pv)) {
                children.put(pv, new ArrayList<Integer>());
            }
            children.get(pv).add(v);
        }

        boolean[] seen = new boolean[N+1];
        seen[0] = true;
        Stack<Integer> stack = new Stack();
        stack.add(root);
        while (!stack.isEmpty()) {
            int node = stack.pop();
            if (!seen[node]) {
                seen[node] = true;
                if (children.containsKey(node)) {
                    for (int c: children.get(node)) {
                        stack.push(c);
                    }
                }
            }
        }
        for (boolean b: seen) {
            if (!b) {
                return candidates.get(0);
            }
        }
        return candidates.get(1);
    }

    public OrbitResult orbit(int node, Map<Integer, Integer> parent) {
        Set<Integer> seen = new HashSet();
        while (parent.containsKey(node) && !seen.contains(node)) {
            seen.add(node);
            node = parent.get(node);
        }
        return new OrbitResult(node, seen);
    }

}
class OrbitResult {
    int node;
    Set<Integer> seen;
    OrbitResult(int n, Set<Integer> s) {
        node = n;
        seen = s;
    }

}

