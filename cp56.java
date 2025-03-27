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
            int[] query = new int[q];
            for(int i = 0 ; i < q ; i++){
                query[i] = sc.nextInt();
            }

            int k = 0 ; 
            for(int i : query){
                if(k % (1 << i) == 0){
                    k |= 1 << (i - 1);
                }
            }

            for(int i = 0 ; i < n ; i++){
                int j =arr[i]&-arr[i];
                arr[i] |= k & (j-1);
            }

            for(int num : arr){
                System.out.print(num + " ");
            }
            // int limit = -1; 
            // long lastbit = Integer.MIN_VALUE ; 
            // for(int i =0 ; i < n ; i++){
            //     lastbit = Math.max(lastbit ,((arr[i]&-arr[i])));
            // }

            // for(int i = 0 ; i < q ; i++){
            //     int x = query[i];
            //      // System.out.println(lastbit);
            //     // System.out.print((1<<(x)) + " ");
            //     if((x) <= lastbit){
            //         for(int j = 0 ; j < n; j++){
            //             if((arr[j] % (1<<(x))) == 0){
            //                 arr[j] += (1<<(x-1)) ;
            //                 // limit = x-1 ; 
            //                 lastbit = ((x-1));
            //             }
            //         }
            //         // System.out.println("Limit" + limit);
            //     }
            // }
            // for(int i = 0 ; i < n; i++){
            //     System.out.print(arr[i] + " ");
            // }
            System.out.println();
        }
        sc.close();
    }
    
}
