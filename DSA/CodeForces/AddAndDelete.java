package CodeForces;

import java.util.Scanner;

public class AddAndDelete {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int A = sc.nextInt();
            int B = sc.nextInt();

           
            int res = A+3 ; 
            for(int i=(B<2?2-B:0); i<res; ++i){
                int ans = i ; 
                int a = A  ; 
                int b = B+i ; 
                while(a != 0){
                    a /= b ; 
                    ans++ ; 
                }
                if(ans < res) res = ans ; 
            }
            System.out.println(res);
        }
        sc.close();
    }
}
