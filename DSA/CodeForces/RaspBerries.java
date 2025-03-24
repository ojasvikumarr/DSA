package CodeForces;

import java.util.Scanner;

public class RaspBerries {
     public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt(); 
            int k = sc.nextInt();
            int[] arr = new int[n];
            for(int i = 0 ; i < n ; i++) arr[i] = sc.nextInt();
            System.out.println(solve(arr, n, k));
        }
        sc.close();
    }
    public static int solve(int[] arr , int n , int k){
        //k can be from 2 to 5 only 
        int mini = Integer.MAX_VALUE ; 
        int evens = 0 ; 
        int odds = 0 ; 
        for(int i = 0 ; i < n ; i++){
            if(arr[i] %2 == 0) evens++ ;
            else odds++ ; 
            int diff = (int)Math.ceil((double)arr[i]/k)*k - arr[i] ;
            mini = Math.min(mini , diff);
        }
        // System.out.println("evens " + evens);
        // System.out.println("mini " + mini);
        if(k == 4){
            //two 2s can be there 
            // or we can say 2 evens or count number of evens 
            // if 2 >= evens --> 0 
            // else only 1 then 1 
            // else 2 
            if(evens >= 2){
                return 0 ;
            }else{
                return Math.min(2-evens , mini);
            }
        }else if( k == 2){
            if(evens >= 1){
                return 0 ;
            }
        }
        return mini ; 
    }
}
