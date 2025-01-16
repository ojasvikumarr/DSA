package Graphs;

public class DetonateBombs {
    class Solution {
        int[] parent ; 
        int[] rank ; 
        public void init(int n){
            rank = new int[n];
            parent = new int[n];
            for(int i = 0 ; i < n ; i++) parent[i] = i ;
        }
        public int find(int x){
            if(parent[x] == x){
                return x ;
            }
            return parent[x] = find(parent[x]);
        }
        public void union(int u , int v){
            int parU = find(u);
            int parV = find(v);
            if(parU != parV){
                if(rank[parU] == rank[parV]){
                    parent[parU] = parV;
                    rank[parV]++ ;
                }else if(rank[parU] > rank[parV]){
                    parent[parV] = parU ;
                }else{
                    parent[parU] = parV ;
                }
            }
        }
        public int maximumDetonation(int[][] bombs) {
            //Approach will be to make a graph 
            //Reachibility will be checked by
            //(x-x1)^2 + (y-y1)^2 > r^2 this means point is outside 
            //(x-x1)^2 + (y-y1)^2 <= r^2 this means point is inside
            //We will connec the nodes using dsu 
            //The component with the largest nodes will be the anwer 
            init(bombs.length);
            for(int i = 0 ; i < bombs.length ; i++){
                int[] mainbomb = bombs[i];
                for(int j = 0 ; j < bombs.length ; j++){
                    int[] secbomb = bombs[j];
                    int x = mainbomb[0];
                    int y = mainbomb[1];
                    int r = mainbomb[2];
                    int x1 = secbomb[0];
                    int y1 = secbomb[1];
                    if( i!=j && checkConnectivity(x , y , x1 , y1, r)){
                        union(i , j);
                    }
                }
            }
            int[] freq = new int[bombs.length];
            int maxi = 0 ; 
            for(int i = 0 ; i < bombs.length ; i++){
                freq[find(i)]++ ;
                maxi = Math.max(maxi , freq[find(i)]);
            }
            return maxi ;
        }
        public boolean checkConnectivity(int x , int y , int x1 , int y1 , int r){
            long dx = x-x1 ;
            long dy = y-y1 ;
            long dist = dx*dx + dy*dy ; 
            long radius = (long) r*r ; 
            return dist <= radius ;
        }
    }
}
