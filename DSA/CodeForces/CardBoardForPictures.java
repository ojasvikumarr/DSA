package CodeForces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CardBoardForPictures {
     public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(t-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            long[] arr = new long[n];
            st = new StringTokenizer(br.readLine());
            for(int i = 0 ; i < n ; i++){
                arr[i] = Long.parseLong(st.nextToken());
            }

            sb.append(solve(arr , n , c)).append("\n");

        }
        System.out.println(sb.toString());

    }
    public static long solve(long[] arr , int n , long c){
        for(Long l : arr){
            c -= l*l ;
        }
        long l = 1 ; 
        long r = (long) Math.sqrt(c / n) ; 
        long w = 0 ; 
        while(l <= r){
            long mid = l + (r - l)/2 ; 
            if(isPossible(arr , mid , c)){
                w = mid ; 
                l = mid+1 ;
            }else{
                r = mid - 1 ; 
            }
        }
        return w ; 
    }
    public static boolean isPossible(long[] arr , long w , long c){
        long val = 0 ; 
        for(int i = 0 ;i < arr.length ; i++){
            long s = arr[i];
            val += (s*w+w*w)*4L  ;
            if(val > c) return false ;
        }
        return true ;
    }
}
