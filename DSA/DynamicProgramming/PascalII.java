package DynamicProgramming;

import java.util.ArrayList;
import java.util.List;

public class PascalII {
    class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        for(int col = 0 ; col <= rowIndex ; col++){
            res.add(binoCoeff(rowIndex , col));
        }
        return res ;
    }
    public int binoCoeff(int r, int c){
        int ans = 1 ;
        c = Math.min(c , r - c);

        for(int i = 0 ; i < c ; i++){
            ans = (int)((long)ans * (r - i) / (i + 1)); 
        }
        return ans ;
    }
}
}
