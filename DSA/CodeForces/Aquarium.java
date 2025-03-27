package CodeForces;
import java.util.*; 
public class Aquarium{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            Long x = sc.nextLong();
            int[] arr = new int[n];
            for(int i = 0 ; i < n ; i++ ) arr[i] = sc.nextInt();
            solve(arr, n, x);
        }
        sc.close();
    }
    public static void solve(int[] arr , int n , long x){
        long l = 1 ; 
        long r = x + arr[0];
        long interRes = 0 ; 
        while(l <= r){
            long mid = l + (r - l)/2 ; 
            if(isPossible(arr , mid , x)){
                interRes = mid ; 
                l = mid + 1 ;
            }else{
                r = mid - 1 ; 
            }
        }
        System.out.println(interRes);
        return ; 
    }
    public static boolean isPossible(int[] arr , long h , long w){
        for(int i = 0 ; i < arr.length ; i++ ){
            if(arr[i] < h){
                w -= h - arr[i];
            }
            if(w < 0){
                return false ;
            }
        }
        return true ;
    }
}
