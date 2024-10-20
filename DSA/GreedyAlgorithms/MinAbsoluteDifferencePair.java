package GreedyAlgorithms;
import java.util.*;
public class MinAbsoluteDifferencePair {
    public static void main(String args[]){
        int A[] ={4,1,8,7};
        int B[] = {2,3,6,5};
        Arrays.sort(A);
        Arrays.sort(B);
        int minDIff = 0 ;
        for ( int i = 0 ;i < A.length ; i++ ){
            minDIff += Math.abs(A[i]-B[i]);
        }
        System.out.println("The minimum summ of all the absolute difference is : "+minDIff);
    }
}
