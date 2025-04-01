package CodeForces;

import java.util.Scanner;

public class YetAnotherArray {
     public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int q = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i < n ; i++) arr[i] = sc.nextInt();
        int[] query = new int[q];
        for(int i = 0 ; i < q ; i++) query[i] = sc.nextInt();
        StringBuilder sb = new StringBuilder();

        for(int i = 0 ; i < q ; i++){
            int color = query[i];
            int idx = 0 ; 
            for(int j = 0 ; j < n; j++){
                if(color == arr[j]){
                    idx = j ; 
                    break ;
                }
            }
            sb.append(idx+1).append(" ");
                int temp = arr[idx];
                while(idx > 0){
                    arr[idx] = arr[idx-1];
                    idx-- ; 
                }
                arr[0] = temp ; 
        }
        System.out.println(sb.toString());
        sc.close();
    }
}
