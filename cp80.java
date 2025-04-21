import java.util.*;
import java.util.Arrays ; 

public class cp80 {
    // Helper function to get median of a subarray
    static int getMedian(int[] arr, int l, int r) {
        int len = r - l + 1;
        int[] temp = new int[len];
        for (int i = 0; i < len; i++) temp[i] = arr[l + i];
        Arrays.sort(temp);
        return temp[(len - 1) / 2];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = sc.nextInt();
            boolean found = false;
            boolean allLessOrEqual = true;
            List<Integer> positions = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (a[i] > k) allLessOrEqual = false;
                if (a[i] <= k) positions.add(i);
            }
            if (allLessOrEqual) {
                System.out.println("YES");
                continue;
            }

            for (int i = 0; i < positions.size(); i++) {
                for (int j = i + 1; j < positions.size(); j++) {
                    if (positions.get(j) - positions.get(i) >= 2) {
                        found = true;
                        break;
                    }
                }
                if (found) break;
            }
            System.out.println(found ? "YES" : "NO");

            // // For small n, brute force all splits
            // if (n <= 300) {
            //     for (int l = 0; l < n - 2 && !found; l++) {
            //         for (int r = l + 1; r < n - 1 && !found; r++) {
            //             int m1 = getMedian(a, 0, l);
            //             int m2 = getMedian(a, l + 1, r);
            //             int m3 = getMedian(a, r + 1, n - 1);
            //             int[] meds = {m1, m2, m3};
            //             Arrays.sort(meds);
            //             if (meds[1] <= k) found = true;
            //         }
            //     }
            // } else {
            //     // For large n, check if there exist two elements ≤ k with at least one index between them
            //     List<Integer> indices = new ArrayList<>();
            //     for (int i = 0; i < n; i++)
            //         if (a[i] <= k) indices.add(i);
            //     for (int i = 0; i < indices.size(); i++) {
            //         for (int j = i + 1; j < indices.size(); j++) {
            //             if (Math.abs(indices.get(i) - indices.get(j)) >= 2) {
            //                 found = true;
            //                 break;
            //             }
            //         }
            //         if (found) break;
            //     }
            // }
            // // }
            // System.out.println(found ? "YES" : "NO");
        }
    }
}
