package DynamicProgramming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CanIWin {
    class Solution {
    Map<Integer, Boolean> mapp;
    boolean[] used;
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        int sum = (1+maxChoosableInteger)*maxChoosableInteger/2;
        if(sum < desiredTotal) return false;
        if(desiredTotal <= 0) return true;
        
        mapp = new HashMap();
        used = new boolean[maxChoosableInteger+1];
        return helper(desiredTotal);
    }
    
    public boolean helper(int desiredTotal){
        if(desiredTotal <= 0) return false;
        int key = format(used);
        if(!mapp.containsKey(key)){
            for(int i=1; i<used.length; i++){
                if(!used[i]){
                    used[i] = true;
                    if(!helper(desiredTotal-i)){
                        mapp.put(key, true);
                        used[i] = false;
                        return true;
                    }
                    used[i] = false;
                }
            }
            mapp.put(key, false);
        }
        return mapp.get(key);
    }
   
    public int format(boolean[] used){
        int num = 0;
        for(boolean b: used){
            num <<= 1;
            if(b) num |= 1;
        }
        return num;
    }




    //-------------------TOP DOWN APPROACH------------------//
    Map<String , Boolean> map ;
    public boolean canIWinII(int maxChoosableInteger, int desiredTotal) {
        //Player A makes the Bold move 
        if(desiredTotal <= maxChoosableInteger){
            return true ; 
        }
        //IF the total sum is less than the desired total we return false
        if(((1+maxChoosableInteger) / 2*maxChoosableInteger) < desiredTotal){
            return false ;
        }
        map = new HashMap<>();
        return solve(maxChoosableInteger , desiredTotal , new boolean[maxChoosableInteger+1]);
    }
    public boolean solve(int range , int total , boolean[] chosen){
        if(total <= 0) return false ;

        String key = Arrays.toString(chosen);

        if(map.containsKey(key)){
            return map.get(key);
        }
        for(int i = 1 ; i <= range ; i++){
            if(chosen[i]) continue ;
            chosen[i] = true ;
            if(!solve(range, total-i, chosen)){
                // map.put(key , true);
                chosen[i] = false ;
                return true ; 
            }
            chosen[i] = false ;
        }
        // map.put(key , false);
        return false ;
    }
}
}
