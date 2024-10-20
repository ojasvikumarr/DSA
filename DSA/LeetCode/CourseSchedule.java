import java.util.* ;

public class CourseSchedule {
    public void DFS(int i , Stack<Integer> st , boolean[] vis , ArrayList<ArrayList<Integer>> graph){
        vis[i] = true ;
        for(int it : graph.get(i)){
            if(!vis[it]){
                DFS(it, st, vis, graph);
            }
        }
        st.push(i);
    }
    public boolean canFinish(int numCourses ,int[][] prerequisites ){
        Stack<Integer> st = new Stack<>();
        boolean[] vis = new boolean[numCourses];

        //Constructing the graph from prerequisites
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i = 0 ; i < numCourses ; i++){
            graph.add(new ArrayList<>());//Initialized wiht an empty array
        }
        //filling that array
        for(int[] p : prerequisites){
            int course = p[0];
            int prereq = p[1];
            graph.get(course).add(prereq);
        }
        for(int i = 0 ; i < numCourses ; i++){
            if(!vis[i]){
                DFS(i, st, vis, graph);
            }
        }
        return st.size() == numCourses ? true : false ;
    }

    //using bfs
    public boolean isPossible (int V , int[][]prerequisites){
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i =0 ; i < V ; i++){
            adj.add(new ArrayList<>());
        }
        int m = prerequisites.length ;
        for(int i = 0 ; i < m ; i++){
            adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }

        int indeg[] = new int[V];
        for(int i = 0 ; i < V ; i++){
            for(int it : adj.get(i)){
                indeg[it]++;
            }
        }

        Queue<Integer> q = new LinkedList<Integer>();
        for(int i = 0 ; i < V ;i++){
            if(indeg[i] == 0){
                q.add(i);
            }
        }

        List<Integer> topo = new ArrayList<Integer>();
        while(!q.isEmpty()){
            int node = q.peek();
            q.remove();
            topo.add(node);
            for(int it : adj.get(node)){
                indeg[it]--;
                if(indeg[it] == 0){
                    q.add(it);
                }
            }
        }
        if(topo.size() == V){
            return true ;
        }else{
            return false ;
        }
    }
}
