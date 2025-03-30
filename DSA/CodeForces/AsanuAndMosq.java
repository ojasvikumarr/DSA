package CodeForces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class AsanuAndMosq {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0 ; i < n ; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            sb.append(solve(arr, n)+"\n");
        }
        System.out.println(sb.toString());
        br.close();
    }
    public static long solve(int[] arr , int n){
        int odds = 0 ; 
        int even = 0 ; 
        int maxi = 0 ; 
        for(Integer ele : arr){
            if(ele%2 == 0){
                even++ ; 
            }else{
                odds++ ;
            }
            maxi = Math.max(maxi , ele);
        }
        if(odds == 0 || even == 0){
            return maxi ; 
        }
        long sum = 0 ; 
        for(Integer ele : arr){
            if(ele%2 == 0){
                sum += (long)ele ; 
            }else{
                sum += (long)(ele-1);
            }
        }
        return sum + 1; 
    }
}
