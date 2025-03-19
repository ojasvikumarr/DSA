package CodeForces;

import java.util.* ; 

public class SwapNDelete {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            String s = sc.next();
            solve(s);
        }
        sc.close();
    }
    public static void solve(String s){
        int a0 = 0 ; 
        int a1 = 0 ; 
        int b0 = 0 ; 
        int b1 = 0 ; 
        for(char c : s.toCharArray()){
            if(c == '0'){
                a0++ ;
            }else{
                a1++ ;
            }
        }
        b0 = a0 ; 
        b1 = a1 ; 
        if(b0 == a1 && b1 == a0){
            System.out.println(0);
            return ;
        }
        int n = s.length();
        int count = 0 ; 
        for(int i = n-1 ; i >= 0 ; i--){
            if(s.charAt(i) == '0'){
                a0-- ; 
                //now i need to decrement from b 
                if(b0 > a1) b0--  ;
                else b1-- ; 
            }else{
                a1-- ; 
                if(b0 > a1) b0--  ;
                else b1-- ;
            }
            count++ ; 
            if(b0 == a1 && b1 == a0){
                System.out.println(count);
                return ; 
            }
        }
    }
}
