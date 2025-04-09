package CodeForces;

import java.util.Scanner;

public class MINMexX {
     public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            solve(sc);
        }
        sc.close();
    }
    public static void solve(Scanner sc){
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i < n ; i++) arr[i] = sc.nextInt();
        int l = 0 ; 
        int h = n/k ; 
        int interRes =0 ;
        while(l <= h){
            int mid = l + (h - l)/2 ; 
            if(mex(mid , arr , k)){
                interRes = mid ; 
                l = mid+1 ;
            }else{
                h = mid-1 ;
            }
        }
        System.out.println(interRes);
    }
    public static boolean mex(int x , int[] arr , int k){
        boolean[] found = new boolean[x];
        int missing = x ;
        for(int i = 0 ; i < arr.length ; i++){
            if(arr[i] < x && found[arr[i]] == false ){
                found[arr[i]] = true ; 
                missing-- ;
            }
            if(missing == 0){
                k-- ; 
                found = new boolean[x];
                missing = x ; 
                if(k == 0) return true ;
            }
        }
        return k == 0 ; 
    }
}
