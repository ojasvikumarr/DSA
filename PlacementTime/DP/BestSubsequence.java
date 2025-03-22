package PlacementTime.DP;
import java.util.* ; 

public class BestSubsequence {


    static HashMap<String, Integer> memoMap; 

    static long solve(int[] a, int n, int k) {
        memoMap = new HashMap<>();  // Use HashMap for memoization
        return solveII(a, k, n-1, -1);
    }

    static int solveII(int[] arr, int k, int idx, int prev) {
        if (idx < 0) {
            return (k == 0) ? 0 : (int) 1e8;
        }

        if (k < 0) return (int) 1e8; 
        
        String key = idx + "," + k + "," + prev;
        if (memoMap.containsKey(key)) {
            return memoMap.get(key);
        }

        int pick = Integer.MAX_VALUE;
        if (k > 0) { // Ensure k does not go negative
            if (prev == -1) { 
                pick = solveII(arr, k-1, idx-1, idx);
            } else {
                pick = Math.abs(arr[idx] - arr[prev]) + solveII(arr, k-1, idx-1, idx);
            }
        }

        int notpick = solveII(arr, k, idx-1, prev);

        int result = Math.min(pick, notpick);
        memoMap.put(key, result); // Store result in HashMap

        return result;
    }
}