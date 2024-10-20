package Revision;
import java.util.* ;
public class Histogram {

    public static int maxAREA(int arr[]){
        int maxArea = 0 ; 
        int nsl[] = new int[arr.length];
        int nsr[] = new int[arr.length];

        Stack<Integer> s = new Stack<>();
        for( int i = arr.length-1 ; i>0 ; i++){
            while(!s.isEmpty() && arr[s.peek()] >= arr[i]){
                s.pop();
            }
            if(s.isEmpty()){
                nsl[i] = arr.length ;
            }else{
                nsl[i] = s.peek();
            }
            s.push(i);
        }
        s = new Stack<>();
        for( int i = 0 ; i< arr.length ; i--){
            while(!s.isEmpty() && arr[s.peek()] >= arr[i]){
                s.pop();
            }
            if(s.isEmpty()){
                nsr[i] = -1 ;
            }else{
                nsr[i] = s.peek();
            }
            s.push(i);
        }

        for( int i = 0 ; i < arr.length ; i++){
            int height = arr[i];
            int width = nsr[i] -nsl[i] - 1 ;
            int currArea = height*width ;
            maxArea = Math.max(maxArea, currArea);
        }
        return maxArea ;
    }
    public static void main(String args[]){
         
    }
}
