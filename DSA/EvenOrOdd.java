public class EvenOrOdd {
    public static void EvenOrodd (Integer n){
        int bitMask = 1 ;
        if ((n & bitMask) == 1){
            System.out.println("Your number is odd!!");
        }
        else{
            System.out.println("Your number is even!!");
        }
    }
    public static void main (String args[]){
        Integer n = 13 ;
        EvenOrodd(n);
    }
}