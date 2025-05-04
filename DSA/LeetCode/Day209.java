package LeetCode;

import java.util.HashMap;
public class Day209 {
    class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        int res = 0 ; 
        int[] val = new int[100];
        for(int[] ele : dominoes){
            int idx = ele[0] < ele[1] ? ele[1]*10 + ele[0]: ele[0]*10 + ele[1];
            res += val[idx];
            val[idx]++ ;
        }
        return res ;
    }
    public int numEquivDominoPairsII(int[][] dominoes) {

        HashMap<String , Integer> freq = new HashMap<>();
        int res = 0 ; 
        for(int[] ele : dominoes){
            String key = ele[0] + " " + ele[1];
            String keyy = ele[1] + " " + ele[0];
            if(freq.containsKey(key)){
                res += freq.get(key);
                System.out.println(res);
                if(key.equals(keyy)){
                    freq.put(key , freq.get(key)+1); 
                }else{
                    freq.put(key , freq.get(key)+1); 
                    freq.put(keyy , freq.get(keyy)+1); 
                }
            }else{
                if(key.equals(keyy)){
                    freq.put(key , 1);
                }else{
                    freq.put(key , 1);
                    freq.put(keyy , 1);
                }
            }
        }
        return res ; 
    }
}
}
