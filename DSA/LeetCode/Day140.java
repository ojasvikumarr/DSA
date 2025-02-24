package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Day140 {
    class Solution {
    Map<Integer, List<Integer>> adj = new HashMap<>();
    Map<Integer, Integer> bobMap = new HashMap<>();
    int aliceIncome;

    boolean DFSBob(int curr, int t, boolean[] visited) {
        visited[curr] = true;
        bobMap.put(curr, t);

        if (curr == 0) { // reached target
            return true;
        }

        for (int ngbr : adj.getOrDefault(curr, new ArrayList<>())) {
            if (!visited[ngbr]) {
                if (DFSBob(ngbr, t + 1, visited)) {
                    return true;
                }
            }
        }

        bobMap.remove(curr);
        return false;
    }
    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        int n = amount.length; // n nodes (0 to n-1)
        aliceIncome = Integer.MIN_VALUE;

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            adj.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            adj.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
        }

        // DFS on Bob for finding time to reach each node till 0
        int time = 0;
        boolean[] visited = new boolean[n];
        DFSBob(bob, time, visited);

        int income = 0;
        Arrays.fill(visited, false);

        // BFS se karunga
        Queue<int[]> que = new LinkedList<>();
        // {node, time, income}
        que.add(new int[]{0, 0, 0});

        while (!que.isEmpty()) {
            int[] front = que.poll();
            int curr = front[0];
            int t = front[1];
            int inc = front[2];

            if (!bobMap.containsKey(curr) || bobMap.get(curr) > t) {
                inc += amount[curr];
            } else if (t == bobMap.get(curr)) {
                inc += (amount[curr] / 2);
            }

            if (adj.getOrDefault(curr, new ArrayList<>()).size() == 1 && curr != 0) {
                aliceIncome = Math.max(aliceIncome, inc);
            }

            for (int ngbr : adj.getOrDefault(curr, new ArrayList<>())) {
                if (!visited[ngbr]) {
                    que.add(new int[]{ngbr, t + 1, inc});
                }
            }

            visited[curr] = true;
        }

        return aliceIncome;
    }
}
}
