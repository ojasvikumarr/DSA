package DpOnBitMasking;
import java.util.* ; 

public class BitTricks {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        for(char c = 'a' ; c <= 'z' ; c++){
            System.out.println(Integer.toBinaryString(c) + " === " + Integer.toBinaryString(c+32));
        }
        for(char c = 'A' ; c <= 'Z' ; c++){
            System.out.println(Integer.toBinaryString((c^(1<<5))) + " --- " + (char)(c^(1<<5)));
        }
        System.out.println(1^1);
        System.out.println(1^0);
        System.out.println(0^0);
        System.out.println((char)(1<<5));
        System.out.println((char)('a' & '_'));
        sc.close();
    }

}
