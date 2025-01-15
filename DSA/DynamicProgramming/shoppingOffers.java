package DynamicProgramming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class shoppingOffers {
    class Solution {
    Map<List<Integer> , Integer> map ;
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        map = new HashMap<>();
        return shopping(price , special , needs);
    }
    public int shopping(List<Integer> price , List<List<Integer>> special , List<Integer> needs){
        int j = 0 ;
        int res = dot(needs , price);
        if(map.containsKey(needs)){
            return map.get(needs);
        }
        for(List<Integer> s : special){
            ArrayList<Integer> clone = new ArrayList<>(needs);
            for(j = 0 ; j < needs.size() ; j++){
                int diff = clone.get(j) - s.get(j);

                if(diff < 0){
                    break ;
                }
                clone.set(j , diff);
            }
            if(j == needs.size()){
                res = Math.min(res , s.get(j) + shopping(price , special , clone));
            }
        }
        map.put(needs , res);
            return res ;
    }
    public int dot(List<Integer> a , List<Integer> b){
        int sum = 0 ; 
        for(int i =0 ; i < a.size() ; i++){
            sum += a.get(i)*b.get(i);
        }
        return sum ; 
    }
}
}
