package CodeForces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class lunaticNeverContent {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            long[] arr = new long[n];
            for(int i = 0 ; i < n ; i++){
                arr[i] = Long.parseLong(st.nextToken());
            }
            int i = 0 ; 
            int j = n-1 ; 
            boolean flag = true ; 
            while(i < j){
                if(arr[i] != arr[j]){
                    flag = false ; 
                    break ; 
                }
            }
            if(flag == true){
                sb.append(0).append("\n");
                continue ;
            }
            sb.append(solve(arr , n)).append("\n");
        }
        System.out.println(sb.toString());
    }
    public static long solve(long[] arr , int n ){
        int l = 0;
        int r = n-1;
        long interRes = 1 ; 
        while(l < r){
            long diff = Math.abs(arr[l] - arr[r]);
            if(diff == 1){
                return 1; 
            }
            l++ ; 
            r-- ; 
        }
        l = 0;
        r = n-1;
        while(l < r){
            long diff = Math.abs(arr[l] - arr[r]);
            if(diff != 0 && isPossible(arr , diff)){
                interRes = Math.max(diff , interRes); 
            }
            l++ ; 
            r-- ; 
        }
        return interRes ; 
    }
    public static boolean isPossible(long[] arr , long mid){
        int i = 0 ; 
        int j = arr.length-1 ; 
        while(i < j){
            if((arr[i]%mid) != (arr[j]%mid)){
                return false ;
            }
            i++ ; 
            j-- ; 
        }
        return true ; 
    }
}
