package CodeForces;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class DivanAndNewProject {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            List<Pair> ls = new ArrayList<>();
            for(int i = 0 ; i < n ; i++){   
                ls.add(new Pair(sc.nextInt() , i+1));
            }

            Collections.sort(ls , (a , b) -> b.val - a.val);

            long[] pos = new long[n+1];
            long dist = 1 ; 
            long ans = 0 ; 

            pos[0] = 0; // center

            for(int i = 0 ; i < n ; i++){
                int idx = ls.get(i).idx;
                if(i % 2 == 0){
                    pos[idx] = dist;
                } else {
                    pos[idx] = -dist;
                    dist++;
                }
                ans += 2 * Math.abs(pos[idx]) * ls.get(i).val;
            }

            System.out.println(ans);
            for(int i = 0 ; i <= n ; i++){
                System.out.print(pos[i]+" ");
            }
            System.out.println();
        }
        sc.close();
    }

    static class Pair{
        int val ; 
        int idx ; 
        public Pair(int v , int i){
            this.val = v ; 
            this.idx = i ; 
        }
    }
}
