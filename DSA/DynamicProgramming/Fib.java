package DynamicProgramming;

public class Fib {// O(2^n) --> O(n+1)
    public static int fib(int n, int[] f) {
        if (n == 0 || n == 1) {
            return n;
        }
        if (f[n] != 0) {
            return f[n];
        }
        f[n] = fib(n - 1, f) + fib(n - 2, f);
        return f[n];
    }

    public static int fibTab(int n) {
        int Dp[] = new int[n + 1];
        Dp[0] = 0;
        Dp[1] = 1;
        for (int i = 0; i < n; i++) {
            Dp[i] = Dp[i - 1] + Dp[i - 2];
        }
        return Dp[n];
    }

    public static void main(String[] args) {
        int n = 5;
        int[] f = new int[n + 1];
        System.out.println("The fib of 5 is : " + fib(n, f));
        System.out.println("The fib of 5 is : " + fibTab(n));
    }
}
