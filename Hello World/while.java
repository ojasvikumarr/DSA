import java.util.*;
public class while{
    public static void main( String args[]){
            Scanner sc = new Scanner (System.in);
        System.out.println("any positive number!!");
        int counter = sc.nextInt();
        while( counter >= 0){
            System.out.println("Hello" + counter );
            counter--;

        }

    }
}