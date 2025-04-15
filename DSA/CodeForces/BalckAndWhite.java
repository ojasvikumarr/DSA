package CodeForces;

import java.util.Scanner;

public class BalckAndWhite {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            int k = sc.nextInt();
            String s = sc.next();

            int l = 0 ; 
            int r = 0 ; 
            int maxi = n ; 
            int cnt = 0 ; 
            while(r < n){
                if(s.charAt(r) == 'B') cnt++ ;
                r++ ;
                if(r-l == k){
                    //matlab window of k 
                    maxi = Math.min(maxi , k-cnt);
                    if(s.charAt(l) == 'B') cnt-- ; 
                    l++ ; 
                }
            }
            System.out.println(maxi);
        }
        sc.close();
    }
}
