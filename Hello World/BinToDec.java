public class BinToDec {
    public static void binTodec(int binNUM){
        int pow = 0;
        int n = binNUM;
        int decNUM=0;
        while (binNUM > 0){
            int Lastdigit = binNUM%10;
            decNUM = decNUM + (int)( Lastdigit * Math.pow(2,pow));
            //decNUM += ( Lastdigit * Math.pow(2,pow));
            pow++;
            binNUM = binNUM/10;

        }
        System.out.println("Decimal of "+n+" is: "+decNUM);
    }
    public static void DecTobin(int n){
        int pow = 0;
        int a=n;
        int decNum = 0;
        while (n>0){
            int lastdigit=n%2;
            decNum = decNum + (int)(lastdigit*Math.pow(10,pow));
            n = n/2;
            pow++;
        }
        System.out.println("Binary of "+a+" is: "+decNum);
    }
    public static void main ( String args [ ]) {
        int a= 1010101;
        binTodec(a);
        int n=10;
        DecTobin(n);
    }
}