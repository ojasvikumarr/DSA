public class ModifiedBubbleSort {
    public static void ModBubbleSort(int arr[]){
        for(int i = 0 ; i < arr.length-1 ; i++){
            boolean swapped = false;
            for(int j = 0 ; j < arr.length - i ; j++){
                if(arr[j] > arr[j+1]){
                    //swap
                    int temp = arr[j] ;
                    arr[j] = arr[j+1] ;
                    arr[j+1] = temp ;
                    swapped = true;
                }
            }
            if (swapped == true){
                break;
            }
        }
    }
    public static void main(String args[]){
        int arr[] = {2,4,1,3,6,5,8,7,0};
        ModBubbleSort(arr);
    }
}


//best case will have O(n)
//worst will be O(n^2)