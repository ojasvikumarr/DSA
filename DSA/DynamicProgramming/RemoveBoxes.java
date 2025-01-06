package DynamicProgramming;

public class RemoveBoxes {
    class Solution {
        // https://www.youtube.com/watch?v=ncW3zm_J3qY
        int[][][] dp ;
        public int removeBoxes(int[] boxes) {
            if(boxes == null || boxes.length == 0) return 0 ; 
            int n = boxes.length ; 
    
            dp = new int[n][n][n];
            return solve(0 , n-1 , 0 , boxes);
        }
        public int solve(int left, int right, int streak, int[] boxes) {
            if (left > right) return 0;
    
            if (dp[left][right][streak] != 0) return dp[left][right][streak];
    
            if (left == right) return (streak + 1) * (streak + 1);
    
            int maxi = solve(left + 1, right, 0, boxes) + (streak + 1) * (streak + 1);
    
            for (int i = left + 1; i <= right; i++) {
                if (boxes[left] == boxes[i]) {
                    maxi = Math.max(maxi, solve(left + 1, i - 1, 0, boxes) + solve(i, right, streak + 1, boxes));
                }
            }
    
            return dp[left][right][streak] = maxi;
        }
    }
}
