package CodeForces;

import java.util.Scanner;

public class ReverseAString {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
            String s = sc.next();
            boolean flag = false ;
            for(int i = 1 ; i < s.length() ; i++){
                if(((s.charAt(i)-'a') -( s.charAt(i-1)-'a')) < 0){
                    System.out.println("YES");
                    System.out.println((i) + " " + (i+1));
                    flag = true ; 
                    break;
                }
            }
            if(flag == false){
                System.out.println("NO");
            }
        sc.close();
    }
}
