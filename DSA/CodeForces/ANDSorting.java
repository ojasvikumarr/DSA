package CodeForces;

import java.util.Scanner;

public class ANDSorting {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt()  ;
        while(t-- > 0){
            int n  = sc.nextInt();
            int[] arr = new int[n];
            long and = (1L<<32) - 1 ; 
            for(int i = 0 ;i < n ; i++){
                arr[i] = sc.nextInt();
                if(arr[i] != i) and = (and&arr[i]);
            }
            System.out.println(and);
        }
        sc.close();
    }
}
