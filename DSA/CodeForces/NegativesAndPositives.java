package CodeForces;

import java.util.Scanner;

public class NegativesAndPositives {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            int[] arr = new int[n];
            
            for(int i = 0 ; i < n ; i++){
                arr[i] = sc.nextInt();
                
            }
            sb.append(solve(arr, n));
            sb.append("\n");
        }
        System.out.println(sb.toString());
        sc.close();
    }
    public static long solve(int[] arr , int n ){
        long sum = 0 ;
        int mini = Integer.MAX_VALUE ; 
        int negs = 0 ; 
        for(int i = 0 ; i < arr.length ; i++){
            mini = Math.min(mini , Math.abs(arr[i]));
            if(arr[i] < 0) negs++ ; 
            sum += Math.abs(arr[i]);
            // System.out.print(Math.abs(arr[i]) + " ");
        }
        // System.out.println();
        if(negs % 2 == 0){
            return sum ; 
        }else{
            return sum - 2*mini; 
        }
    }
}
