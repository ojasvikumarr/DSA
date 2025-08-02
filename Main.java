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

        int t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken()) -1;
            int y = Integer.parseInt(st.nextToken()) -1;
            List<List<Integer>> adjList = new ArrayList<>();
            for(int i = 0 ; i < n ; i++) adjList.add(new ArrayList<>());
            for(int i = 0 ; i < m ; i++){
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken()) - 1;
                int v = Integer.parseInt(st.nextToken()) - 1;
                adjList.get(u).add(v);
                adjList.get(v).add(u);
            }
            for(int i = 0 ; i < n ; i++){
                Collections.sort(adjList.get(i));
            }
            // res = new ArrayList<>();
            // Set<Integer> set = new HashSet<>();
            // set.add(x);
            // solve(adjList , x , y , set , new ArrayList<>());
            // sb.append((x + 1 )+ " ");
            // for(int i = 0 ; i < res.size() ; i++){
            //     sb.append((res.get(i) + 1) + " ");
            // }
            // // sb.append((y+1));

            boolean[] visited = new boolean[n];
            List<Integer> path = new ArrayList<>();

            int curr = x ; 
            visited[curr] = true ; 
            path.add(curr);

            while(curr != y){
                boolean[] reached = new boolean[n];
                Queue<Integer> q = new LinkedList<>();
                reached[y] = true ;
                q.add(y);
                while(!q.isEmpty()){
                    int w = q.poll();
                    for(int next : adjList.get(w)){
                        if(visited[next] == false && reached[next] == false){
                            reached[next] = true ; 
                            q.add(next);
                        }
                    }
                }

                for(int next : adjList.get(curr)){
                    if(visited[next] == false && reached[next] == true){
                        visited[next] = true ; 
                        curr = next ; 
                        path.add(curr);
                        break ; 
                    }
                }
            }

            for(int ele : path){
                sb.append((ele + 1) + " ");
            }

            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
    static List<Integer> res ;

    public static boolean solve(List<List<Integer>> adjList , int src , int dest , Set<Integer> vis , List<Integer> ls ){
        if(src == dest){
            res = new ArrayList<>(ls);
            return true; 
        }
        // Collections.sort(adjList.get(src));
        for(int next : adjList.get(src)){
            if(vis.contains(next) == false){
                vis.add(next);
                ls.add(next);
                if( solve(adjList , next , dest , vis , ls) ){
                    return true ;
                }
                ls.remove(ls.size() - 1);
                vis.remove(next);
            }
        }
        return false ;
    }

}
