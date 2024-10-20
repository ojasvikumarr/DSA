import java.util.*;
public class Functions {
    public static void printhelloworld(){
        System.out.println("Hello World!!");//this is a function or can be called as Method 

    }
    public static void SUM(int num1 , int num2 ){//here the (int num1 , int num2 ) statement recieves the value from SUM(a,b) and puts them in the function this thing is called parameters
        //here its know as paramters/formal parameters
        
        System.out.println("The sum of the two numbers is : "+ (num1 + num2));
    }
    
    public static void main ( String args [] ){
            printhelloworld();
            Scanner sc = new Scanner ( System.in );
            System.out.println("Enter first number :");
            int a = sc.nextInt();
            System.out.println("ENter second number :");
            int b = sc.nextInt();
            SUM(a,b);//this means that we can have the values from any variable and use them in function using different variables by alotting them the values 
            //here they're known as arguments/actual parameters
            sc.close();
    }
}