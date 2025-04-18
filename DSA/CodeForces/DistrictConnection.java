package CodeForces;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class DistrictConnection {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            int[] arr = new int[n];

            for(int i = 0 ; i < n ; i++) arr[i] = sc.nextInt();
            Set<Integer> set = new HashSet<>();
            for(int i = 0 ; i < n ; i++){
                set.add(arr[i]);
            }
            if(set.size() == 1){
                System.out.println("NO");
                continue ;
            }
            // int count = 0 ; 

            System.out.println("YES");
            // set = new HashSet<>();
            // for(int i = 0 ; i < n ; i++){
            //     if(arr[i] == -1) continue ; 
            //     int temp = arr[i];
            //     int idx = i ; 
            //     for(int j = i+1 ; j < n ; j++){
            //         if(arr[j] != temp && !set.contains(j)){
            //             System.out.println((idx+1) + " " + (j+1));
            //             set.add(j);
            //             // arr[j] = -1 ; 
            //             count++ ; 
            //         }
            //         if(count == n-1) break ;
            //     }
            //     if(count == n-1) break ; 
            // }
            solve(arr, n);
        }
        sc.close();
    }
    public static void solve(int[] arr , int n){
        //do ko pakdo sabko dhar do 
        int ele = arr[0] ; 
        arr[0] = -1 ;
        for(int i = 1 ; i < n ; i++){
            if(arr[i] != ele){
                System.out.println(1 + " " + (i+1));
            }
        }

        int idx = -1 ;
        for(int i = 1 ; i < n ; i++){
            if(arr[i] != ele){
                ele2 = arr[i];
                idx = i ;
                break ;
            }
        }
        // System.out.println(idx+"  -- ");
        for(int i = 1 ; i < n ; i++){
            if(arr[i] == ele ){
                System.out.println((idx+1) + " " + (i+1));
                arr[i] = -1 ;
            }
        }
    }
}
