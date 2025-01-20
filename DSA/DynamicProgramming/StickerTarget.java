package DynamicProgramming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class StickerTarget {
    class Solution {
    public int minStickers(String[] stickers, String target) {
        int n = stickers.length;
        int[][] stickerFreq = new int[n][26];
        
        for (int i = 0; i < n; i++) {
            for (char c : stickers[i].toCharArray()) {
                stickerFreq[i][c - 'a']++;
            }
        }
        
        Map<String, Integer> memo = new HashMap<>();
        memo.put("", 0); // Base case: empty target requires 0 stickers
        
        int result = solveIII(stickerFreq, target, memo);
        return result == Integer.MAX_VALUE / 2 ? -1 : result;
    }
    public int solveIII(int[][] stickers , String target , Map<String , Integer> memo){
        if(memo.containsKey(target)){
            return memo.get(target);
        }

        int[] targetFreq = new int[26];
        for(char c : target.toCharArray()){
            targetFreq[c-'a']++ ;
        }
        int mini = Integer.MAX_VALUE/2 ; 
        for(int[] sticker : stickers){
            if(sticker[target.charAt(0) - 'a'] == 0){
                continue ; 
            }
            StringBuilder sb = new StringBuilder();
            for(int i = 0 ; i < 26 ; i++){
                int remaining = targetFreq[i] - sticker[i];
                for(int j = 0 ; j < Math.max(0 , remaining) ; j++){
                    sb.append((char)(i+'a'));
                }
            }

            mini = Math.min(mini, 1 + solveIII(stickers , sb.toString() , memo));
        }
        memo.put(target, mini);
        return memo.get(target);
    }
    public int solveII(int[][] stickers, String target, Map<String, Integer> memo) {
        if (memo.containsKey(target)) {
            return memo.get(target);
        }

        int[] targetFreq = new int[26];
        for (char c : target.toCharArray()) {
            targetFreq[c - 'a']++;
        }

        int minStickers = Integer.MAX_VALUE / 2;
        for (int[] sticker : stickers) {
            // Skip stickers that don't contribute to the first character of the target
            if (sticker[target.charAt(0) - 'a'] == 0) {
                continue;
            }

            // Create the new target after using the sticker
            StringBuilder newTarget = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                int remaining = targetFreq[i] - sticker[i];
                for (int j = 0; j < Math.max(0, remaining); j++) {
                    newTarget.append((char) (i + 'a'));
                }
            }

            minStickers = Math.min(minStickers, 1 + solveII(stickers, newTarget.toString(), memo));
        }

        memo.put(target, minStickers);
        return minStickers;
    }


    //==================================This is a brute force as we are trying out all possible 
    // ================== options even if the stickers are not contributing m^n 
    // ===================== cant be optimised
    public int minStickersII(String[] stickers, String target) {
        int[] freq = new int[26];
        for(char c : target.toCharArray()){
            int idx = c - 'a';
            freq[idx]++ ;
        }
        int result = solve(freq , stickers , 0) ;
        return ( result == Integer.MAX_VALUE/2 ? -1 : result);
    }
    public int solve(int[] freqTarget , String[] stickers , int idx){
        if(checkEmpty(freqTarget) == true){
            return 0 ;
        }
        if( idx == stickers.length ){
            if(checkEmpty(freqTarget) == false){
                return Integer.MAX_VALUE/2;
            }
            return 0 ; 
        }
        int[] affectFreq = Arrays.copyOf(freqTarget , freqTarget.length);
        //We need to decrease the freq 
        for(char c : stickers[idx].toCharArray()){
            int cIdx = c - 'a';
            if(affectFreq[cIdx] > 0){
                affectFreq[cIdx]-- ;
            }
        }
        int pick = 1 + solve(affectFreq , stickers , idx);
        int notpick = solve(freqTarget , stickers , idx+1);
        return Math.min(pick , notpick);
    }
    public boolean checkEmpty(int[] arr){
        for(int i = 0 ; i < 26 ; i++){
            if(arr[i] > 0) return true ;
        }
        return false ;
    }
}
}
