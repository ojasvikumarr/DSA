package DpOnDigits;
import java.util.Scanner;
import java.util.Arrays ;
public class ClassyNumbers {
    private static int[][][] dp;

    public static void main(String[] argv) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int l = sc.nextInt();
            int r = sc.nextInt();
            classy(l, r);
        }
        sc.close();
    }

    public static void classy(int l, int r) {
        String sR = String.valueOf(r);
        String sL = String.valueOf(l - 1);

        dp = new int[sR.length() + 1][2][4]; 
        initDP();
        int right = solve(sR, 0, true, 0);

        dp = new int[sL.length() + 1][2][4]; 
        initDP();
        int left = solve(sL, 0, true, 0);

        System.out.println(right - left);
    }

    public static int solve(String s, int idx, boolean flag, int cnt) {
        if (idx == s.length()) return cnt <= 3 ? 1 : 0; 
        if (cnt > 3) return 0; 

        int flagIndex = flag ? 1 : 0;
        if (dp[idx][flagIndex][cnt] != -1) return dp[idx][flagIndex][cnt];

        int limit = flag ? s.charAt(idx) - '0' : 9;
        int ans = 0;
        for (int i = 0; i <= limit; i++) {
            int newCnt = cnt + (i != 0 ? 1 : 0);
            ans += solve(s, idx + 1, flag && (i == limit), newCnt);
        }
        return dp[idx][flagIndex][cnt] = ans;
    }

    private static void initDP() {
        for (int[][] row : dp)
            for (int[] col : row)
                Arrays.fill(col, -1);
    }
}