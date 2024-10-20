import java.util.*;

public class PrintAllPaths {

    static class Edge {
        int src;
        int dest;

        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    public static void printPathsUtil(ArrayList<Edge>[] graph, int src, int dest, String path) {
        if (src == dest) {
            System.out.println(path + dest);
            return;
        }
        for (int i = 0; i < graph[src].size(); i++) {
            Edge e = graph[src].get(i);
            printPathsUtil(graph, e.dest, dest, path + src);
        }
    }
    // public static void printPaths(ArrayList<Edge>[] graph , int src , int dest){

    // }
    public static void main(String[] args) {

    }
}
