import java.util.Scanner;
import java.util.Arrays ;
import java.util.* ; 
public class cp55 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            long[] arr = new long[n];
            for(int i = 0 ; i < n ; i++) arr[i] = sc.nextLong();
            solve(arr , n);
        }
        sc.close();
    }
    public static void solve(long[] A , int n){
        long[] arr = Arrays.copyOf(A , n);
        Map<Long , Long> res = new HashMap<>();
        Arrays.sort(arr);
        long[] preSum = new long[n+1];
        for(int i = 0 ; i < n ; i++){
            preSum[i+1] = arr[i] + preSum[i];
        }
        for(int i = 1 ; i <= n ; i++){
            long no = i-1 ; 
            //we need to add the remain
            long target = preSum[i];
            //we need to find this in the remaining ortiong 
            int l = i-1 ; 
            int r = n-1 ; 
            int idx = 0 ; 
            while(l <= r){
                int mid = l + (r-l)/2 ; 
                if(arr[mid] <= target){
                    idx = mid+1 ; 
                    target = preSum[mid+1];
                    l = mid + 1; 
                }else{
                    r = mid - 1; 
                }
            }
            // System.out.print(idx + " ");
            no += (idx-i);
            res.put(arr[i-1] , no);
        }
        // System.out.println();
        for(Long ele : A){
            System.out.print(res.get(ele)+" ");
        }
        System.out.println();
    }
    
}
