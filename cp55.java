import java.util.Arrays ;
import java.util.* ; 
public class cp55 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            long n = sc.nextLong();
            long m = sc.nextLong();
            long k = sc.nextLong();
            solve(n, m, k);
        }
        sc.close();
    }
    
    public static void solve(long n , long m , long x ){
        long cols = (long)Math.ceil((double)x/n);
        long l = 1 ; 
        long r = cols ; 
        long res = 0 ; 
        while(l <= r){
            long mid = l+(r-l)/2 ; 
            if(isPossible(cols , mid , m)){
                res = mid ; 
                // System.out.println(res);
                r = mid-1 ; 
            }else{
                l = mid+1 ;
            }
        }
        // if(cols%2 == 0){
            System.out.println(res);
        // }else{
        //     System.out.println(res-1);
        // }
        
        return ; 
    }
    public static boolean isPossible(long cols , long mid , long m){
        // System.out.println(cols + " " + mid + " " + m + ' ');
        long rem = ((long)Math.ceil((double)cols/mid))*(mid+1) ;
        // System.out.println(rem);
        return  rem <= m+1; 
    }
}
