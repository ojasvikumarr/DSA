package LeetCode;

import java.util.Arrays;
import java.util.Queue;
import java.util.* ; 

public class Day105 {
    int MOD = 1000000009 ;
    public int solveV(int[] nums , int k){
        int n = nums.length;

        long[] inv = new long[n + 2];
        inv[0] = 1;
        inv[1] = 1;
        for (int i = 2; i <= n; i++) {
            inv[i] = MOD - (MOD / i) * inv[MOD % i] % MOD;
        }

        int primeK = k - 1;

        long[] ar = new long[n + 1];
        if (primeK >= 1) {
            ar[primeK] = 1;
            for (int m = primeK + 1; m <= n; m++) {
                ar[m] = (ar[m - 1] * m) % MOD;
                ar[m] = (ar[m] * inv[m - primeK]) % MOD;
            }
        }
        long[] sumC = new long[n + 1];
        if (primeK < 1) {
            Arrays.fill(sumC, 1);
        } else {
            sumC[0] = 1;
            for (int m = 1; m <= n; m++) {
                sumC[m] = (2 * sumC[m - 1]) % MOD;
                if (m - 1 >= primeK) {
                    sumC[m] = (sumC[m] - ar[m - 1] + MOD) % MOD;
                }
            }
        }
        int[] sortedAsc = Arrays.copyOf(nums, n);
        Arrays.sort(sortedAsc);
        int[] sortedDesc = Arrays.copyOf(sortedAsc, n);
        // System.out.println("yes");
        for (int i = 0; i < n / 2; i++) {
            int temp = sortedDesc[i];
            sortedDesc[i] = sortedDesc[n - i - 1];
            sortedDesc[n - i - 1] = temp;
        }
        long sumMin = 0;
        for (int i = 0; i < n; i++) {
            int m = n - i - 1;
            if (m < 0) continue;
            long contrib = sortedAsc[i];
            if (m >= 0) {
                contrib = (contrib * sumC[m]) % MOD;
            }
            sumMin = (sumMin + contrib) % MOD;
        }

        long sumMax = 0;
        for (int i = 0; i < n; i++) {
            int m = n - i - 1;
            if (m < 0) continue;
            long contrib = sortedDesc[i];
            if (m >= 0) {
                contrib = (contrib * sumC[m]) % MOD;
            }
            sumMax = (sumMax + contrib) % MOD;
        }
        long total = (sumMin + sumMax) % MOD;
        return (int) total;
    }
    class Solution {
    //tis is all the directions 
    int[][] dir = new int[][] {{0 , 1} , {0 , -1} , {1 , 0} , {-1 , 0}};
    public int minCost(int[][] grid) {
        int m = grid.length ; 
        int n = grid[0].length ; 
        int cost = 0 ;
        //memoization
        int[][] dp = new int[m][n];
        for(int i = 0 ; i < m ;i++) Arrays.fill(dp[i] , Integer.MAX_VALUE);
        // queue for BFS 
        Queue<int[]> bfs = new LinkedList<>();
        //Applying DFS from origin
        dfs(grid , 0 , 0 ,dp , cost , bfs);
        while(!bfs.isEmpty()){
            cost++ ; 
            int size = bfs.size();
            for(int j = 0 ; j < size ; j++){
                int[] top = bfs.poll();
                int r = top[0] , c = top[1];
                for(int i = 0 ; i < 4 ; i++){
                    dfs(grid , r + dir[i][0] , c + dir[i][1] , dp , cost , bfs);
                }
            }
        }
        return dp[m-1][n-1];
    }
    public void dfs(int[][] grid , int r , int c , int[][] dp , int cost , Queue<int[]> bfs){
        int m = grid.length ; 
        int n = grid[0].length ; 
        if(r < 0 || r >= m || c < 0 || c >= n || dp[r][c] != Integer.MAX_VALUE) return ; 
        dp[r][c] = cost ; 
        bfs.offer(new int[]{r , c});
        int nextDir = grid[r][c] - 1 ;
        dfs(grid , r + dir[nextDir][0] , c + dir[nextDir][1] , dp , cost , bfs);
    }
}
}
