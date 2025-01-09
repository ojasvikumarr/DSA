package LeetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Day95 {

    public static int solveV(int N, int[] A) {
        Map<Integer, Integer> firstMap = new HashMap<>();
        Map<Integer, Integer> LastMap = new HashMap<>();
        
        for (int i = 0; i < N; i++) {
            if (!firstMap.containsKey(A[i])) {
                firstMap.put(A[i], i);
            }
            LastMap.put(A[i], i);
        }

        // Calculate distinct prefix
        int[] pre = new int[N];
        Set<Integer> seen = new HashSet<>();
        for (int i = 0; i < N; i++) {
            seen.add(A[i]);
            pre[i] = seen.size();
        }

        // Calculate cost
        int cost = 0;
        int i = 0;
        int t= 0 ;
        while (i < N) {
            int j = i;
            int maxPos = LastMap.get(A[i]);
            while (j < N && j <= maxPos) {
                maxPos = Math.max(maxPos, LastMap.get(A[j]));
                j++;
            }
            int curr = pre[maxPos] - (i == 0 ? 0 : pre[i - 1]);
            cost += curr;
            i = j;
        }

        return cost;
    }

    public static int solveIv(int N, int[] A) {
        Map<Integer, Integer> mapLast = new HashMap<>();
        List<Integer> ls = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            mapLast.put(A[i], i);
        }

        int[] pre = new int[N];
        Set<Integer> seen = new HashSet<>();
        for (int i = 0; i < N; i++) {
            seen.add(A[i]);
            pre[i] = seen.size();
        }

        int cost = 0;
        int i = 0;
        while (i < N) {
            int j = i;
            int maxPos = mapLast.get(A[i]);
            while (j < N && j <= maxPos) {
                maxPos = Math.max(maxPos, mapLast.get(A[j]));
                j++;
            }

            // Add the cost for the current segment
            int curr = pre[maxPos] - (i == 0 ? 0 : pre[i - 1]);
            cost += curr;

            i = j; // Move to the next segment
        }

        return cost;
    }


    public static int minCostToMakeDistinct(int N, int[] A) {
        Map<Integer, Integer> mapFirst = new HashMap<>();
        Map<Integer, Integer> mapLast = new HashMap<>();
        
        for (int i = 0; i < N; i++) {
            mapFirst.putIfAbsent(A[i], i);
            mapLast.put(A[i], i);
        }

        List<Integer> ls = new ArrayList<>(mapLast.values());
        List<Integer> la = new ArrayList<>();
        Collections.sort(ls);

        int[] pre = new int[N];
        int[] distinctSuffix = new int[N];
        Set<Integer> seen = new HashSet<>();

        for (int i = 0; i < N; i++) {
            seen.add(A[i]);
            pre[i] = seen.size();
        }

        seen.clear();
        for (int i = N - 1; i >= 0; i--) {
            seen.add(A[i]);
            distinctSuffix[i] = seen.size();
        }

        int cost = 0;
        int i = 0;
        while (i < A.length) {
            int j = i;
            int maxPos = mapLast.get(A[i]);
            while (j < A.length && j <= maxPos) {
                maxPos = Math.max(maxPos, mapLast.get(A[j]));
                j++;
            }
            int curr = pre[maxPos] - (i == 0 ? 0 : pre[i - 1]);
            cost += curr;
            i = j;
        }

        return cost;
    }



    public static int solve(int N, int[] A) {
        Map<Integer, Integer> first = new HashMap<>();
        Map<Integer, Integer> last = new HashMap<>();
        for (int i = 0; i < N; i++) {
            first.putIfAbsent(A[i], i);
            last.put(A[i], i);
        }

        List<Integer> ls = new ArrayList<>(last.values());
        Collections.sort(ls);
        int[] pre = new int[N];
        int[] suff = new int[N];
        Set<Integer> seen = new HashSet<>();

        for (int i = 0; i < N; i++) {
            seen.add(A[i]);
            pre[i] = seen.size();
        }

        seen.clear();
        for (int i = N - 1; i >= 0; i--) {
            seen.add(A[i]);
            suff[i] = seen.size();
        }
        int cost = 0;
        int i = 0;
        while (i < N) {
            int j = i;
            int maxPos = last.get(A[i]);

            while (j < N && j <= maxPos) {
                maxPos = Math.max(maxPos, last.get(A[j]));
                j++;
            }
            int distinctInSegment = pre[maxPos] - (i == 0 ? 0 : pre[i - 1]);
            cost += distinctInSegment;
            i = j; 
        }

        return cost;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        while (T-- > 0) {
            int N = sc.nextInt();
            int[] A = new int[N];
            for (int i = 0; i < N; i++) {
                A[i] = sc.nextInt();
            }
            System.out.println(solve(N, A));
        }

        sc.close();
    }
}
