package CodeForces;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RockAndLever {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i = 0 ;i < n ; i++) arr[i] = sc.nextInt();
            long res =0 ; 
            Map<Integer , Integer> map = new HashMap<>();

            for(int i = 0 ; i < n ; i++ ){
                int bit = Integer.highestOneBit(arr[i]);
                if(map.containsKey(bit)){
                    res += map.get(bit);
                }
                map.put(bit , map.getOrDefault(bit , 0)+1);
            }
            System.out.println(res);
        }
        sc.close();
    }
}
