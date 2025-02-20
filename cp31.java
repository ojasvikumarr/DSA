import java.util.* ; 

public class cp31 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            int m = sc.nextInt();

            int[][] graph = new int[n][m];
            for(int i =0 ; i < n; i++)
                for(int j = 0 ; j < m ; j++){
                    graph[i][j] = sc.nextInt();
                }
            solveII(graph , n , m);
        }
        sc.close();
    }

    public static void solveII(int[][] graph , int n , int m ){
        int[] color = new int[n*m+1];
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m; j++){
                color[graph[i][j]] = 1; 
                for(int[] dir : directions){
                    int row = i + dir[0];
                    int col = j + dir[1];
                    if(row >= 0 && col >= 0 && row < n && col < m && graph[row][col] == graph[i][j]){
                        color[graph[i][j]] = 2 ;
                        break ; 
                    }
                }
            }
        }
        List<Integer> ls = new ArrayList<>();
        for(Integer freq : color){
            if(freq != 0) ls.add(freq);
        }
        Collections.sort(ls);
        int result = 0 ; 
        for(int i = 0 ; i < ls.size()-1 ; i++){
            result += ls.get(i);
        }
        System.out.println(result);
        return ; 
    }
    public static void solve(int[][] graph , int n , int m){
        boolean[][] visited = new boolean[n][m];
        Map<Integer , Integer> freqMap = new HashMap<>();
        Set<Integer> set = new HashSet<>();

        for(int i = 0 ; i < n; i++){
            for(int j = 0 ; j < m ; j++){
                int color = graph[i][j] ; 
                if(visited[i][j] == false){
                    int freq = dfs(graph , i , j , visited , color) ; 
                    // System.out.println(color + "--" + freq);
                    if(freq == 0){
                        //this means its a single one 
                        //we check whether we have already added its part or not 
                        if(!set.contains(color)){
                            set.add(color);
                            freqMap.put(color , freqMap.getOrDefault(color , 0 ) + 1 );
                        }
                    }else{
                        freqMap.put(color , freqMap.getOrDefault(color , 0 ) + 2);
                    }
                    
                }
            }
        }

        List<Integer> ls = new ArrayList<>();
        for(Integer key : freqMap.keySet()){
            ls.add(freqMap.get(key));
            // System.out.println(key + "---" + freqMap.get(key));
        }
        Collections.sort(ls);
        int result = 0 ; 
        for(int i = 0 ; i < ls.size()-1 ; i++){
            result += ls.get(i);
        }
        System.out.println(result);
    }
    static int[][] directions = {{1 , 0} , {-1 , 0} , {0 , 1} , {0 , -1}};
    public static int dfs(int[][] graph , int row , int col , boolean[][] visited , int color){
        int n = graph.length ; 
        int m = graph[0].length ; 
        visited[row][col] = true ; 
        int ans = 0 ; 
        for(int[] dir : directions){
            int roo = row + dir[0];
            int coo = col + dir[1];
            if(roo < n && coo < m && roo >= 0 && coo >= 0 && visited[roo][coo] == false && graph[roo][coo] == color){
                visited[roo][coo] = true ; 
                ans += 1 + dfs(graph , roo , coo , visited , color);
            }
        }
        return ans ; 
    }
}
