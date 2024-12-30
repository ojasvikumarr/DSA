package Graphs ; 
import java.util.* ;

public class CriticalPseudoCritical {
    class Solution {
        int[] parent; 
        int[] rank;
    
        public void init(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) parent[i] = i;
        }
    
        public int findUpar(int x) {
            if (parent[x] == x) return x;
            return parent[x] = findUpar(parent[x]);
        }
    
        public void union(int u, int v) {
            int parU = findUpar(u);
            int parV = findUpar(v);
            if (parU != parV) {
                if (rank[parU] > rank[parV]) {
                    parent[parV] = parU;
                } else if (rank[parU] < rank[parV]) {
                    parent[parU] = parV;
                } else {
                    parent[parU] = parV;
                    rank[parV]++;
                }
            }
        }
    
        public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
            List<List<Integer>> ans = new ArrayList<>();
            ans.add(new ArrayList<>());
            ans.add(new ArrayList<>());
            
            int[][] edgesWithIndex = new int[edges.length][4];
            for (int i = 0; i < edges.length; i++) {
                edgesWithIndex[i] = new int[]{edges[i][0], edges[i][1], edges[i][2], i};
            }
            Arrays.sort(edgesWithIndex, (a, b) -> Integer.compare(a[2], b[2]));
    
            int origMST = getMST(edgesWithIndex, n, -1, -1);
    
            for (int i = 0; i < edgesWithIndex.length; i++) {
                // Check critical
                int exMST = getMST(edgesWithIndex, n, i, -1);
                if (exMST > origMST) {
                    ans.get(0).add(edgesWithIndex[i][3]);
                }else{
                    // Check pseudo-critical
                    int inMST = getMST(edgesWithIndex, n, -1, i);
                    if (inMST == origMST) {
                        ans.get(1).add(edgesWithIndex[i][3]);
                    }
                }
            }
            return ans;
        }
    
        public int getMST(int[][] edges, int n, int skipEdge, int forceEdge) {
            init(n);
            int weight = 0, edgesConnected = 0;
    
            if (forceEdge != -1) {
                union(edges[forceEdge][0], edges[forceEdge][1]);
                weight += edges[forceEdge][2];
                edgesConnected++;
            }
    
            for (int i = 0; i < edges.length; i++) {
                if (i == skipEdge) continue;
                if (findUpar(edges[i][0]) != findUpar(edges[i][1])) {
                    union(edges[i][0], edges[i][1]);
                    weight += edges[i][2];
                    edgesConnected++;
                    if (edgesConnected == n - 1) break;
                }
            }
            return edgesConnected == n - 1 ? weight : Integer.MAX_VALUE;
        }
    }
}
