package MathConcepts;
import java.util.Arrays ;
public class SeiveOfEratothenes {
    public static void seive (int n){
        //i need too tell the number of prime number from 1 to n 
        //i have an array 
        if(n == 0) return ; 
        boolean[] arr = new boolean[n+1];
        //by default marked as false 
        //we mark it as true 
        Arrays.fill(arr , true);
        //now we traverse 
        //as we know 0 and 1 are not prime 
        arr[0] = false ; 
        arr[1] = false ; 
        //2 is a prime we mark all multiples of 2 as false 
        // for(int i = 2 ; i <= Math.sqrt(n) ; i++){
        for(int i = 2 ; i*i <= n ; i++){
            if(arr[i] == true){
                //i mark all multiples of it as false 
                // arr[i] = true ; 
                // if(2*i <= n){
                    for(int j = i*i ; j <= n ; j += i){
                        if(j%i == 0){
                            arr[j] = false ;
                        }
                    }
                // }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i <= n ; i++)
            if(arr[i] == true)
                sb.append(i+" ");

        System.out.println(sb.toString()) ; 
    }
    // public static boolean isPrime(int n){
    //     for(int i = 2 ; i <= (int)Math.sqrt(n) ; i++){
    //         if(n%i == 0) return false ;
    //     }
    //     return true ; 
    // }
    public static void main(String args[]){
        seive((int)1e5);
        // seive(1);
    }
}
