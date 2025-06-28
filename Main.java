import java.util.* ;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.StringBuilder ;
import java.io.* ; 
import java.util.Arrays ; 

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] edges = new int[m][2];
        for(int i = 0 ; i < m ; i++){
            st = new StringTokenizer(br.readLine());
            edges[i][0] = Integer.parseInt(st.nextToken())-1;
            edges[i][1] = Integer.parseInt(st.nextToken())-1;
        }

        List<List<Integer>> adjList = new ArrayList<>();
        for(int i = 0 ;i < n ; i++) adjList.add(new ArrayList<>());
        for(int i = 0 ; i < m ; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }
        int operations = 0 ; 
        boolean[] vis = new boolean[n];
        // for(int i = 0 ; i < n ; i++){
        //     if(!vis[i]){
        //         int[] res = dfs(adjList , i , vis);
        //         int nodes = res[0];
        //         int eges = res[1]/2; 
        //         if(nodes == 1 && eges == 0){
        //             operations += 2 ;
        //         }else{
        //             operations += Math.abs(eges - nodes );
        //         }
        //         // if(eges == 0) eges += 2 ;
        //     }
        // }

        for(int i = 0 ; i < n ; i++){
            if(vis[i] == false){
                List<Integer> comp = new ArrayList<>();
                dfsII(adjList , i , vis , comp);
                if(comp.size() == 1 && adjList.get(comp.get(0)).size() == 0){
                    operations += 2 ;
                }else{
                    int degOpes = 0 ; 
                    for(int node : comp){
                        int deg = adjList.get(node).size();
                        degOpes += Math.abs(deg - 2);
                    }
                    operations += degOpes/2 ; 
                }
            }
        }
        // System.out.println(maxi);
        // int removed = m - maxi  ; 
        // // if(maxi == 1) maxi = 0 ; 
        // int remoainingNodes = n - maxi ; 
        // int operations = removed + 2*remoainingNodes ;
        System.out.println(operations);
        br.close();
    }

    public static void dfsII(List<List<Integer>> adjList , int src , boolean[] vis ,List<Integer> comp){
        vis[src] = true ; 
        comp.add(src);
        for(int next : adjList.get(src)){
            if(vis[next] == false){
                dfsII(adjList , next , vis , comp);
            }
        }
        return ; 
    }

    public static int[] dfs(List<List<Integer>> adjList , int src , boolean[] vis){
        vis[src] = true ; 
        int totalNodes = 1 ; 
        int edge = adjList.get(src).size();
        for(int next : adjList.get(src)){
            if(vis[next] == false){
                int[]res = dfs(adjList , next , vis);
                totalNodes += res[0];
                edge += res[1];
            }
        }
        return new int[]{totalNodes , edge} ;
    }




    public static long bs(int[] arr , long target){
        int l = 0 ; 
        int r = arr.length - 1 ; 
        long val = -1 ; 
        while(l <= r){
            int mid = l + (r-l)/2 ; 
            if(arr[mid] <= target){
                val = arr[mid];
                l = mid + 1 ;
            }else{
                r = mid - 1 ;
            }
        }
        return val ; 
    }
}





