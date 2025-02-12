package CodeForces;
import java.util.* ; 

public class Div2_1004 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            long n = sc.nextInt();
            solve(n);
        }
        sc.close() ; 
    }
    public static void solve(long n){
        int k = 0 ; 
        long min = Integer.MAX_VALUE ; 
        while(k <= 9){
            long newN = n - k ; 
            //Check is 7 present 
            long mini = Integer.MAX_VALUE ;
            while(newN > 0){
                long digit = newN%10 ; 
                // mini = Math.min(mini, (7 - digit + 9 ) % 9 ); 
                if((7 - digit + 9 ) % 9 == k || digit == 7){
                    mini = Math.min(mini , k);
                }
                newN /= 10 ; 
            }
            min = Math.min(mini , min);
            k++;
        }
        System.out.println(min);
    }
}
