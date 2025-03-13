package DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ThreeSum {
    class Solution {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length ; 
        
        for(int i = 0 ; i < n ; i++){
            if(i > 0 && nums[i] == nums[i-1]) continue ;
            int j = i+1 ; 
            int k = n-1 ;   
            while(j < k){
                int diff = nums[i] + nums[j] + nums[k];
                if(diff < 0){
                    j++ ; 
                }else if(diff > 0){
                    k-- ; 
                }else{
                    res.add(new ArrayList<>(Arrays.asList(nums[i] , nums[j] , nums[k])));
                    j++ ; 
                    while(nums[j] == nums[j-1] && j < k) j++ ; 
                }
            }
        }
        return res ; 
    }
    public List<List<Integer>> threeSumIII(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length ; 
        int i = 0 ;
        int j = i+1 ; 
        int k = n-1 ;
        while(i < k){
            
            int diff = nums[i] + nums[j] + nums[k];
            if(diff == 0){
                res.add(new ArrayList<>(Arrays.asList(nums[i] , nums[j] , nums[k])));
                // int prev = nums[i];
                // while(prev == nums[i] && i < k) i++ ; 
                j++ ; 
            }else if(diff < 0){
                //we need to increase the neg part 
                while(diff < 0 && j < k){
                    j++ ; 
                    diff = nums[i] + nums[j] + nums[k];
                }
                if(diff == 0){
                    res.add(new ArrayList<>(Arrays.asList(nums[i] , nums[j] , nums[k])));
                }
                //we increment i till a new nums[i] is found 
                //diff is not 0 we still need to increment i as no combination exists 
                int prev = nums[i];
                while(prev == nums[i] && i < k) i++ ; 
                j = i+1 ;
            }else{
                //diff is greater than 0 so we need to check for every pair of i and k 
                //is there any j there which has sum = 0 
                while(diff > 0 && j < k){
                    j++ ;
                    diff = nums[i] + nums[j] + nums[k];
                }
                if(diff == 0){
                    res.add(new ArrayList<>(Arrays.asList(nums[i] , nums[j] , nums[k])));
                }
                int prev = nums[k];
                while(prev == nums[k] && k > j) k-- ; 
                j = i+1 ;
            }
        }
        return res ;
    }


    public List<List<Integer>> threeSumII(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        int n = nums.length ; 

        for(int i = 0 ; i < n ; i++){
            Map<Integer , Integer> map = new HashMap<>();
            for(int j = i+1 ; j < n ; j++){
                int sum = -(nums[i] + nums[j]);
                if(map.containsKey(sum)){
                    List<Integer> dummy = new ArrayList<>(Arrays.asList(nums[i] , nums[j] , sum)) ;
                    Collections.sort(dummy);
                    set.add(dummy);
                    int freq = map.get(sum);
                    if(freq == 1){
                        map.remove(sum);
                    }else{
                        map.put(sum , freq-1);
                    }
                }
                map.put(nums[j] , map.getOrDefault(nums[j] , 0)+1);
            }
        }
        for(List<Integer> ls : set){
            res.add(ls);
        }
        return res ; 
    }

    public List<List<Integer>> threeSumI(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        int n = nums.length ; 
        for(int i = 0 ; i < n ; i++)
            for(int j = i+1 ; j < n ; j++)
                for(int k = j+1 ; k < n ; k++)
                    if(nums[i] + nums[j] + nums[k] == 0){
                        List<Integer> dummy = new ArrayList<>(Arrays.asList(nums[i] , nums[j] , nums[k])) ;
                        Collections.sort(dummy);
                        set.add(dummy);
                    }
        for(List<Integer> ls : set){
            res.add(ls);
        }
        return res ; 
    }
}
}
