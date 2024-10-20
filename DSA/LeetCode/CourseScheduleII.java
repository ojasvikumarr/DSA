import java.util.ArrayList;
import java.util.Stack;

public class CourseScheduleII {

    public void DFS(int i , boolean[] vis , Stack<Integer> st , ArrayList<ArrayList<Integer>> graph){
        vis[i] = true ;
        for(int it : graph.get(i)){
            if(!vis[it]){
                DFS(it , vis , st , graph);
            }
        }
        st.push(i);
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) { 
        int V = numCourses ;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0 ; i < V ; i++){
            adj.add(new ArrayList<>());
        }
        int m = prerequisites.length ;
        for(int i = 0 ; i < m ; i++){
            adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        Stack<Integer> st = new Stack<>();
        boolean[] vis = new boolean[V];
        for(int i = 0 ; i < V ; i++){
            if(!vis[i]){
                DFS(i , vis , st , adj);
            }
        }

        int order[] = new int[V];
        int i = 0; 
        while(!st.isEmpty()){
            order[i++] = st.peek();
            st.pop();
        }
        return order ;
    }
}



class Solution {
    public boolean hasCycle(int course, ArrayList<ArrayList<Integer>> graph, boolean[] visited, boolean[] onPath) {
        if (onPath[course]) {
            // Cycle detected
            return true;
        }
        if (visited[course]) {
            return false; // Already visited, no cycle
        }

        visited[course] = true;
        onPath[course] = true;
        for (int neighbor : graph.get(course)) {
            if (hasCycle(neighbor, graph, visited, onPath)) {
                return true; // Cycle found in the neighbor's path
            }
        }
        onPath[course] = false; // Backtrack
        return false;
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // Build graph
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] prerequisite : prerequisites) {
            graph.get(prerequisite[1]).add(prerequisite[0]);
        }

        // Check for cycles
        boolean[] visited = new boolean[numCourses];
        boolean[] onPath = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (!visited[i] && hasCycle(i, graph, visited, onPath)) {
                return new int[0]; // Cycle detected, return empty array
            }
        }

        // Perform topological sort
        Stack<Integer> stack = new Stack<>();
        boolean[] processed = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (!processed[i]) {
                topologicalSort(i, graph, processed, stack);
            }
        }

        // Convert stack to array
        int[] order = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            order[i] = stack.pop();
        }
        return order;
    }

    public void topologicalSort(int course, ArrayList<ArrayList<Integer>> graph, boolean[] processed, Stack<Integer> stack) {
        processed[course] = true;
        for (int neighbor : graph.get(course)) {
            if (!processed[neighbor]) {
                topologicalSort(neighbor, graph, processed, stack);
            }
        }
        stack.push(course);
    }
}
