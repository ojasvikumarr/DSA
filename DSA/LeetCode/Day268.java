class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        // Step 1 : we will generate all possible vertex pairs 
                // and find the shortest distance between them 
        // Step 2 : then remove those paths which exceeds the threshold 
        // Step 3 : then count the nodes reachables from a node i 
        // Step 4 : then return the node with least number of reachable neighbors

        // Step1 | Step2 : FloydWarshall
        FloydWarshall(n , edges , distanceThreshold);

        int mini = Integer.MAX_VALUE ;
        int node = -1 ; 
        for(int i = 0 ; i < n ;i++){
            int count = 0 ; 
            for(int j = 0 ; j < n ; j++){
                if(dist[i][j] != -1) count++ ;
                // System.out.print(dist[i][j] + " ");
            }
            // System.out.println();
            if(mini >= count){
                mini = count ; 
                node = i ; 
            }
        }

        return node ;
    }
    int[][] dist ;
    public void FloydWarshall(int n , int[][] edges , int threshold){
        // node i and node j , if i can reach noed j ,via x , then update dist[i][j]
        dist = new int[n][n];
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                dist[i][j] = Integer.MAX_VALUE ; 
                if(i == j) dist[i][j] = 0 ; 
            }
        }
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];
            dist[u][v] = wt ;
            dist[v][u] = wt ;
        }
        //we will make every node as a mid node between i and j
        for(int via = 0 ; via < n ; via++){
            for(int i = 0 ; i < n ; i++){
                for(int j = 0 ; j < n ; j++){
                    if(dist[i][via] != Integer.MAX_VALUE && 
                       dist[via][j] != Integer.MAX_VALUE){
                        if(dist[i][j] > dist[i][via] + dist[via][j]){
                            dist[i][j] = dist[i][via] + dist[via][j];
                        }
                       }
                }
            }
        }
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                if(dist[i][j] > threshold) dist[i][j] = -1 ; 
            }
        }
        return; 
    }
}