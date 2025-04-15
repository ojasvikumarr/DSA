package CodeForces;

import java.util.Scanner;

public class RoofConstruction {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            int ele = 1<<((int)Math.floor(Math.log(n-1)/Math.log(2)));

            int[] arr = new int[n];
            int i = 0 ; 
            int cnt = 1 ; 
            while(i < n){
                if(i == ele-1){
                    i++ ; 
                    continue ; 
                }
                arr[i] = cnt ; 
                cnt++ ;
                i++ ;
            }
            // int maxi = 0 ; 
            // for(int j = 1 ; j < n ; j++){
            //     maxi = Math.max(maxi , arr[j]^arr[j-1]);
            // }
            // System.out.println(maxi);
            for(int elm : arr){
                System.out.print(elm + " ");
            }
        
            // for(int i = 1 ; i < n ; i++){
            //     if(i == ele){
            //         System.out.print("0 ");
            //     }
            //     System.out.print(i + " ");
            // }
            System.out.println();
        }
        sc.close();
    }
}
