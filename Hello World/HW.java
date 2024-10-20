import java.util.*;
public class HW{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        int b=sc.nextInt();
        int c=sc.nextInt();
        int sum=a+b+c;
        int avg=sum/3;
        System.out.println(avg);
            int side=sc.nextInt();
            int area=side*side;
            System.out.println("Area of the square is" + area);
        
                float pencil=sc.nextFloat();
                float pen=sc.nextFloat();
                float eraser=sc.nextFloat();
                float sum_=pen+pencil+eraser;
                float ctc=sum_*1.18f;
                System.out.println("the bill with gst is " + ctc);
        sc.close();






        

    }
}