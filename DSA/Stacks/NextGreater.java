package Stacks;
import java.util.*;
public class NextGreater {
    public static void main( String args[] ){
        int arr[] = {6,8,1,0,1,3};
        Stack <Integer> s = new Stack<>();
        int nxtGreater[] = new int[arr.length];
        for( int i= arr.length-1 ; i>=0 ; i--){
            //while 
            while( !s.isEmpty() && arr[s.peek()]<= arr[i]){
                s.pop();
            }
            if(!s.isEmpty()){
                nxtGreater[i] = -1;
            }
            else{
                nxtGreater[i] = arr[s.peek()];
            }
            s.push(i);
        }
        for( int j = 0 ; j<nxtGreater.length ; j++ ){
            System.out.print( nxtGreater[j]+" ");
        }
        System.out.println();
    }
}
//next smaller right 
//next greater right 
//next smaller left
//next greater left
//these all can be made just by variation in the loop