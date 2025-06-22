class Day459 {
    public int longestCycle(int[] edges) {
        int n = edges.length ;
        boolean[] vis = new boolean[n];
        boolean[] parVis = new boolean[n];
        id = new int[n];
        maxi = -1 ;
        for(int i = 0 ; i < n ; i++){
            if(vis[i] == false){
                dfs(edges , i , -1 , vis , parVis ,1);
            }
        }
        return maxi ;
    }
    private int maxi ; 
    private int[] id ; 
    public void dfs(int[] edges , int src , int parent , boolean[] vis , boolean[] parVis , int counter){
        vis[src] = true ; 
        parVis[src] = true ; 
        id[src] = counter ; 

        int next = edges[src];
        if(next != -1){
            if(vis[next] == false){
                dfs(edges , next , src , vis , parVis , counter+1);
            }else if(parVis[next] == true){
                maxi = Math.max(maxi , counter - id[next] + 1);
            }
        }
        
        id[src] = -1 ; 
        parVis[src] = false ;
    }
}