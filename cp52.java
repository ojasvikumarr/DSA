import java.util.Arrays ; 
import java.util.* ; 
public class cp52 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] arr = new int[n];
            for(int i = 0 ; i < n ;i++) arr[i] = sc.nextInt();
            System.out.println(solve(arr , n , k));
        }
        sc.close();
    }
    public static long solve(int[] arr , int n , int k){
        int[] sorted = Arrays.copyOf(arr, n);
        Arrays.sort(sorted);
        long sum = 0 ; 
        if(k > 1){
            for(int i = 0 ; i <= k ; i++){
                sum += sorted[n-i-1];
            }
            return sum ; 
        }else{
            //k == 1
            long maxi = Integer.MIN_VALUE ; 
            for(int i = 1 ; i < n-1 ; i++){
                maxi = Math.max(maxi , Math.max(arr[0] , arr[n-1]) + arr[i]);
            }
            maxi = Math.max(maxi , arr[0] + arr[n-1]);
            return maxi ; 
        }
    }
}