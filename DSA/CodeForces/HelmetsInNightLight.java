package CodeForces;

import java.util.Arrays;
import java.util.Scanner;

public class HelmetsInNightLight {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt(); 
            int p = sc.nextInt();
            int[] no = new int[n];
            int[] price = new int[n];
            int[][] people = new int[n][2];
            for(int i = 0 ; i < n ; i++){
                no[i] = sc.nextInt();
            }
            for(int i = 0 ; i < n ; i++){
                price[i] = sc.nextInt();
            }
            for(int i = 0 ; i < n ; i++){
                people[i] = new int[]{no[i] , price[i]};
            }
            System.out.println(solve(people, n, p));
        }
        sc.close();
    }
    public static long solve(int[][] people , int n , int p){
        Arrays.sort(people , (a , b) ->{
            if(a[1] == b[1]){
                return b[0] - a[0];
            }
            return a[1] - b[1];
        });
        long cost = 0 ; 
        int i = 0 ; 
        int rem = n ; //first will always be taken BUT not be taken as well 
        cost += p ; 
        rem-- ; 
        while(i < n && people[i][1] < p ){
            int no = people[i][0];
            int cst = people[i][1];
            cost += (long)cst*(long)Math.min(no , rem) ; 
            rem = Math.max(rem - no , 0);
            if(rem == 0) break ; 
            i++ ; 
        }
        cost += (long)rem*(long)p ; 
        //Ya fir agar b is > p toh all p is the answer 
        long sumB = (long)p*(long)n ; 
        // if(cost == 0 ){
        //     return sumB ;
        // }else{
        // System.out.println(cost);
            return Math.min(sumB , cost);
        // }
    }
}
