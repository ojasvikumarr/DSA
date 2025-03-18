package FenwickTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountInversionQUery {
    class Solution {
    int[] bit ; 
    int n ;
    List<Integer> res ;
    public void update(int idx , int val){
        idx++ ; 
        for(int i = idx ; i <= n ; i += (i&-i)){
            bit[i] += val ; 
        }
    }
    public int sum(int idx){
        idx++ ; 
        int sum = 0 ; 
        for(int i = idx ; i > 0 ; i -= (i&-i)){
            sum += bit[i] ; 
        }
        return sum ; 
    }
    public void inversionCount(int[] nums){
        n = nums.length ;
        bit = new int[n+1];
        // int invCount = 0 ; 
        //we should compress the array 
        Map<Integer,  Integer> ranks = new HashMap<>();

        int[] sorted = Arrays.copyOf(nums , n);
        Arrays.sort(sorted);
        for(int i = 0 ; i < n ; i++){
            ranks.put(sorted[i] , i+1);
        }
        //We go from right to left 
        for(int i = n-1 ; i >= 0 ; i--){
            int idx = ranks.get(nums[i]); 
            // invCount += sum(idx);
            //add the iv count to ans 
            res.add(sum(idx-1));
            //mark the element as proessed 
            update(idx , 1);
        }
        // return invCount; 
    }
    public List<Integer> countSmaller(int[] nums) {
        res = new ArrayList<>();
        //We'll be using fenwick tree to solve this problem
        //lets create one first 
        inversionCount(nums);
        Collections.reverse(res);
        return res ; 
    }
}
}
