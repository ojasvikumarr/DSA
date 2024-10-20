package GreedyAlgorithms;
import java.util.*;
public class MaxLengthChainPairs {
    
    public  static void main(String args[]){
        int pairs [][] = {{5, 24}, {39, 60}, {5, 28}, {27, 40}, {50, 90}};
        Arrays.sort(pairs , Comparator.comparingDouble(o -> o[1]));
        int length = 1 ;//because one will be always there
        int pairEnd = pairs[0][1];
        for(int i = 0 ; i < pairs.length ; i ++ ){
            if(pairs[i][0] > pairEnd){
                length++ ;
                pairEnd= pairs[i][1];
            }
        }
        System.out.println("Maximum lenght will be : "+ length );
    }
}