import java.util.* ; 
import java.util.Arrays ; 
public class cp43 {
    
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        long t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            long[] arr = new long[2*n];
            for(int i = 0 ; i < 2*n ; i++) arr[i] = sc.nextInt();
            Arrays.sort(arr);
            ArrayList<Long> ls = new ArrayList<>();
            long diff = 0 ; 
            //we have left first and last element in array
            for(int i = 1 ; i < n ; i++){
                ls.add(arr[i]);
                ls.add(arr[n-1+i]);
                diff += arr[n-1+i] - arr[i];
            }
            ls.add(diff + arr[0] + arr[2*n-1]);
            ls.add(arr[0]);
            System.out.print(arr[2*n-1] + " ");
            for(Long it : ls){
                System.out.print(it + " ");
            }
            System.out.println();
        }
        sc.close();
    }

}
