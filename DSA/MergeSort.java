public class MergeSort{
    public static void Printarr( int arr[]){
        for ( int i = 0 ;i <= arr.length-1 ; i++){
            System.out.print(arr[i]+" ");
        }
        return;
    }
    public static void mergeSort(int arr[], int si, int ei){
        if( si >= ei ){
            return;
        }
        //kaam
        int mid = si + (ei - si)/2; // (si+ ei)/2
        mergeSort(arr, si, mid);
        mergeSort(arr, mid + 1, ei);
        merge(arr, si, mid, ei);
    }
    public static void merge(int arr[] , int si , int mid , int ei){
            //left(0,3) = 4 right(4,6) = 3  .... 6-0+1
        int temp[] = new int [ ei-si+1 ];
        int i = si ;//ITERATOR for left part
        int j = mid+1;//iterator for right part
        int k = 0;//iterator for temp array
        while(i <= mid && j <=ei){
            if(arr[i] < arr[j]){
                temp[k] = arr[i];
                i++  ;
            }
            else{
                temp[k] = arr[j];
                 j++ ; 
            }
            k++ ;
        } 
        //now we have to sort the remaining elements like if the lenght of the array is odd then there eiter be more elements 
        //towards right or left so to sort then also we code this

        while ( i <= mid ){//extra left part
            temp[k++] = arr[i++];
        }
        while (j <= ei) {//extra right part if leftt
            temp[k++] = arr[j++];
        }
        //copy temp arr to original arr
        for(k = 0,  i =si ; k<temp.length ; k++ ,i ++ ){
            arr[i] = temp[k] ;
        }
    }
    public static void main ( String args[]){
        int arr[] = {2,5,3,1,8,7,9};
        mergeSort(arr, 0, arr.length-1);
        Printarr(arr);
    }
}