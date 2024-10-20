package Graphs;
import java.util.* ;
public class CycleTopoSort {
    //kahn's algorithm 
    public static void indeg(ArrayList<ArrayList<Integer>> graph , int[] indeg){
        for(ArrayList<Integer> edges : graph){
            for(int i : edges){
                indeg[i]++ ;
            }
        }
    }
    public static boolean CycleDetectionUsingTopo(ArrayList<ArrayList<Integer>> graph){
        int indeg[] = new int[graph.size()];
        indeg(graph , indeg);
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0 ; i < graph.size() ; i++){
            if(indeg[i] == 0){
                q.add(i);
            }
        }
        int count = 0 ;
        while(!q.isEmpty()){
            int curr = q.remove();
            count++ ;
            for(int i : graph.get(curr)){
                indeg[i]-- ;
                if(indeg[i] == 0){
                    q.add(i);
                }
            }
        }
        return count == graph.size() ? true : false ;
    }
}
