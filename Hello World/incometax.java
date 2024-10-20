import java.util.*;

public class incometax{
    public static void main(String args[]){
    Scanner sc = new Scanner(System.in);
    int Income = sc.nextInt() ;
    if(Income<500000){
        System.out.println("Your tax will be 0");


    }
    else if ( Income>500000 && Income<1000000){
        System.out.println("the tax you've to pay will be " + (int)Income*0.20);

    }
    else {System.out.println("the tax you've to pay will be " + (int)Income*0.30);
}


    //largest of three numbers

    int a = sc.nextInt(); 
    int b = sc.nextInt();
    int c = sc.nextInt();
    if( a >= b && a >= c ){
        System.out.println("A is the largest");

    }
    else if( b >= c ){
        System.out.println(" B is the largest");
    }
    else{ System.out.println(" C is the largest");
}

    sc.close();
}
}