package DynamicProgramming;

public class ChampagneGlasses {
    class Solution {
        public double champagneTower(int poured, int row, int col) {
            return tabulation(poured, row, col);
        }
    
        public double tabulation(int poured, int row, int col) {
            double[][] dp = new double[row + 1][row + 1]; // Use correct DP size
            dp[0][0] = poured;
    
            for (int i = 0; i < row; i++) {
                for (int j = 0; j <= i; j++) {
                    if (dp[i][j] > 1) { // Overflow condition
                        double excess = (dp[i][j] - 1) / 2.0;
                        dp[i + 1][j] += excess;
                        dp[i + 1][j + 1] += excess;
                        dp[i][j] = 1; // Cap at 1 glass
                    }
                }
            }
            
            return Math.min(1, dp[row][col]); // Glasses cannot hold more than 1
        }
    }
}
