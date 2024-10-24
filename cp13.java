import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class cp13 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); 
        sc.nextLine(); 

        for (int tc = 0; tc < t; tc++) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i = 0 ; i < n ; i++) arr[i] = sc.nextInt();
            System.out.println(helper(arr));
        }

        sc.close();
    }
    
    public static int helper(int[] arr) {
        Map<Integer, Integer> freqMap = new HashMap<>();

        // Count the frequency of each element
        for (int num : arr) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        int maxFreq = 0;
        int n = arr.length;

        // Find the maximum frequency
        for (int count : freqMap.values()) {
            maxFreq = Math.max(maxFreq, count);
        }

        // Calculate disturbance
        // If maxFreq is too high to fit without overlap
        if (maxFreq > (n + 1) / 2) {
            return maxFreq - (n - maxFreq);
        }

        return 0; // No disturbance if maxFreq is manageable
    }
}
