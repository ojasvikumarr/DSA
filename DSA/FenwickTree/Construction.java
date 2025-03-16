package FenwickTree;

public class Construction {
    static int[] bit ; 
    static int n ;
    public static void initFTree(int[] arr){
        n = arr.length ; 
        bit = new int[n+1];
        for(int i = 0 ; i < arr.length ; i++){
            update(i , arr[i]);
        }
    }
    public static void update(int idx , int val){
        idx++ ;//As its is 1 indexed
        for(int i = idx ; i <= n ; i += (i&-i)){
            bit[i] += val ;
        }
    }
    public static int rangeSum(int l , int r){
        return querySum(r) - querySum(l-1);
    }
    public static int querySum(int idx){
        idx++ ;
        int sum = 0 ; 
        for(int i = idx ; i > 0 ; i -= (i&-i)){
            sum += bit[i];
        }
        return sum ; 
    }
    public static void solve(int[] arr){
        initFTree(arr);
        int sum = rangeSum(2 , 4);
        System.out.println(sum);
        return ; 
    }
    public static void main(String[] args){
        int[] arr = {1 , 2 , 3 , 4, 5};
        solve(arr);
    }
}
