package Graphs;
import java.util.* ;
public class SafeNodesII {

    //Here we will change the direction of all the ndoes 
    //as safe nodes are those whose ends are terminal nodes 
    //and terminal nodes are itself safe nodes as no output is there from them 
    //thus in reversed order the nodes who have indegree as 0 will be the terminal nodes and 
    //therefore the safe nodes 
    //as the indegree is decreased thus the nodes become terminal nodes and eventually safe nodess
    //those components will be set aside or not traversed or say won't be added t the queue 
    //which are in cycle as there indegree will never become 0 due to there independency from other nodes due to the loop
    public List<Integer> eventualSafeNodes(int V , List<List<Integer>> adj){
        List<List<Integer>> revGraph = new ArrayList<>();
        for(int i = 0 ; i < V ;i++){
            for(int j : adj.get(i) ){
                revGraph.get(j).add(i);
            }
        }
        //calculating the indeg
        int[] indeg = new int[V];
        for(int i = 0 ; i < V ; i++){
            for(int it : revGraph.get(i)){
                indeg[it]++ ;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0 ; i < V ; i++){
            if(indeg[i] == 0){
                q.add(i);
            }
        }
        List<Integer> order = new ArrayList<>();
        while(!q.isEmpty()){
            int curr = q.remove();
            order.add(curr);
            for(int it : revGraph.get(curr)){
                indeg[it]--;
                if(indeg[it] == 0){
                    q.add(it);
                }
            }
        }
        Collections.sort(order);
        return order ;
    }
}
