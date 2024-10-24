import java.util.*;

public class cp14 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); 
        sc.nextLine(); 

        for (int tc = 0; tc < t; tc++) {
            int n = sc.nextInt();
            int[] arr = new int[n + 1]; 
            Map<Integer, Integer> mp = new HashMap<>();
            for (int i = 1; i <= n; i++) {
                arr[i] = sc.nextInt();
                mp.put(arr[i], i);
            }

            int ans = 0;

            for (int i = 1; i <= n; i++) {
                int curr = arr[i];
                if (i == arr[i]) continue; 

                int idx = mp.get(i); 

                if (idx == curr) continue; 
                int temp = arr[curr];
                arr[curr] = i;
                arr[idx] = temp;
                mp.put(i, curr);
                mp.put(temp, idx);
                ans++;
            }

            System.out.println(ans);
        }

        sc.close();
    }
}