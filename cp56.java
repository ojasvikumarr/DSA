import java.util.* ; 
import java.util.Arrays ;
public class cp56 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            int q = sc.nextInt();
            int[] arr = new int[n];
            for(int i = 0 ; i < n; i++) arr[i] = sc.nextInt();
            for(int i = 0 ; i < q ; i++){
                int x = sc.nextInt();
                // System.out.print((1<<(x)) + " ");
                for(int j = 0 ; j < n; j++){
                    if((arr[j] % (1<<(x))) == 0){
                        arr[j] += (1<<(x-1)) ;
                    }
                }
            }
            for(int i = 0 ; i < n; i++){
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
        sc.close();
    }
    
}
