package DpOnDigits;

public class Count3s {
    static int[][][] dp;

    public static int countNoOf3s(int n) {
        String str = String.valueOf(n);
        // Initialize the DP array
        dp = new int[str.length()][2][str.length() + 1]; // 2 for the flag (true/false), length + 1 for count
        for (int i = 0; i < str.length(); i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < str.length() + 1; k++) {
                    dp[i][j][k] = -1; // Mark all states as unvisited
                }
            }
        }
        return Solve(str, 0, true, 0);
    }

    public static int Solve(String s, int idx, boolean flag, int cnt) {
        if (idx == s.length()) return cnt;

        int flagIndex = flag ? 1 : 0; // Convert boolean flag to integer for DP indexing
        if (dp[idx][flagIndex][cnt] != -1) return dp[idx][flagIndex][cnt]; // Return memoized result

        int limit = flag ? s.charAt(idx) - '0' : 9;
        int ans = 0;
        for (int i = 0; i <= limit; i++) {
            int newCnt = cnt + (i == 1 ? 1 : 0);
            ans += Solve(s, idx + 1, flag && (i == s.charAt(idx) - '0'), newCnt);
        }

        return dp[idx][flagIndex][cnt] = ans; // Store the result in dp and return
    }

    public static void main(String[] argv) {
        System.out.println(countNoOf3s(13)); // Example test
    }
}