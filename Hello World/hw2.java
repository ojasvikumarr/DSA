import java.util.*;
public class hw2{
    public static void main(String args[]) {
        //Ques.1
        Scanner sc= new Scanner(System.in);
        System.out.print("Any number please!!!");
        int a =sc.nextInt() ;
        if(a >= 0){
            System.out.println("its a positive number");
       }
        else{
            System.out.println("its a negative number");
       }
        //      Ques.2
        double temp = 100.2;
        if ( temp >= 100){
            System.out.println("You've fever");
       }
        else {
            System.out.println("you're fine");
       }
        int ai = sc.nextInt();
        switch (ai){
            case 1 : System.out.println("It's Saturday!!");
            break;
            case 2 : System.out.println("It's Monday!!");
            break;
            case 3 : System.out.println("It's Tuesday!!");
            break;
            case 4 : System.out.println("It's Wednesday!!");
            break;
            case 5 : System.out.println("It's Thursday!!");
            break;
            case 6 : System.out.println("It's Friday!!");
            break;
            case 7 : System.out.println("It's Sunday!!");
            break;


        }
        sc.close();

    }
}