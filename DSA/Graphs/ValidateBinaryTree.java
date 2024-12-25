package Graphs;

public class ValidateBinaryTree {
    class UnionFind {
        @SuppressWarnings("unused")
        private final int n;
        private final int[] parents;
        public int components;
        
        UnionFind(int n) {
            this.n = n;
            parents = new int[n];
            components = n;
            
            for (int i = 0; i < n; i++) {
                parents[i] = i;
            }
        }
        
        public boolean union(int parent, int child) {
            int parentParent = find(parent);
            int childParent = find(child);
            
            if (childParent != child || parentParent == childParent) {
                return false;
            }
            
            components--;
            parents[childParent] = parentParent;
    
            return true;
        }
        
        private int find(int node) {
            if (parents[node] != node) {
                parents[node] = find(parents[node]);
            }
            
            return parents[node];
        }
    }
    
    class Solution {
        public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
            UnionFind uf = new UnionFind(n);
            for (int node = 0; node < n; node++) {
                int[] children = {leftChild[node], rightChild[node]};
                for (int child : children) {
                    if (child == -1) {
                        continue;
                    }
                    
                    if (!uf.union(node, child)) {
                        return false;
                    }
                }
            }
            
            return uf.components == 1;
        }
    }
    // class Solution {
    //     int[] parent ; 
    //     int[] rank ; 
    //     int[] parCount ;
    //     public void init(int n){
    //         parent = new int[n];
    //         rank = new int[n];
    //         parCount = new int[n];
    //         for(int i = 0 ; i < n ; i++) parent[i] = i ;
    //     }
    //     public int findUpar(int x){
    //         if(parent[x] == x) return x ;
    //         return parent[x] = findUpar(parent[x]);
    //     }
    //     public void union(int u , int v){
    //         int parU = findUpar(u);
    //         int parV = findUpar(v);
    //         if(rank[parU] == rank[parV]){
    //             parent[parU] = parV ; 
    //             rank[parV]++ ;
    //         }else if(rank[parU] > rank[parV]){
    //             parent[parV] = parU ;
    //         }else{
    //             parent[parU] = parV ;
    //         }
    //     }
    //     public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
    //         init(n);
    //         for(int i = 0 ; i < n ; i++){
    //             int Lchild = leftChild[i];
    //             int Rchild = rightChild[i];
    //             if(Lchild != -1){
    //                 if(findUpar(Lchild) == findUpar(i) || ++parCount[Lchild] > 1) return false ;
    //                 union(Lchild , i);
    //             }
    //             if(Rchild != -1){
    //                 if(findUpar(Rchild) == findUpar(i) || ++parCount[Rchild] > 1) return false ;
    //                 union(Rchild , i);
    //             }
    
    //         }
    
    //         int rootCount = 0 ; 
    //         for(int i = 0 ; i < n ; i++){
    //             if(findUpar(i) == i && parCount[i] == 0){
    //                 rootCount++ ;
    //             }
    //         }
    //         return rootCount == 1 ;
    //     }
    // }
}
