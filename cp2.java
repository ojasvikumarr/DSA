
import java.util.* ;
public class cp2 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int tc = 0 ; tc < t ; tc++){
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] arr = new int[n];
            for(int i =0 ; i < n ; i++){
                arr[i] = sc.nextInt();
            }
            System.out.println(helper(arr , n ,k));
        }
        sc.close();
    }


    public static int helper(int[] arr , int n , int k){
        PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> x-y);
        Set<Integer> set = new HashSet<>() ;
        for(int i = 0 ; i < n ; i++ ){
            set.add(arr[i]);
            pq.add(arr[i]);
        }
        if(set.size() > 1){
            while( k > 0 ){
            if(set.size() == 1) break ;
            int x = pq.poll();
            set.remove(x);
            x++ ;
            set.add(x);
            k-- ;
            pq.add(x);
            }
        }
        int h = 0 ;
        while(!pq.isEmpty()){
            arr[h++] = pq.poll();
        }
        
        Arrays.sort(arr);
        for (int i = 0; i < n / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[n - i - 1];
            arr[n - i - 1] = temp;
        }

        // Step 2: Initialize two sets and their sums
        List<Integer> set1 = new ArrayList<>();
        List<Integer> set2 = new ArrayList<>();
        int sum1 = 0, sum2 = 0;

        // Step 3: Distribute elements
        for (int num : arr) {
            if (sum1 + num <= sum2) {
                set1.add(num);
                sum1 += num;
            } else {
                set2.add(num);
                sum2 += num;
            }
        }

        // Return the two sets and the difference
        return Math.abs(sum1 - sum2);
    }
}
