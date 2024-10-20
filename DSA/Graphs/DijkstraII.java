package Graphs;
import java.util.* ;
public class DijkstraII {
    class Pair{
        int node ;
        int weight ;
        public Pair(int n , int w){
            this.node = n ;
            this.weight = w ;
        }
    }
    public int[] ShortestDistance(int[][] edges , int n , int m , int src){
        int x = (int)1e9 ;
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            graph.add(new ArrayList<>());
        }
        for(int i = 0 ; i < m ; i++){
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);
        }
        Queue<Integer> q = new LinkedList<>();
        int dist[] = new int[n];
        for(int i = 0 ; i < n ; i++){
            dist[i] = x ;
        }
        dist[src] = 0 ;
        q.add(src);
        while(!q.isEmpty()){
            int curr = q.remove();
            for(int it : graph.get(curr)){
                if(dist[curr] + 1 < dist[it]){
                    dist[it] = dist[curr] + 1 ;
                    q.add(it);
                }
            }
        }

        int ans[] = new int[n];
        for(int i = 0 ; i < n ; i++){
            if(dist[i] == x){
                ans[i] = -1 ;
            }
            ans[i] = dist[i];
        }
        return ans ;

    }
}
