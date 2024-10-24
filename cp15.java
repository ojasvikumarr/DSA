import java.util.*;

public class cp15 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); // Read the number of test cases

        while (t-- > 0) {
            solve(sc);
        }

        sc.close();
    }

    private static void solve(Scanner sc) {
        int n = sc.nextInt();
        int[] input = new int[n + 1]; // 1-based indexing
        Map<Integer, Integer> mp = new HashMap<>();

        // Reading input and filling the map
        for (int i = 1; i <= n; i++) {
            input[i] = sc.nextInt();
            mp.put(input[i], i);
        }

        int ans = 0;

        for (int i = 1; i <= n; i++) {
            int curr = input[i];
            if (i == input[i]) continue; // If already in place

            int idx = mp.get(i); // Get the index of i

            if (idx == curr) continue; // If already pointing correctly

            // Debug statements (commented out)
            // System.err.println("i: " + i);
            // System.err.println("curr: " + curr);
            // System.err.println("idx: " + idx);

            // Perform the swap
            int temp = input[curr];
            input[curr] = i;
            input[idx] = temp;

            // Update the map
            mp.put(i, curr);
            mp.put(temp, idx);
            ans++;
        }

        System.out.println(ans);
    }
}