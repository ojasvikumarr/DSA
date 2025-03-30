package CodeForces;

import java.util.Scanner;

public class LadyBug {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        StringBuilder res = new StringBuilder();

        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            String sa = sc.next();
            String sb = sc.next();
             
            if(solvI(sa, sb, n)){
                res.append("YES");
            }else{
                res.append("NO");
            }
            res.append("\n");
        }
        System.out.println(res.toString());
        sc.close();
    }
    public static boolean solvI(String a ,String b ,int n){
        int up = 0 ; 
        int down = 0 ;
        for(int i = 0; i < n ; i++){
            if(i%2 == 0){
                up += b.charAt(i)-'0';
                down += a.charAt(i)-'0';
            }else{
                down += b.charAt(i)-'0';
                up += a.charAt(i)-'0';
            }
        }
        if(n%2 != 0){
            int limit = (int)Math.floor((double)n/2);
            if(up <= limit+1 && down <= limit){
                return true ;
            }else{
                return false ;
            }
        }else{
            int limit = n/2 ;
            if(up <= limit && down <= limit){
                return true ;
            }else{
                return false ;
            }
        }
    }
    public static boolean solve(String a , String b , int n ){
        int odd = 0 ; 
        int even = 0 ;
        for(int i = 0 ; i < n ; i++){
            if(a.charAt(i) == '1'){
                if(i%2 != 0){
                    if(odd <= 0){
                        return false ; 
                    }else{
                        odd-- ; 
                    }
                }else{
                    if(even <= 0){
                        return false ; 
                    }else{
                        even-- ; 
                    }
                }
            }
            if(i%2 == 0 && b.charAt(i) == '0'){
                odd++ ; 
            }else if(i%2 != 0 && b.charAt(i) == '0'){
                even++ ; 
            }
        }
        return true ; 
    }
}
