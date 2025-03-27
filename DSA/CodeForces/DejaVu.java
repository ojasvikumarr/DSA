package CodeForces;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DejaVu {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            int q = sc.nextInt();
            int[] arr = new int[n];
            for(int i = 0 ; i < n ; i++) arr[i] = sc.nextInt();
            int cap = Integer.MAX_VALUE ; 
            List<Integer> queries = new ArrayList<>();
            for(int i = 0 ; i < q ; i++){
                int x = sc.nextInt();
                if(cap > x){
                    queries.add(x);
                    cap = x  ;
                }
            }

            for(Integer query : queries){
                int x = query ;
                for(int i = 0 ; i < n ; i++){
                    if(arr[i] % (1<<x) == 0){
                        arr[i] += (1<<(x-1));
                    }
                }
            }
            
            for(Integer ele : arr){
                System.out.print(ele + " ");
            }
            System.out.println() ; 
        }
        sc.close();
    }
}
