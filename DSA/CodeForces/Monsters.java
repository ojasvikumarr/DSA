package CodeForces;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Monsters {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            int p = sc.nextInt();
            PriorityQueue<int[]> pq = new PriorityQueue<>((a , b) ->{
                if(b[0] == a[0]){
                    return a[1] - b[1];
                }
                return b[0] - a[0];
            }) ;
            for(int i = 0 ; i < n ; i++){
                pq.add(new int[]{sc.nextInt(), i+1});
            }
            List<Integer> res = new ArrayList<>();
            while(!pq.isEmpty()){
                int[] curr = pq.poll();
                int val = curr[0];
                int idx = curr[1];
                if(val - p > 0){
                    val = val - (int)Math.floor((double)val/p)*p  ;
                    if(val == 0) val += p ; 
                    pq.offer(new int[]{val , idx});
                }else{
                    //it is 0 or neg
                    //we add it to our answer 
                    res.add(idx);
                }
            }

            for(Integer ele : res){
                System.out.print(ele + " ");
            }
            System.out.println();
        }
        
        sc.close();
    }
}
