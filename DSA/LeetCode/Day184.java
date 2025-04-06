package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day184 {
    class Solution {
    List<List<Integer>> res ; 
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        // res = new ArrayList<>();
        // solve(nums , 0 , new ArrayList<>() , -1);
        // Collections.sort(res , (a , b) -> b.size() - a.size());
        // return res.get(0);
        return Tabulation(nums);
    }

    public List<Integer> Tabulation(int[] nums){
        List<List<Integer>> arr = new ArrayList<>();
        int n = nums.length ;
        for(int i = 0 ; i < n ; i++){
            arr.add(new ArrayList<>());
        }
        int global = 0 ; 
        //0 to n-1 in search of largest subsequence 
        for(int i = 0 ; i < n ; i++){
            int maxi = 0 ; 
            int idx = -1 ; 
            for(int j = i-1 ; j >= 0 ; j--){
                if(nums[i]%nums[j] == 0){
                    int sz = arr.get(j).size() ;
                    if(maxi < sz){
                        maxi = Math.max(maxi , sz);
                        idx = j ; 
                    }
                }
            }
            if(idx == -1){
                //no element found but can start a new subs
                arr.get(i).add(nums[i]);
            }else{
                arr.get(i).addAll(arr.get(idx));
                arr.get(i).add(nums[i]);
            }
            global = Math.max(global , arr.get(i).size());
        }
        for(List<Integer> ls : arr){
            if(ls.size() == global){
                return ls ; 
            }
        }
        return new ArrayList<>();
    }
    public void solve(int[] nums , int idx , List<Integer> ls , int first){
        if(idx == nums.length){
            res.add(new ArrayList<>(ls));
            return ; 
        }

        if(first == -1){
            ls.add(nums[idx]);
            solve(nums , idx+1 , ls ,nums[idx]);
            //skip it 
            if(!ls.isEmpty()){
                ls.remove(ls.size()-1);
            }
        }else if((nums[idx] % first) == 0){
            //pick 
            ls.add(nums[idx]);
            solve(nums , idx+1 , ls , nums[idx]);
            //skip it 
            if(!ls.isEmpty()){
                ls.remove(ls.size()-1);
            }
        }
        
        solve(nums , idx+1 , ls , first);
    }
}
}
