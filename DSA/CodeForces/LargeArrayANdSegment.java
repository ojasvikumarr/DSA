package CodeForces;

import java.util.Scanner;

public class LargeArrayANdSegment {
     public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            int k = sc.nextInt();
            long x = sc.nextLong();
            int[] arr = new int[n];
            for(int i = 0 ; i < n; i++){
                arr[i] = sc.nextInt() ;
            }

            long sum = 0 ; 
            for(int i = 0 ; i < n ; i++){
                sum += arr[i] ; 
            }
            long total = sum*(long)k ; 
            long res = 0 ; 
            while(total >= x){
                if(total - sum >= x){
                    res += n ;
                    total -= sum ;
                } else{
                    res++ ; 
                    break ; 
                }
            }
            for(int i = 0 ; i < n ; i++){
                if(total - arr[i] >= x){
                    res++ ; 
                    // System.out.println(res + " " + arr[i] + " ----");
                    total -= arr[i] ;
                }else{
                   
                    break ; 
                }
            }

            sb.append(res).append("\n");
        }
        System.out.println(sb.toString());
        sc.close();
    }
}
