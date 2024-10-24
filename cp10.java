import java.util.*;
import java.util.Arrays ;
public class cp10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); 
        sc.nextLine(); 

        for (int tc = 0; tc < t; tc++) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i = 0 ; i < n ; i++) arr[i] = sc.nextInt();
            System.out.println(recur(arr, 0));
        }

        sc.close();
    }

    public static int recur(int[] arr , int idx){
        if(idx == arr.length/2){
            int common = 0 ; 
            for(int i = 0 ; i < arr.length-1 ; i++){
                if(arr[i] == arr[i+1]) common++ ;
            }
            return common ;
        }
        int[] swapped = Arrays.copyOf(arr, arr.length);
        swap(swapped , idx , arr.length-idx-1);
        int swap = recur(swapped , idx+1);
        int noSwap = recur(arr, idx+1);
        return Math.min(swap , noSwap);
    }
    public static void swap(int[] arr , int i , int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp ; 
    }
    public static int maxZeroSumSubarrays(int[] arr) {
        HashMap<Integer, Integer> sumFreq = new HashMap<>();
        int cumulativeSum = 0;
        int count = 0;

        // Initialize with 0 sum having frequency 1
        sumFreq.put(0, 1);

        for (int num : arr) {
            cumulativeSum += num;

            // If the cumulative sum has been seen before, increment count
            if (sumFreq.containsKey(cumulativeSum)) {
                count += sumFreq.get(cumulativeSum);
            }

            // Increment the frequency of the cumulative sum in the map
            sumFreq.put(cumulativeSum, sumFreq.getOrDefault(cumulativeSum, 0) + 1);
        }

        return count;
    }
}
