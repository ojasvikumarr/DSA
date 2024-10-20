import java.util.*;
public class HW3 {
    public static int avg (int a, int b, int c){
        int Avg = (a+b+c)/3;
        return Avg;
        
    }
    public static boolean isEVEN( int a){
        if(a%2 == 0 ){
            return true; 
        }
        return false;
    }
    public static boolean palindrom( int a ){
        if ( a % 11 == 0 ){
            return true;
        }
        return false;
    }
    /*public static double palindrome (int a){
        int reverse=0;
        int pow = 0;
        int lastdigit = a%10;
        if (a>0){
        reverse = reverse + (lastdigit*Math.sqrt(10,pow));
        pow++;
        a = a/10;}
        //System.out.println(reverse);
        //return reverse;

    }*/
    public static void palindrome(int n){
        
        int reverse = 0;
        while ( n>0 ){
            int lastdigit = n%10;
            System.out.print(lastdigit);
        reverse = ((reverse*10) + lastdigit);
        n /= 10 ; 
        }

    }

    public static void main(String args[]){
        Scanner sc = new Scanner (System.in);
        /*
        System.out.println("The avg of three numbers is : "+avg(2,4,6));
        System.out.println("Enter your number of which you need to find whether it's even or not??");
        int a = sc.nextInt();
        System.out.println("your number is : "+isEVEN(a));
        System.out.println("Enter your number of which you need to find whether it's palindrome or not??");
        */
        int b = sc.nextInt();
        System.out.println("your number is : "+palindrom(b));
        palindrome(12122);
        sc.close();
    }
}