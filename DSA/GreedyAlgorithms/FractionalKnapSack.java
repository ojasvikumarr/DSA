package GreedyAlgorithms;
import java.util.*;
public class FractionalKnapSack {
    public static void main(String args[]){
        int value[] = {60,100,120};
        int weight[] = {10,20,30};
        int w = 50 ;
        double ratio[][] = new double[value.length][2];
        for(int i = 0 ; i < value.length ; i++ ){
            ratio[i][0] = i ;
            ratio[i][1] = (value[i]/(double)weight[i]);
        }

        Arrays.sort(ratio , Comparator.comparingDouble(o -> o[1]));

        int capacity = w; 
        int finalVal = 0 ;
        //as it was in ascending order thus we will start the loop in the opposite manner 
        for ( int i = value.length- 1 ; i >= 0 ; i-- ){
            int idx = (int)ratio[i][0];//because the loop is starting from last thus had to have the index value 
            if( capacity >= weight[idx] ){
                finalVal += value[idx];
                capacity -= weight[idx];
            }
            else{
                finalVal+= (ratio[i][1]*capacity);
                capacity = 0 ;
                break ;
            }
        }
        System.out.println(finalVal);
    }
}
