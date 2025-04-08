package CodeForces;

import java.util.Scanner;

public class FairNumber {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            long n = sc.nextLong();

            while(true){
                String str = String.valueOf(n);
                boolean flag = true ;
                for(char c : str.toCharArray()){
                    int val = c-'0';
                    if(val == 0) continue ; 
                    if(n%val != -0){
                        n++ ; 
                        flag = false ;
                        break; 
                    }
                }
                if(flag == true){
                    System.out.println(n);
                    break ; 
                }
            }
        }
        sc.close();
    }
}
