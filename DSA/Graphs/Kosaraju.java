package Graphs;
import java.util.* ;

public class Kosaraju {
	public static int stronglyConnectedComponents(int v, ArrayList<ArrayList<Integer>> edges) {
		// Write your code here.
		ArrayList<ArrayList<Integer>> adjList = new ArrayList<>() ; 
		for(int i =0 ; i < v ; i++){
			adjList.add(new ArrayList<>());
		}
		for(ArrayList<Integer> edge : edges){
			adjList.get(edge.get(0)).add(edge.get(1));
			// adjList.get(edge.get(1)).add(edge.get(0));
		}
		//First we'll be doing a topological sort 
		//to find the nodes in order of their finishing time 
		Stack<Integer> st = new Stack<>();
		boolean[] visited = new boolean[v];
		for(int i = 0 ; i < v ; i++){
			if(visited[i] == false){
				topoSort(i , visited , adjList , st);
			}
		}

		//Now we'll be reversing the edges in the graph 
		ArrayList<ArrayList<Integer>> transList = new ArrayList<>() ; 
		for(int i =0 ; i < v ; i++){
			transList.add(new ArrayList<>());
		}
		for(ArrayList<Integer> edge : edges){
			// transList.get(edge.get(0)).add(edge.get(1));
			transList.get(edge.get(1)).add(edge.get(0));
		}

		int count = 0 ; 
		visited = new boolean[v];
		while(!st.isEmpty()){
			int i = st.peek();
			st.pop();
			if(visited[i] == false){
				topoSort(i , visited , transList , new Stack<>());
				count++ ;
			}
		}
		return count ; 
	}
	public static void topoSort(int node , boolean[] visited , ArrayList<ArrayList<Integer>> adjList , Stack<Integer> st ){
		visited[node] = true ; 
		for(Integer neighbor : adjList.get(node)){
			if(!visited[neighbor]){
				topoSort(neighbor , visited ,adjList , st);
			}
		}
		st.push(node);
	}
}

