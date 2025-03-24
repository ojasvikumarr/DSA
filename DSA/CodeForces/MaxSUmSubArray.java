package CodeForces;
import java.util.* ; 
public class MaxSUmSubArray {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] arr = new int[n];
            for(int i = 0 ; i < n ; i++){
                arr[i] = sc.nextInt();
            }
            solve(arr , n , k);
        }
        sc.close();
    }
    public static void solve(int[] arr ,int n , int k){
        Arrays.sort(arr);
        long[] prefix = new long[n+1];
            for(int i = 0 ; i < n ; i++){
                prefix[i+1] += arr[i] + prefix[i];
            }
            // for(int i = 0 ; i <= n ; i++){
            //     System.out.print(prefix[i] + " ");
            // }
        int idx = n-k ; 
        int i = 0 ; 
        long maxi = Integer.MIN_VALUE ; 
        while(i+idx < n+1){
            // System.out.println(prefix[idx+i] + " " + prefix[i]);
            maxi = Math.max(maxi , prefix[idx+i] - prefix[i]);
            i += 2 ; 
            idx-- ; 
        }
        System.out.println(maxi);
    }
}
