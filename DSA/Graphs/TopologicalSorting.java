package Graphs;

import java.util.*;

public class TopologicalSorting {
    static class Edge {
        int src;
        int dest;

        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    public static void DFSTopoSort(ArrayList<Edge>[] graph) {
        boolean vis[] = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            vis[i] = false;
        }
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                DFSTopoSortUtil(graph, i, vis, s);
            }
        }
        while (!s.isEmpty()) {
            System.out.print(s.pop() + " ");
        }
    }

    public static void DFSTopoSortUtil(ArrayList<Edge>[] graph, int curr, boolean[] vis, Stack<Integer> s) {
        vis[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!!vis[e.dest]) {
                DFSTopoSortUtil(graph, e.dest, vis, s);
            }
        }
        s.push(curr);
    }

    // topological sorting useing bfs traversal

    public static void calcIndeg(ArrayList<Edge>[] graph, int indeg[]) {
        for (int i = 0; i < graph.length; i++) {
            int v = i;
            for (int j = 0; j < graph[v].size(); j++) {
                Edge e = graph[v].get(j);
                indeg[e.dest]++;
            }
        }
    }

    public static void BFSTopoSort(ArrayList<Edge>[] graph) {
        int indeg[] = new int[graph.length];
        calcIndeg(graph, indeg);
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < indeg.length; i++) {
            if (indeg[i] == 0) {
                q.add(i);
            }
        }
        while (!q.isEmpty()) {
            int curr = q.remove();
            System.out.print(curr + " ");

            for (int i = 0; i < graph[curr].size(); i++) {
                Edge e = graph[curr].get(i);
                indeg[e.dest]--;
                if (indeg[e.dest] == 0) {
                    q.add(e.dest);
                }
            }
        }
        System.out.println();
    }

    // 2nd attempt
    public static void DfsTop(ArrayList<Edge>[] graph) {
        boolean[] vis = new boolean[graph.length];
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < graph.length; i++) {
            DfsToputil(graph, vis, s, i);
        }

        while (!s.isEmpty()) {
            System.out.print(s.pop());
        }
    }

    public static void DfsToputil(ArrayList<Edge>[] graph, boolean[] vis, Stack<Integer> s, int curr) {
        vis[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!vis[e.dest]) {
                DfsToputil(graph, vis, s, e.dest);
            }
        }
        s.push(curr);
    }

    //Kahn's algorithm
    public static void Indeg(ArrayList<Edge>[] graph, int[] indeg) {

        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].size(); j++) {
                indeg[graph[i].get(j).dest]++;
            }
        }
    }

    public static void BfsTopo(ArrayList<Edge>[] graph) {
        int indeg[] = new int[graph.length];
        Indeg(graph, indeg);
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < graph.length; i++) {
            if (indeg[i] == 0) {
                q.add(i);
            }
        }
        while (!q.isEmpty()) {
            int curr = q.remove();
            System.out.print(curr + " ");
            for (int i = 0; i < graph[curr].size(); i++) {
                Edge e = graph[curr].get(i);
                indeg[e.dest]--;
                if (indeg[e.dest] == 0) {
                    q.add(e.dest);
                }
            }
        }
    }


    //using stack

    public void dffs(int i , boolean[] vis , Stack<Integer> st, ArrayList<ArrayList<Integer>>graph){
        vis[i] = true ;
        for(int it : graph.get(i)){
            if(!vis[it]){
                dffs(it, vis , st , graph);
            }
        }
        st.push(i);
    }

    public void TTopo(ArrayList<ArrayList<Integer>> graph , int V){
        boolean[] vis = new boolean[V];
        Stack<Integer> st = new Stack<>();
        for(int i = 0 ; i < V ; i++ ){
            if(!vis[i]){
                dffs(i, vis, st, graph);
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        while(!st.isEmpty()){
            ans.add(st.peek());
            st.pop();
        }

    }

    //3rd attempt 
    public static void indegg(ArrayList<ArrayList<Integer>> graph , int[] indeg){
        for(ArrayList<Integer> edges : graph){
            for(int i : edges){
                indeg[i]++ ;
            }
        }
    }
    public static void BfsSort(ArrayList<ArrayList<Integer>> graph){
        int indeg[] = new int[graph.size()];
        indegg(graph , indeg);
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0 ; i < indeg.length ; i++){
            if(indeg[i] == 0){
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            int curr = q.remove();
            System.out.print(curr+" ");
            for(int it : graph.get(curr)){
                indeg[it]-- ;
                if(indeg[it] == 0){
                    q.add(it);
                }
            }
        }
        System.out.println();
    }
}


