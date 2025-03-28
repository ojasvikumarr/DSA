package CodeForces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CountingOrders {
    static int MOD = (int)1e9 + 7  ;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            int n = Integer.parseInt(br.readLine());
            int[] a = new int[n];
            int[] b = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0 ; i < n ; i++){
                a[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for(int i = 0 ; i < n ; i++){
                b[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(a);
            Arrays.sort(b);
            for(int i = 0 ; i < n/2 ; i++){
                int temp = b[i];
                b[i] = b[n-1-i];
                b[n-1-i] = temp ; 
            }
            if(b[n-1] > a[0]){
                sb.append(0).append("\n");
                continue ; 
            }
            long result = 1 ; 
            for(int i = 0 ; i < n ; i++){
                int res = solve(a , b[i]);
                result = result * Math.max(res - i , 0)%MOD ;
            }
            sb.append(result).append("\n");
        }
        System.out.println(sb.toString());
    }
    public static int solve(int[] a, int x){
        int l = 0 ; 
        int r = a.length - 1 ; 
        // int interRes = 0 ; 
        while( l <= r){
            int mid = l + (r-l)/2 ; 
            if(a[mid] > x){
                // interRes = mid; /
                r = mid-1 ; 
            }else{
                l = mid+1 ; 
            }
        }
        return a.length - l ; 
    }
}
