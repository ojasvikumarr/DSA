package CodeForces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class tenzinNBooks {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder() ; 
        int t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            long x = Long.parseLong(st.nextToken());
            int[] a = new int[n];
            int[] b = new int[n];
            int[] c = new int[n];
            st = new StringTokenizer(br.readLine());
            for(int i = 0 ; i < n ; i++){
                a[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for(int i = 0 ; i < n ; i++){
                b[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for(int i = 0 ; i < n ; i++){
                c[i] = Integer.parseInt(st.nextToken());
            }

            if(solve(a, b, c, x)){
                sb.append("Yes").append("\n");
            }else{
                sb.append("No").append("\n");
            }
        }
        System.out.println(sb.toString());
    }
    public static boolean solve(int[] a , int[] b , int[] c , long x){
        long val = 0 ; 
        for(Integer ele : a){
            if((ele|x) != x) break; 
            val |= ele ; 
        }
        for(Integer ele : b){
            if((ele|x) != x) break; 
            val |= ele ; 
        }
        for(Integer ele : c){
            if((ele|x) != x) break; 
            val |= ele ; 
        }
        return val == x ; 
    }
}
