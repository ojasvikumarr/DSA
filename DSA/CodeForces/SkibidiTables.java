package CodeForces;

import java.util.Scanner;

public class SkibidiTables {
    static long solveQuery1(long x, long y, int n) {
        if (n == 1) {
            if (x == 1 && y == 1) return 1;
            if (x == 2 && y == 2) return 2;
            if (x == 2 && y == 1) return 3;
            if (x == 1 && y == 2) return 4;
            return -1;
        }

        long half = 1L << (n - 1);
        long limit = half * half;

        if (x <= half && y <= half) {
            return solveQuery1(x, y, n - 1);
        } else if (x > half && y > half) {
            return limit + solveQuery1(x - half, y - half, n - 1);
        } else if (x > half && y <= half) {
            return 2 * limit + solveQuery1(x - half, y, n - 1);
        } else {
            return 3 * limit + solveQuery1(x, y - half, n - 1);
        }
    }

    static long[] getCoord(long val, int n) {
        if (n == 1) {
            if (val == 1) return new long[]{1, 1};
            if (val == 2) return new long[]{2, 2};
            if (val == 3) return new long[]{2, 1};
            if (val == 4) return new long[]{1, 2};
            return new long[]{-1, -1};
        }

        long half = 1L << (n - 1);
        long limit = half * half;

        if (val <= limit) {
            return getCoord(val, n - 1);
        } else if (val <= 2 * limit) {
            long[] coords = getCoord(val - limit, n - 1);
            return new long[]{coords[0] + half, coords[1] + half};
        } else if (val <= 3 * limit) {
            long[] coords = getCoord(val - 2 * limit, n - 1);
            return new long[]{coords[0] + half, coords[1]};
        } else {
            long[] coords = getCoord(val - 3 * limit, n - 1);
            return new long[]{coords[0], coords[1] + half};
        }
    }

    static void ojasviCodes(Scanner sc) {
        int n = sc.nextInt();
        int q = sc.nextInt();

        while (q-- > 0) {
            String dir = sc.next();
            if (dir.equals("->")) {
                long x = sc.nextLong();
                long y = sc.nextLong();
                System.out.println(solveQuery1(x, y, n));
            } else if (dir.equals("<-")) {
                long val = sc.nextLong();
                long[] coords = getCoord(val, n);
                System.out.println(coords[0] + " " + coords[1]);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            ojasviCodes(sc);
        }
    }
}
