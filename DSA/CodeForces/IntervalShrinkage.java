package CodeForces;

import java.util.Scanner;

public class IntervalShrinkage {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] arr = new int[n];
            for(int i = 0 ; i < n ; i++) arr[i] = sc.nextInt();

            int start = arr[0] - k ; 
            int end = arr[0] + k ; 
            int cnt = 0 ; 
            for(int i = 1 ; i < n ; i++){
                int e1 = arr[i] + k ; 
                int s1 = arr[i] - k ; 
                if((end >= s1 && start <= e1) || (start <= e1 && start >= s1)){
                    end = Math.min(end , e1);
                    start = Math.max(start , s1);
                }else{
                    cnt++ ; 
                    start = s1 ; 
                    end = e1 ; 
                }
            }
            System.out.println(cnt);
        }
        sc.close();
    }
}
