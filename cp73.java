import java.util.*;
import java.util.Arrays ;
public class cp73 {

    static boolean check(int mex, int[] arr, int k) {
        boolean[] found = new boolean[mex];
        int missing = mex;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < mex && !found[arr[i]]) {
                found[arr[i]] = true;
                missing--;
            }
            if (missing == 0) {
                k--;
                Arrays.fill(found, false);
                missing = mex;

                if (k <= 0) return true;
            }
        }

        return k <= 0;
    }

    static void solve(Scanner sc) {
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

        int low = 0, high = n / k, ans = 0;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (check(mid, arr, k)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        System.out.println(ans);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            solve(sc);
        }
    }
}

