package FenwickTree;
import java.util.*  ;
public class InversionCount {
    static int[] bit ; 
    static int n ; 
    public static void init(int[] arr){
        n = arr.length ; 
        bit = new int[n+1];
        for(int i = 0 ; i < n ; i++){
            update(arr[i] , i);
        }
    }
    public static void update(int val , int idx){
        idx++ ; 
        for(int i = idx ; i <= n ; i += (i&-i)){
            bit[i] += val ; 
        }
    }
    public static long sum(int idx){
        idx++ ; 
        long sum = 0 ; 
        for(int i = idx ; i >= 0 ; i -= (i&-i)){
            sum += bit[i];
        }
        return sum ; 
    }
    public static long rangeSum(int l , int r){
        return sum(r) - sum(l-1);
    }
    public static int countInversions(int[] arr){
        //we need to compress the array to 1 indexed array 
        n = arr.length ; 
        int[] sorted = Arrays.copyOf(arr , n);
        Map<Integer , Integer> rank = new HashMap<>() ;
        for(int i = 0 ; i < n ; i++){
            rank.put(sorted[i] , i+1);
        }
        bit = new int[n+1];
        int invCount = 0 ;
        for(int i = n - 1 ; i >= 0 ; i--){
            int idx = rank.get(arr[i]);
            invCount += sum(idx-1);
            update(idx , 1);
        } 
        System.out.println("Hello");
        return invCount ; 
    }
    public static void main(String arg[]){
        int[] arr = {8 , 4 , 9 , 2 };
        System.out.println("Inversion count : "+ countInversions(arr));
    }
}
