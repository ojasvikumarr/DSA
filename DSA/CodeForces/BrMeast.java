package CodeForces;

import java.util.Arrays;
import java.util.Scanner;

public class BrMeast {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            int q = sc.nextInt();
            int[] arr = new int[n];
            for(int i = 0 ; i < n; i++) arr[i] = sc.nextInt();
            for(int i = 0 ; i < q ; i++){
                int x = sc.nextInt();
                for(int j = 0 ; j < n; j++){
                    if((arr[i] % (1<<(x+1))) == 0){
                        arr[i] += (1<<(x)) ;
                    }
                }
            }
            for(int i = 0 ; i < n; i++){
                System.out.print(arr[i] + " ");
            }
            
        }
        sc.close();
    }
    
}
