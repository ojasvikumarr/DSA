import java.util.*  ;

public class cp24 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            int[][] edges = new int[n-1][2];
            for(int i = 0 ; i < n-1 ; i++){
                edges[i][0] = sc.nextInt()-1;
                edges[i][1] = sc.nextInt()-1;
            }

           
            solve(edges , n);
        }
        sc.close();
    }    
    public static void solve(int[][] edges , int n ){
        Map<Integer , List<Integer>> graph = new HashMap<>();
        for(int i = 0 ; i < n ; i++){
            graph.put(i ,new ArrayList<>());
        }

        for(int i = 0 ; i < n-1 ; i++){
            int u = edges[i][0] ;
            int v = edges[i][1] ;
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        int largest = -1 ; 
        int lSize = 0 ; 
        int sec_largest = -1 ; 

        for(Integer key : graph.keySet()){
            int size = graph.get(key).size();
            if(size > lSize){
                sec_largest = largest ; 
                largest = key ;
                lSize = size ;
            }
        }
        //Now we need to exclude those two nodes and form the graph 
        List<List<Integer>> newGraph = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            newGraph.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            if(u == largest || v == largest || u == sec_largest || v == sec_largest){
                continue ;
            }
            newGraph.get(u).add(v);
            newGraph.get(v).add(u);
        }

        //Now a simple DFS To find the components 
        boolean[] visited = new boolean[n];
        int comp = 0 ; 
        for(int i = 0 ; i < n ; i++){
            if(visited[i] == false){
                dfs(newGraph , i , visited);
                comp++ ;
            }
        }

        System.out.println(comp-2);
        return ; 
    }
    public static void dfs(List<List<Integer>> graph , int curr , boolean[] visited){
        visited[curr] = true ; 
        for(Integer neighbor : graph.get(curr)){
            if(visited[neighbor] == false){
                visited[neighbor] = true ;
                dfs(graph , neighbor , visited);
            }
        }
    }
}
