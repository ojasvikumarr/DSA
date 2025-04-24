package CodeForces;

import java.util.Scanner;

public class ADDSUmBig {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            int k = sc.nextInt();
            int Mod = (int)1e9 + 7 ; 
            long val = n ; 
            for(int i = 0 ; i < k-1 ; i++){
                val = (val*n)%Mod ; 
            }
            System.out.println(val);
        }
        sc.close();
    }
}
