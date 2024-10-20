import java.util.* ;
class Day8
{
    public static void DFS(int i ,Stack<Integer> st ,  boolean[] vis , ArrayList<ArrayList<Integer>> adj){
        vis[i] = true ;
        for(int it : adj.get(i)){
            if(!vis[i]){
                DFS(it , st , vis , adj);
            }
        }
        st.push(i);
    }
    //Function to return list containing vertices in Topological order. 
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        // add your code here
        //approach will be to use stack 
        boolean[] vis = new boolean[V];
        Stack<Integer> st = new Stack<Integer>();
        for(int i = 0 ; i < V ; i++){
            if(!vis[i]){
                DFS(i , st , vis , adj);
            }
        }
        int ans[] = new int[V];
        int i = 0 ;
        while(!st.isEmpty()){
            ans[i++] = st.peek();
            st.pop();
        }
        return ans ;
    }
}