import java.util.*;

public class reverseNO{
    public static void main ( String args[] ){
        Scanner sc = new Scanner ( System.in );
        int n = sc.nextInt();
        int reverse = 1 ;
        while ( n > 0 ){
            int lastdigit = n%10;
            //remainder of the division of ANY number by 10 will give the last digit
            System.out.print(lastdigit);
            n /= 10;
            //n = n/10, if the number is divided by ten then we are eventually delelting the last number of N
            reverse = (( reverse * 10) + lastdigit);
        }  
        //System.out.println(reverse);

    }
    sc.close();
}