package Graphs;

import java.util.HashMap;

public class CoupleHoldingHands {
    class Solution {
    private HashMap<Integer, Integer> map ; 
    public int minSwapsCouples(int[] row) {
        map = new HashMap<>();
        for(int i = 0 ; i < row.length ; i++){
            map.put(row[i] , i);
        }
        int swaps = 0 ; 
        for(int i = 0 ; i < row.length ; i += 2){
            int first = row[i];
            // int second = row[i] + (row[i] % 2 == 0 ? 1 : -1);
            int second = first^1 ;
            if(row[i+1] != second){
                swaps++ ;
                Swap(row , i+1 , map.get(second));
            }
        }
        return swaps ;
    }
    private void Swap(int[] row , int i , int j){
        int temp = row[i];
        row[i] = row[j];
        row[j] = temp ; 
        map.put(row[i] , i);
        map.put(row[j] , j);
    }
}
}
