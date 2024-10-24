import java.util.*;
import java.util.Arrays ;
public class cp12 {
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
        HashMap<Integer, Integer> sumFreq = new HashMap<>();
        int prefixSum = 0;
        int count = 0;
        int lastEnd = -1; 
        int zeros = 0 ; 
        // for(Integer it : arr){
        //     if(it == 0) zeros++ ;
        // }
        sumFreq.put(0, -1);

        for (int i = 0; i < arr.length; i++) {
            prefixSum += arr[i];

            if (sumFreq.containsKey(prefixSum)) {
                int prevIndex = sumFreq.get(prefixSum);
                if (prevIndex >= lastEnd) {
                    count++;
                    lastEnd = i;
                }
            }
            sumFreq.put(prefixSum, i);
        }

        return count;
    }

}
