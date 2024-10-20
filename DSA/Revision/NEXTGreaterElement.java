package Revision;
import java.util.*;
public class NEXTGreaterElement {
    public static void main(String args[]){
        int arr[] = {6 , 8, 0 , 1 , 3};
        Stack<Integer> s = new Stack<>();
        int nxtGreater[] = new int[arr.length];

        for( int i = arr.length ; i >= 0 ; i--){

            while(!s.isEmpty() && arr[s.peek()] <= arr[i] ){
                s.pop();
            }
            if(s.isEmpty()){
                nxtGreater[i] = -1 ;
            }
            else{
                nxtGreater[i] = arr[s.peek()];
            }

            s.push(i);
        }
        for( int i = 0 ; i<nxtGreater.length ; i++){
            System.out.println(nxtGreater[i] + " ");
        }
    }
}   

