import java.util.*;
import java.util.Arrays ;
public class cp11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); 
        sc.nextLine(); 

        for (int tc = 0; tc < t; tc++) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i = 0 ; i < n ; i++) arr[i] = sc.nextInt();
            Map<String, Integer> memo = new HashMap<>();
            System.out.println(recur(arr, 0, memo));
        }

        sc.close();
    }

    public static int recur(int[] arr, int idx, Map<String, Integer> memo) {
        if (idx == arr.length / 2) {
            int common = 0; 
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] == arr[i + 1]) common++;
            }
            return common;
        }

        String key = idx + Arrays.toString(arr);

        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        int[] swapped = Arrays.copyOf(arr, arr.length);
        swap(swapped, idx, arr.length - idx - 1);
        int swap = recur(swapped, idx + 1, memo);

        int noSwap = recur(arr, idx + 1, memo);

        int result = Math.min(swap, noSwap);
        memo.put(key, result);

        return result;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp; 
    }
}