public class Day256{
    class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i = 0 ; i < n ; i++) adjList.add(new ArrayList<>());
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }


        return solve(adjList , 0 , -1 , hasApple , new boolean[n]);
    }
    public int solve(List<List<Integer>> adj , int src, int par , List<Boolean> apple , boolean[] vis){
        int res = 0 ; 
        vis[src] = true ;
        for(int neigh : adj.get(src)){
            if(neigh == par) continue ;
            if(vis[neigh] == false){
                vis[neigh] = true ;
                // if(apple.get(neigh) == true){
                //     res += 1; 
                // }
                int val = solve(adj , neigh , src , apple , vis);
                if(apple.get(neigh) == true || val != 0){
                    res += val + 2 ;
                }
            }
        }
        return res ; 
    }
}
class SolutionII {
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i = 0 ; i < n ; i++) adjList.add(new ArrayList<>());
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }

        res = new int[n];
        Map<Character ,  Integer> map = new HashMap<>();
        solve(adjList , 0 , -1 , labels , map);
        return res ;
    }

    int[] res; 
    public Map<Character , Integer> solve(List<List<Integer>> adj , int src , int parent , String labels ,Map<Character , Integer> map){

        // int n = colors.length ;
        char label = labels.charAt(src) ;

        map.put(label , map.getOrDefault(label , 0) + 1);

        for(int neigh : adj.get(src)){
            if(neigh == parent) continue ; 
            //i will give my child an array and ask him to 
            //fill the colors of your children and take color for yourself too 
            Map<Character , Integer> temp = new HashMap<>();
            temp = solve(adj , neigh , src , labels , temp);
            //now i will merge this with my color palate
            for(Character key : temp.keySet()){
                map.put(key , map.getOrDefault(key , 0) + temp.get(key));
            }
        }
        res[src] += map.getOrDefault(label , 0);
        return map; 
    }
}
}