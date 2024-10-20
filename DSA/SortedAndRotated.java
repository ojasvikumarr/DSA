

public class SortedAndRotated {
//using loop
    public static void Search( int arr[] , int tar ){
        
        for ( int i =  0 ; i <= arr.length-1 ; i++){
            if( arr[i] == tar){
                System.out.print(i);
                return ;
            }
        }  
    }
//using sorting and recursion  DIVIDE AND CONQUER
    public static int SortedandRotated(int arr[] , int tar , int si , int ei){
        if( si > ei){
            return -1 ;
        }
        //kaam
        int mid = si + (ei-si)/2 ;
        if(arr[mid] == tar){
            return mid ;
        }
//left wali line L1
        if(arr[si] <= arr[mid] ){
    //case A : left 
            if(arr[si] <=tar && arr[mid] >= tar){
                return SortedandRotated(arr, tar, si, mid - 1);
            }
    //case B : right
            else{
                return SortedandRotated(arr, tar, mid+1, ei);
            }
        }
//on mid L2
        else{
    //case C : right
            if(arr[mid]<=tar && tar <= arr[ei]){
                return SortedandRotated(arr, tar, mid+1, ei);
            }
    //case D : Left
            else{
                return SortedandRotated(arr, tar, si, mid-1);
            }
        }
    }
    public static void main(String args[]){
        int arr[] = {4,5,6,7,0,1,2};
        int target = 4 ; //output ->2
        int tarIndx = SortedandRotated(arr, target, 0, arr.length-1);
        System.out.println(tarIndx);
        Search(arr, target);
    }
}