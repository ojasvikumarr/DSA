import java.util.Scanner;

public class cp29 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            long n = sc.nextInt();
            solveII(n);
        }
        sc.close() ; 
    }
    public static void solveIII(long n){
        int k = 0 ; 
        long mini = Integer.MAX_VALUE ; 
        while(k <= 9){
            long newN = n - k ; 
            long min = 0; 
            while(newN > 0){
                long digit = newN % 10 ; 
                if(digit <= 7){
                    min = Math.max(min , digit);
                }
                newN /= 10 ; 
            }
            if(k >= 7 - min){
                System.out.println(k);
                return; 
            }
            mini = Math.min(mini , min);
            k++ ; 
        }
        System.out.println(mini);
    }
    public static void solveII(long n){
        int k = 0 ; 
        long mini = Integer.MAX_VALUE ; 
        while(k <= 9){
            long newN = n - k ; 
            long min = Integer.MAX_VALUE ; 
            while(newN > 0){
                long digit = newN % 10 ; 
                if(digit + k == 7 || digit == 7){
                    min = Math.min(min , k);
                }
                newN /= 10 ; 
            }
            if(min != Integer.MAX_VALUE){
                System.out.println(min);
                return ; 
            }
            mini = Math.min(mini , min);
            k++ ; 
        }
        System.out.println(mini);
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
