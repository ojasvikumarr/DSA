package AtCoders;
import java.util.* ; 

public class Finest {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] p = new int[n];
        for(int i = 0 ; i < n ; i++) p[i] = sc.nextInt();
        solve(p , n);
        sc.close();
    }   
    public static void solve(int[] p , int n){
        int result[] = new int[n];
        for(int i = n-1 ; i >= 0 ; i--){
            int counter = 0 ; 
            int j = 0 ; 
            while(j < n){
                if(result[j] == 0) counter++ ; 
                if(counter == p[i]) break;
                j++ ; 
            }
            result[j] = i+1 ;
        }
        for(int i = 0 ; i < n ; i++){
            System.out.print(result[i]+ " ") ; 
        }
        System.out.println();
    } 
}
