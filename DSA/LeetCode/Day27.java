import java.util.*;

class Day27 {
    public void recurr(int idx, int[] nums, int k, ArrayList<Integer> ans, int count) {
        if (idx == 0) {
            HashMap<Integer, Integer> map = new HashMap<>();
            for (Integer a : ans) {
                map.put(a, map.getOrDefault(a, 0) + 1);
            }
            if (map.keySet().size() == k) {
                count++;
            }
            return;
        }
        ans.add(nums[idx]);
        idx = idx + 1;
        recurr(idx, nums, k, ans, count);
        ans.remove(ans.size() - 1);
        idx = idx - 1;
        recurr(idx, nums, k, ans, count);
    }

    public int KnapSack(int[] wts, int[] profit, int W) {
        int[][] dp = new int[wts.length + 1][W + 1];
        for (int i = 0; i <= wts.length; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i <= W; i++) {
            dp[0][i] = 0;
        }
        for (int i = 1; i <= wts.length; i++) {
            for (int j = 1; j <= W; j++) {
                if (wts[i] <= j) {
                    int pick = profit[i] + dp[i - 1][j - wts[i]];
                    int notPick = 0 + dp[i - 1][j];
                    dp[i][j] = Math.max(pick, notPick);
                }
            }
        }
        return dp[wts.length][W];
    }
}
