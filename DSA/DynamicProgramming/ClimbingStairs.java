package DynamicProgramming;

import java.util.*;

public class ClimbingStairs {
    public static int Climbingstairs(int n, int[] C) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return 0;
        }
        if (C[n] != -1) {
            return C[n];
        }
        C[n] = Climbingstairs(n - 1, C) + Climbingstairs(n - 2, C);
        return C[n];
    }

    public static int StairsTabulation(int n) {
        int D[] = new int[n + 1];
        D[0] = 1;

        for (int i = 1; i < n; i++) {
            if (i == 1) {
                D[i] = D[i - 1] + 0;
            } else {
                D[i] = D[i - 1] + D[i - 2];
            }
        }
        return D[n];
    }

    public static void main(String[] args) {
        int n = 10;
        int C[] = new int[n + 1];
        Arrays.fill(C, -1);
        System.out.println("No. ways to climb the stairs will be :" + Climbingstairs(n, C));
    }
}
