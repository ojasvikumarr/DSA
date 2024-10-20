package BackTracking;
public class BacTracking {
    public static void Printarr(int arr[]){
        for(int i = 0 ; i < arr.length ; i++){
            System.out.print( arr[i] +" ");
        }
        System.out.println();
    }
    public static void Backtracking( int arr[] , int i , int val){
        if( i == arr.length ){
            Printarr(arr);
            return ;
        }

        //kaam
        arr[i] = val ;
        Backtracking(arr, i+1, val+1);  //recursion Step

        arr[i] = arr[i] - 2 ;  //backtracking step
    }
    public static void main (String args[]){
        int arr[] = new int[5] ;
    Backtracking(arr, 0, 1);
    Printarr(arr);
    }
}
