import java.util.*;

public class Ifelse{
    public static void main(String args[]){
        int age=12;
        if(age>=18){
            System.out.println("ADULT:wake,eat,sleep,repeat");
        }
        if(age>13 && age<18){
            System.out.println("Teenager");
        }
        else{
            System.out.println("KID");
        }
    


        int a=1;
        int b=3;

        if(a>b){
            System.out.println("a>b");

        }
        if( a==b ){
            System.out.println("a=b");
        }

        else{
            System.out.println("a<b");
        }

//Print if the number is even or odd
        Scanner sc=new Scanner(System.in);
        int number =sc.nextInt();


        if( number%2==0){
            System.out.println("even");
        }
        else{
            System.out.println("odd");

        }


        //else if
        int d=19;
        //if (IF statement is false then only ELSEIF statement will be seen by the compiler 
        //otherwise th ecompiler will directly give the answer on seeing IF statement when true
        //it decreases the time required to compile
        if(d >= 18){
            System.out.println("ADULT");


        }  
        // else if(d < 13 && d > 18){
        //     System.out.println("Teenager");

        // }
        // else(System.out.println("Not adult");
        // )
        sc.close();
      }
}
