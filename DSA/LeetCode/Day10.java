import java.util.* ;
class Day10 {
    class Edge {
        int src ; 
        int dest ;
        int wt ;
        public Edge(int s , int d , int w){
            this.src = s ;
            this.dest = d ;
            this.wt = w ;
        }
    }
    class Pair implements Comparable<Pair>{
        int src ;
        int wt ;
        public Pair(int s ,int w){
            this.src = s ;
            this.wt = w ;
        }
        @Override
        public int compareTo(Pair e2){
            return this.wt - e2.wt ;
        }
    }

	public int[] shortestPath(int N,int M, int[][] Pairs) {
        @SuppressWarnings("unchecked")
        ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
        for(int i = 0 ; i < N ; i++){
            graph.add(new ArrayList<>());
        }
        for(int[] p : Pairs){
            int src = p[0];
            int dest = p[1];
            int wt = p[3];
            graph.get(src).add(new Edge(src, dest, wt));
        }
	    int dist[] = new int[N];
	    for(int i = 1 ; i < N ; i++){
	        dist[i] = Integer.MAX_VALUE ;
	    }
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0 , 0));
        while(!pq.isEmpty()){
            Pair curr = pq.remove();
            for(Edge e : graph.get(curr.src)){
                int src = e.src ;
                int dest = e.dest ;
                int wt = e.wt ;
                if( dist[src] + wt < dist[dest] ){
                    dist[dest] = dist[src] + wt ;
                    pq.add(new Pair(dest , dist[dest]));
                } 
            }
        }

        for(int i = 0 ; i < N ; i++){
            if(dist[i] == Integer.MAX_VALUE){
                dist[i] = -1 ;
            }
        }
        return dist ;
	}



    static int[] bellman_ford(int V, ArrayList<ArrayList<Integer>> edges, int S) {
        // Write your code here
        
        int dist[] = new int[V];
        for(int i =0 ; i < V ; i++){
            if(i!= S){
                dist[i] = Integer.MAX_VALUE ;
            }
            dist[S] = 0 ;
        }
        
        for(int i = 0 ; i < V-1 ; i++){
            for(int j = 0 ; j < V ; j++){
                for(ArrayList<Integer> edge : edges){
                    int src = edge.get(0);
                    int dest = edge.get(1);
                    int wt = edge.get(2);
                    if(dist[src] + wt < dist[dest]){
                        dist[dest] = dist[src] + wt ;
                    }
                }
            }
        }
        return dist ;
    }
}