package LeetCode;

import java.util.Arrays;

public class Day131 {
    class Solution {
    int[][] memo ; 
    public int punishmentNumber(int n) {
        int result = 0 ; 
        for(int i = 1 ; i <= n ; i++){
            int sq = i*i ; 

            // System.out.println();
            String str = String.valueOf(sq);
            int len = str.length();
            memo = new int[len+1][i+1];
            for(int[] row : memo) Arrays.fill(row , -1);


            if(check(str , 0 , i)){
                // System.out.println(sq);
                result += sq ; 
            }
        }
        return result ; 
    }
    public boolean check(String sq , int idx , int num){
        if(idx == sq.length()){
            return num == 0 ; 
        }
        if(memo[idx][num] != -1) return (memo[idx][num] == 0 ? false : true) ;
        int val = 0 ; 
        for(int j = idx ; j < sq.length() ; j++){
            val = val*10 + (sq.charAt(j) - '0');
            if(val > num ) break ; 
            if(check(sq , j+1 , num - val)){
                memo[idx][num] = 1 ; 
                return true ; 
            }
        }
        memo[idx][num] = 0 ; 
        return false ; 
    }
    public boolean check(String sq, int idx , int prev , int num ){
        if(idx == sq.length()){
            if(num == 0){
                return true ; 
            }else{
                return false ;
            }
        }

        //pick
        boolean pick = false ; 
        int val = Integer.valueOf(sq.substring(prev , idx+1)) ; 
        System.out.print(val + " ");
        if(val <= num){
            pick = check(sq , idx+1 , idx+1 , num - val);
        }
        //notpick 
        boolean notpick = check(sq , idx+1 , prev , num) ; 
        return pick|| notpick ; 
    }
}
}
