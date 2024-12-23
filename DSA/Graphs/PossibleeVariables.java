package Graphs;

public class PossibleeVariables {
    class Solution {
        int[] parent ;
        int[] rank ;
        public void init(){
            parent = new int[26];
            rank = new int[26];
            for(int i = 0 ; i < 26 ; i++) parent[i] = i ;
        }
        public int findUpar(int x){
            if(parent[x] == x) return x ;
            return parent[x] = findUpar(parent[x]);
        }
        public void union(int u , int v){
            int parU = findUpar(u);
            int parV = findUpar(v);
            if(rank[parU] == rank[parV]){
                parent[parU] = parV ;
                rank[parV]++ ;
            }else if(rank[parU] > rank[parV]){
                parent[parV] = parU ; 
            }else{
                parent[parU] = parV ;
            }
        }
        public boolean equationsPossible(String[] equations) {
            init();
            for(String eq : equations){
                int a = eq.charAt(0) - 'a';
                int b = eq.charAt(3) - 'a';
                char sign = eq.charAt(1);
                if(sign == '='){
                    union(a , b);
                }
            }
            for(String eq : equations){
                int a = eq.charAt(0) - 'a';
                int b = eq.charAt(3) - 'a';
                char sign = eq.charAt(1);
                if(sign == '!' && findUpar(a) == findUpar(b)){
                    return false ;
                }
            }
            return true ;
    
        }
    }
}
