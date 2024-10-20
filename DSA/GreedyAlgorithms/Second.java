package GreedyAlgorithms;
import java.util.* ;
public class Second {
    public static void main(String args[]){
        int val[] = {60, 100, 120};
        int weight[] = {10,20,30};
        int w = 50 ;

        double ratio[][] = new double[val.length][2];
        //0th column pe index ko store karengay 
        //1st column pe items ki ratio 
        for(int i = 0 ; i<val.length ; i++){
            ratio[i][0] = i ;
            ratio[i][1] = val[i]/(double)weight[i];
        }

        Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1]));
        //sorted in ascending order thus we ran the loop in reverse order voila!
int capacity = w ;
int finval = 0 ;
        for( int i = ratio.length -1 ; i >= 0 ; i-- ){
            int idx = (int)ratio[i][0];
            if(capacity >= weight[idx]){
                finval += val[idx];
                capacity -= weight[idx];
            }else{
                finval += (ratio[i][i] * capacity);
                capacity = 0 ; 
                break ;
            }
        }
        System.out.println("final val = " + finval);
    }
}
