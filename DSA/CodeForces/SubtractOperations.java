package CodeForces;

import java.util.Arrays;
import java.util.Scanner;

public class SubtractOperations {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] arr = new int[n];
            for(int i = 0 ; i < n ; i++) arr[i] = sc.nextInt();
            //i just need to find if theirs a pair 
            //that satisfies a - b == k 
            Arrays.sort(arr);
            int i = 0 ; 
            boolean f = false ;
            int j = 1 ; 
            while(i < n && j < n){
                if(arr[j] - arr[i] == k){
                    f = true ;
                    break ;
                }else if(arr[j] - arr[i] > k){
                    i++ ;
                }else{
                    j++ ; 
                }
            }
            if(f){
                System.out.println("Yes");
            }else{
                System.out.println("No");
            }
        }
        sc.close();
    }
}
