package CodeForces;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MArrrays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = sc.nextInt();
            solve(arr, n, k);
        }
        sc.close();
    }

    public static void solve(int[] arr, int n, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(arr[i] % k, map.getOrDefault(arr[i] % k, 0) + 1);
        }
        long res = 0;
        for (int i = 0; i < k; i++) {
            if (!map.containsKey(i)) {
                // System.out.println(i + " --");
                continue;
            } else {
                // compliment
                int c = Math.abs(k - i);
                if(i%k == 0){
                    res += 1 ; 
                }else if(!map.containsKey(c)) {
                    // System.out.println("Ye" + c);
                    res += map.get(i);
                }else if(map.get(i) == map.get(c)) {
                    // System.out.println("Yes");
                    map.remove(c);
                    res += 1;
                }else {
                    // System.out.println(i + " --- " + map.get(i));
                    res += Math.abs(map.get(i) - map.get(c));
                    map.remove(c);
                }
            }
            // System.out.println(res);
        }
        System.out.println(res);
    }
}
