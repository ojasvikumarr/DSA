package PlacementTime.Intuitive;

import java.util.Scanner;

public class RedAndBlack {
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            int r = sc.nextInt();
            int b = sc.nextInt();
            int turn = (int)Math.ceil((double)r/(b+1));
            // if(r%2 == 1){
            //     turn = (int)Math.ceil((double)(r+1)/(b));
            // }else if(r%2 == 0 && b % 2 == 0){
            //     turn = (int)Math.ceil((double)(r)/(b+1));
            // }
            // if(b%2 == 0){
            //     turn = (int)Math.ceil((double)r/(b+1));
            // }
            if(b == 1) turn = (r+1)/2 ;
            int cnt = 0 ; 
            for(int i = 0 ; i < r ; i++){
                if(i > 0 && cnt == turn && b > 0){
                    System.out.print("B");
                    turn = (int)Math.ceil((double)(r-i-1)/(b));
                    cnt = 0 ;
                    b-- ; 
                }
                System.out.print("R");
                cnt++ ; 
            }
            while(b > 0){
                System.out.print("B");
                b-- ; 
            }
            System.out.println();
        }
        sc.close();
    }
}
