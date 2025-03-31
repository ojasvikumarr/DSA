package LeetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Day178 {
    class Solution {
    long[][][] dp1 ;
    long[][][] dp2 ;
    Map<String , Long> map1 ;
    Map<String , Long> map2 ;
    public long putMarbles(int[] arr, int k) {
        int n = arr.length ; 
        if(k == n) return 0 ; 
        int[] pairs = new int[n-1];
        for(int i = 0 ; i < n-1 ; i++){
            pairs[i] = arr[i] + arr[i+1];
        }
        Arrays.sort(pairs);
        long minSum = 0 ; 
        long maxSum = 0 ; 
        for(int i = 0 ; i < k-1 ; i++){
            minSum += pairs[i];
            maxSum += pairs[n-i-2];
        }
        return maxSum - minSum ; 
    }
    public long putMarblesI(int[] weights, int k) {
        // i have options , 
        // either i take the sam eindex twice , or take another onw
        // but to remember that the next section starts just after the first ends 
        int n = weights.length ; 
        // dp1 = new long[n][2][k+1];
        // dp2 = new long[n][2][k+1];
        // for(long[][] mat : dp1){
        //     for(long[] row : mat) Arrays.fill(row , -1);
        // }
        // for(long[][] mat : dp2){
        //     for(long[] row : mat) Arrays.fill(row , -1);
        // }
        map1 = new HashMap<>();
        map2 = new HashMap<>();
        if(k == n){
            return 0 ;
        }
        long min = weights[n-1] + mini(weights , n-1 , 1 , k);
        long max = weights[n-1] + maxi(weights , n-1 , 1 , k);
        return max-min ;
    }
    public long mini(int[] arr , int idx , int toggle , int k ){
        //base case ?
        if(k == 0){
            if(idx != -1){
                return (int)1e8 ;
            }else{
                return 0 ; 
            }
        }
        if(idx < 0){
            if(k == 0){
                return 0 ; 
            }else{
                return (int)1e8 ; 
            }
        }
        // if(dp1[idx][toggle][k] != -1){
        //     return dp1[idx][toggle][k];
        // }
        String key = idx + " " + toggle + " " + k ; 
        if(map1.containsKey(key)){
            return map1.get(key);
        }
        //two options 
        //either i pic or notpick 
        //if it is the first time pick fo rth esection 
        long pick = Integer.MAX_VALUE ;
        long notpick = Integer.MAX_VALUE ; 
        if(toggle == 0){
            pick = arr[idx] + mini(arr , idx , 1 , k );
            
        }else if (toggle == 1){
            
            notpick = mini(arr , idx-1 , 1 , k) ;
            if(k > 0 && idx > 0){
                //more sections are there the i need to start the section 
                //just after i ended the prev 
                pick = arr[idx] + arr[idx-1] + mini(arr , idx-1 , 1 , k-1);//idx+1 as i can again pick 
                //the same to end the section
            }else{
                //end of the section
                pick = arr[idx] + mini(arr , idx-1 , 0 , k-1);
            }
        }
        long res = Math.min(pick , notpick); 
        map1.put(key , res);
        return  res ;
    }
    public long maxi(int[] arr , int idx , int toggle , int k ){
        //base case ?
        if(k == 0){
            if(idx != -1){
                return -(int)1e8 ;
            }else{
                return 0 ; 
            }
        }
        if(idx < 0){
            if(k == 0){
                return 0 ; 
            }else{
                return -(int)1e8 ; 
            }
        }
        // if(dp2[idx][toggle][k] != -1){
        //     return dp2[idx][toggle][k];
        // }
        String key = idx + " " + toggle + " " + k ; 
        if(map2.containsKey(key)){
            return map2.get(key);
        }
        //two options 
        //either i pic or notpick 
        //if it is the first time pick fo rth esection 
        long pick = Integer.MIN_VALUE ;
        long notpick = Integer.MIN_VALUE ; 
        if(toggle == 0){
            pick = arr[idx] + maxi(arr , idx , 1 , k );
            
        }else if (toggle == 1){
            
            notpick = maxi(arr , idx-1 , 1 , k) ;
            if(k > 0 && idx > 0){
                //more sections are there the i need to start the section 
                //just after i ended the prev 
                pick = arr[idx] + arr[idx-1] + maxi(arr , idx-1 , 1 , k-1);//idx+1 as i can again pick 
                //the same to end the section
            }else{
                //end of the section
                pick = arr[idx] + maxi(arr , idx-1 , 0 , k-1);
            }
        }
        long res = Math.max(pick , notpick); 
        map2.put(key , res);
        return  res ;
    }
}
}
