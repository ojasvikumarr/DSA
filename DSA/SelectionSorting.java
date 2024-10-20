// import java.util.*;
// import java.util.Arrays;//inbuilt sorting 
// import java.util.Collections;//for arranging in increasig or decreasing order

public class SelectionSorting{
    public static void SelectionSort(int n[]){
        for ( int i= 0 ; i<n.length-1 ; i++){
            int minPos = i ;
            for( int j = i+1 ; j<n.length-1 ; j++){
                if ( n[minPos] > n [j]){
                    minPos = j;
                }
            }
            int temp = n[minPos] ;
            n[minPos] = n[i] ;
            n[i]= temp; 
        }
    }

    public static void InsertionSort ( int n[] ){
        for ( int i= 1 ; i < n.length ;i++ ){
        int curr = n[i];
        int prev = i-1;
        //finding out correct position to insert
        while(prev >= 0 && n[prev] >curr ) {
            n[prev+1]=n[prev];
            prev--;
        } 
        //insertion
        n [ prev +1]= curr;
        }
    }

    public static void CountingSort( int arr[] ){
        int largest = Integer.MIN_VALUE;
        for( int i= 0 ; i < arr.length ; i++){
            largest = Math.max(largest , arr[i]);
        }

        int count[] = new int[largest+1];
        for(int i= 0 ; i<arr.length; i++){
            count[arr[i]]++;
        }

        //sorting
        int j= 0;
        for(int i=0 ; i<count.length ; i++){
            while ( count[i]>0){
                arr[j]=i;
                j++;                
                count[i]--;
            }
        }
    }
    //public static void printSort(Integer n[]){
        public static void printSort(int n[]){
        for( int i = 0 ;i <n.length -1 ; i++){
            System.out.print(n[i]+" ");

        }

        System.out.println();
    }

    public static void main ( String args []){
        //Integer marks [] = {9,2,5,3,4,1,7,8,6};
        int marks [] = {9,2,5,3,4,1,7,8,6};
        int numbers [] = {1,3,3,3,3,1,1,7,4,4,6,4,3,3,4,5,5,1,2};
        //SelectionSort(marks);
        //InsertionSort(marks);
        //Arrays.sort(marks);
        //Arrays.sort(marks,2,7);
        //Arrays.sort(marks,Collections.reverseOrder());
        //Arrays.sort(marks,0,5,Collections.reverseOrder());
        //For reverse order to work it will only work on objects and not on int values so we need to change int --> Integer that will make the aRRAy an object and no an integer value
        CountingSort(marks);
        CountingSort(numbers);
        printSort(marks);
        printSort(numbers);
    }
}