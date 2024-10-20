import java.util.*;

public class typePromotion{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        short a=2;
        char b=10;
        short d=10;
        byte bt= (byte)(a+b+d);
        System.out.println((int)(b));
        sc.close();
        System.out.println( bt);

    }
}