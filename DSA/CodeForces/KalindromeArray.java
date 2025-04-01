package CodeForces;

import java.util.Scanner;

public class KalindromeArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int t = sc.nextInt();
        
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            if (solve(arr, n)) {
                sb.append("YES\n");
            } else {
                sb.append("NO\n");
            }
        }
        
        System.out.print(sb);
        sc.close();
    }

    public static boolean solve(int[] arr, int n) {
        for (int i = 0; i <= n / 2; i++) {
            if (arr[i] != arr[n - 1 - i]) {
                return check(arr, n, arr[i]) || check(arr, n, arr[n - 1 - i]);
            }
        }
        return true;
    }

    public static boolean check(int[] arr, int n, int x) {
        int left = 0, right = n - 1;
        while (left < right) {
            if (arr[left] == x) {
                left++;
                continue;
            }
            if (arr[right] == x) {
                right--;
                continue;
            }
            if (arr[left] != arr[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
