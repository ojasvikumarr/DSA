package DynamicProgramming;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SpecialSubSeq {
    class Solution {
    long answer = 0 ; 
    Map<String , Integer> dp ;
    public long numberOfSubsequences(int[] nums) {
        int n = nums.length ; 
       long result = 0; 
        Map<String , Integer> map = new HashMap<>();
        for(int r = 4 ; r < n-2 ; r++){
            int q = r-2 ; // Making q stick with r 
            for(int p = 0 ; p <= q-2 ; p++){
                int gcd = GCD(nums[p] , nums[q]);
                String key = (nums[p]/gcd) + " " + (nums[q]/gcd);
                map.put(key , map.getOrDefault(key , 0)+1);
            }
            for(int s = r+2 ; s < n ; s++){
                int gcd = GCD(nums[s] , nums[r]);
                String key = (nums[s]/gcd) + " " + (nums[r]/gcd);
                result += map.getOrDefault(key , 0);
            }
        }
        return result ;
    }
    public int GCD(int p , int q){
        while(q != 0){
            int temp = q ; 
            q = p%q ; 
            p = temp ;
        }
        return p ; 
    }
    public int solve(int[] nums , int idx , List<Integer> ls , int count){
        if(idx >= nums.length){
            if(count == 0){
                int p = ls.get(0);
                int q = ls.get(1);
                int r = ls.get(2);
                int s = ls.get(3);
                if(p*r == q*s) return 1 ;
            }
            return 0;
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append(String.valueOf(idx));
        sb.append(" ");
        for(Integer it : ls) {
            sb.append(String.valueOf(it)) ;
            sb.append(" ");
        }
        String key = sb.toString();
        
        if(dp.containsKey(key)) return dp.get(key);
        int pick = 0 ;
        if(count > 0){
            ls.add(nums[idx]);
            pick = solve(nums , idx+2 , ls , count-1);
            ls.remove(ls.size()-1);
        }
        int notpick = solve(nums , idx+1 , ls , count);
        dp.put(key , pick + notpick);
        return pick + notpick ; 
    }
}
}
