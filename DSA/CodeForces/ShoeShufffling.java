package CodeForces;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ShoeShufffling {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            int[] arr = new int[n];
            Map<Integer , Integer> map = new HashMap<>();
            for(int i = 0 ; i < n ; i++){
                arr[i] = sc.nextInt();
                map.put(arr[i] , map.getOrDefault(arr[i] , 0)+1);
            }
            //already sorted 
            boolean flag = true ; 
            for(Integer key : map.keySet()){
                if(map.get(key) == 1){
                    flag =  false ; 
                    break ;
                }
            }
            if(!flag){
                System.out.println("-1");
            }else{
                for(int i = 1 ; i <= n ; i++){
                    int f = map.get(arr[i])-1;
                    int val = i++ ;
                    while(f-- > 0){
                        System.out.print(i+" ");
                        i++ ;
                    }
                    System.out.print(val+" ");
                    i-- ;
                }
            }
            System.out.println();
        }
        sc.close();
    }
}
