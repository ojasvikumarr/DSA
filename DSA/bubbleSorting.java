//import java.util.*;
public class bubbleSorting {
    public static void bubblesort(int arr[]){
        for ( int turn = 0 ; turn < arr.length-1 ; turn ++){
            for ( int i = 0 ; i <arr.length-1-turn ; i++ ){
                if (arr[i]>arr[i-1]){
                    //swap
                    int temp = arr[i];
                    arr[i]=arr[i-i];
                    arr[i=1]=temp;
                }
            }
        } 
        //return bubblesort;
    }

    public static void printarr( int arr[] ){
        for ( int i= 0 ; i< arr.length ; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println( );
    } 
    public static void main ( String args[] ){
        int numbers[ ] = {5,2,4,1,3};
        bubblesort(numbers);
        printarr(numbers);
        //System.out.println("Your bubble sorted array is : "+printarr(numbers));  
    //    bubblesort(numbers);
    //System.out.println("Your bubble sorted array is : "+ bubblesort(numbers));
}//bubblesort only rearranged the elements in the array so we need to print the array in another function or can be don in the same functioon
}