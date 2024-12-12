package Graphs;
import java.util.* ;

public class EvaluationDivision {


class Solution {
    class Pair {
        String str;
        double wt;

        public Pair(String s, double d) {
            this.str = s;
            this.wt = d;
        }
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        // Create adjacency list
        HashMap<String, ArrayList<Pair>> adjList = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            String u = equations.get(i).get(0);
            String v = equations.get(i).get(1);
            double value = values[i];

            adjList.putIfAbsent(u, new ArrayList<>());
            adjList.putIfAbsent(v, new ArrayList<>());
            adjList.get(u).add(new Pair(v, value));
            adjList.get(v).add(new Pair(u, 1.0 / value));
        }

        // Process queries
        double[] ans = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            String src = queries.get(i).get(0);
            String dest = queries.get(i).get(1);

            if (!adjList.containsKey(src) || !adjList.containsKey(dest)) {
                ans[i] = -1.0;
            } else {
                ans[i] = bfs(adjList, src, dest);
            }
        }
        return ans;
    }

    private double bfs(HashMap<String, ArrayList<Pair>> adjList, String src, String dest) {
        if (src.equals(dest)) return 1.0;

        Queue<Pair> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        q.add(new Pair(src, 1.0));
        visited.add(src);

        while (!q.isEmpty()) {
            Pair current = q.poll();
            String node = current.str;
            double weight = current.wt;

            for (Pair neighbor : adjList.get(node)) {
                if (!visited.contains(neighbor.str)) {
                    double newWeight = weight * neighbor.wt;

                    if (neighbor.str.equals(dest)) {
                        return newWeight;
                    }

                    q.add(new Pair(neighbor.str, newWeight));
                    visited.add(neighbor.str);
                }
            }
        }

        return -1.0; // If no path is found
    }
}
}
