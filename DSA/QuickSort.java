public class QuickSort {
    public static void printArr( int arr[] ){
        for ( int i = 0 ; i <=arr.length-1 ;i++){
            System.out.print(arr[i]+" ");
        }
        return;
    }
    public static void main ( String args[]){
        int arr[]= {2,5,3,6,8 };
        quickSort(arr, 0, arr.length - 1);
        printArr(arr);
    }

    public static void quickSort( int arr[] , int si , int ei ){
        if ( si>= ei){
            return ;
        }
        //last element 
        int pIdx = partition(arr, si, ei);
        quickSort(arr, si, pIdx - 1);
        quickSort(arr, pIdx + 1, ei);
    }

    public static int partition ( int arr[] , int si , int ei ){
        int pivot = ei ;
        int i = si - 1; //to make place for the elements smaller than pivot
         for (int j = si ; j<ei ; j++ ){
            if(arr[j] <= pivot){
                i++;
                //swap
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp ;
            }
         }
         // ab pivot ko sahi jagah dalne hai 
         i++;
         int temp = pivot ;
         arr[ei] = arr[i] ;
         arr[i] = temp ;
         return i ;
    }
}
