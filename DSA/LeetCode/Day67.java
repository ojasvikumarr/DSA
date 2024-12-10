import java.util.ArrayList;
import java.util.Collections;

    
public class Day67 {
	static class edge implements Comparable<edge>{
		int src ; 
		int dest ; 
		int wt ; 
		public edge(int s , int d , int w){
			this.src = s ; 
			this.dest = d ; 
			this.wt = w ;
		}
		@Override 
		public int compareTo(edge e){
			return this.wt - e.wt ;
		}
	}
		static int[] parent ;
		static int[] rank ;
		public static void init(int n){
			parent = new int[n];
			rank = new int[n];
			for(int i = 0 ; i < n ; i++){
				parent[i] = i ;
			}
		}
		public static int findUpar(int x){
			if(parent[x] == x){
				return x ;
			}
			return parent[x] = findUpar(parent[x]);
		}
		public static void union(int u, int v){
			int parU = findUpar(u);
			int parV = findUpar(v);
			if(parU != parV){
			if(rank[parU] == rank[parV]){
				parent[parU] = parV;
				rank[parV]++ ;
			}else if(rank[parU] < rank[parV]){
				parent[parU] = parV;
			}else{
				parent[parV] = parU;
			}
			}
		}
	public static int minimumSpanningTree(ArrayList<ArrayList<Integer>> edges, int n) {
		//Your code goes here
		init(n);
		ArrayList<edge> disjointEdges = new ArrayList<>();
		for(ArrayList<Integer> pair : edges){
			disjointEdges.add(new edge(pair.get(0) , pair.get(1) , pair.get(2)));
		}
		Collections.sort(disjointEdges);
		int mstcost = 0 ; 
		int count = 0 ; 

		for(int i = 0 ; count < n-1 && i < disjointEdges.size() ; i++){
			edge e = disjointEdges.get(i);
			
			int parA = findUpar(e.src);
            int parB = findUpar(e.dest);
            if(parA != parB){
                union(parA, parB);
                mstcost += e.wt ; 
                count++ ;
            }
		}
        return mstcost ; 
	}
}

