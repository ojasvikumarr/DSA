public class Get_I_bit{
    public static int FastExpo(int a , int n){
        int ans =1 ;
        while (n > 0){
            if ((n&1) != 0){//check LSB
                ans = ans*a;
            }
            a=a*a;
            n=n>>1;
        }
        return ans;
    }
    public static int CountSetBits(int n ){
        int count = 0 ;
        while (n>0){
            if ((n&1) != 0){//CHeck LSB
                count ++;
            }
            n = n>>1;
        }
        return count;
    }
    public static void IsPowerOf22( int n){
        if ((n&(n-1))==0){
            System.out.println("yout number is a power of 2!!!");
        }
        else{
            System.out.println("yout number is not a power of 2!!!");
        }
    }
    public static boolean IsPowerOf2(int n){
        return (n&(n-1)) == 0;
    }
    public static int ClearIandJbits(int n , int i ,int j){
        int a = (~0)<<(j+1) ;
        int b = (1<<i)-1;
        int bitmask = a|b;
        return n & bitmask;
    }
    public static int ClearLastIbit(int n , int i){
        int bitmask = (~0)<<i;
        return n & bitmask;
    }
    public static int Update_I_bitII(int n , int i , int newBit){
        n = Clear_I_bit(n,i);
        int Bitmask = newBit<<i;
        return n | Bitmask;
    }
    public static int Update_I_bit(int n , int i , int newBit){
        if(newBit == 0){
            return Clear_I_bit(n,i);
        }
        else{
            return Set_I_bit(n,i);
        }
    }
    public static int Clear_I_bit(int n , int i){
        int bitmask = ~(1<<i);
        return n & bitmask;
    }
    public static int Set_I_bit(int n , int i){
        int bitmask = 1<<i;//it shifts the 1 by ith places in the value
        return n | bitmask ;
    }
    public static int GeT_I_bit(int n , int i){
        int bitmask = 1<<i ;
        if ((n & bitmask) == 0){
            return 0;
        }
        else{
            return 1;
        }
    }
    public static void main (String agrs[]){
        System.out.println(GeT_I_bit( 10 , 2));
        System.out.println(Set_I_bit( 10 , 2));
        System.out.println(Clear_I_bit( 10 , 2));
        System.out.println(Update_I_bit( 10 , 2 , 3));
        System.out.println(Update_I_bitII( 10 , 2 , 3));
        System.out.println(ClearLastIbit( 10 , 2));
        System.out.println(ClearIandJbits( 10 , 2 , 4));
        System.out.println(IsPowerOf2( 10 ));
        IsPowerOf22( 10 );
        System.out.println(CountSetBits( 10 ));
        System.out.println(FastExpo(3,3));
    }

}