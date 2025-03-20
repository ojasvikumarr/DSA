package PlacementTime.DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class PartitionNLength {
    class Solution {
    Set<Integer> res ;
    int[][][] memo ; 
    public int minimumDifference(int[] nums) {
        //top down approach 
        //my aim will be to select all possible paths in which there are n elements 
        //and add there sum into a set so that i can check afterwards 
        // int sum = Arrays.stream(nums).sum();
        // res = new HashSet<>();
        // int n = nums.length/2 ; 
        // // memo = new int[nums.length][sum+1][n] ; 
        // // for(int[][] mat : memo){
        // //     for(int[] row : mat){
        // //         Arrays.fill(row , -1);
        // //     }
        // // }

        // solve(nums , nums.length-1 , 0 , n);
        // int mini = Integer.MAX_VALUE ; 
        // for(int sums : res){
        //     mini = Math.min(mini , Math.abs(sum - 2*sums));
        // }
        // return mini ; 
        // return tabulation(nums , sum , nums.length);
        return MeetInMiddle(nums);
    }
    public int MeetInMiddle(int[] nums ){
        int sum = Arrays.stream(nums).sum();
        int N = nums.length ; 
        int n = N/2 ; 

        Map<Integer , List<Integer>> left = new HashMap<>();
        Map<Integer , List<Integer>> right = new HashMap<>();

        for(int mask = 0 ; mask < (1<<n) ; mask++){
            int size = 0 ; 
            int l = 0 ; 
            int r = 0 ; 
            for(int i = 0 ; i < n; i++){
                if(((1<<i)&mask) != 0){
                    l += nums[i];
                    r += nums[n+i];
                    size++ ; 
                }
            }
            left.putIfAbsent(size , new ArrayList<>());
            left.get(size).add(l);
            right.putIfAbsent(size , new ArrayList<>());
            right.get(size).add(r);
        }

        int res = 0 ; 
        res = Math.min(Math.abs(sum - 2*left.get(n).get(0) ), 
                       Math.abs(sum - 2*right.get(n).get(0)));
        
        for(int size = 1 ; size < n ; size++){
            //n , n-1 , n-2 , n-3.....3 , 2 , 1 , 0
            Collections.sort(right.get(n-size));
            //0 , 1 , 2 , 3 , .....n-2 , n-1 , n
            for(int a : left.get(size)){
                int b = (sum - 2*a)/2; 
                int rsz = n-size ; 
                
                List<Integer> rightList = right.get(rsz);
                //binary search 
                int idx = Collections.binarySearch(rightList , b);
                if(idx < 0) idx = -(idx+1); // if the idx is not present then it give a
                //negative outOfBound idx where it could have possibly been the value
                if(idx < rightList.size()){
                    res = Math.min(res , Math.abs(sum - 2 * (a + rightList.get(idx))));
                }
                if(idx > 0){
                    res = Math.min(res , Math.abs(sum - 2 * (a + rightList.get(idx-1))));
                }
            } 
        }
        return res ; 
    }
    public int tabulation(int[] nums , int sum , int n ){
        boolean[][] tab = new boolean[n][sum+1];
        for(int i = 0 ; i < n ; i++) tab[i][0] = true ; 
        if(nums[0] <= sum) tab[0][nums[0]] = true ; 

        for(int i = 1 ; i < n ; i++){
            for(int tar = sum ; tar >= nums[i] ; tar--){
                boolean pick = tab[i-1][sum-tar];
                boolean notpick = tab[i-1][tar];
                tab[i][tar] = pick | notpick ; 
            }
        }

        int mini = Integer.MAX_VALUE ; 
        for(int tar = 0 ; tar <= sum ; tar++){
            if(tab[n-1][tar] == true)
            mini = Math.min(mini , sum - 2*tar);
        }
        return mini ; 
    }
    public void solve(int[] nums , int idx , int sum , int n){
        if(n == 0){
            res.add(sum);
            return ;
        }
        if(idx < 0){
            return ; 
        }
        // pick
        solve(nums , idx-1 , sum + nums[idx] , n-1);
        // notpick 
        solve(nums , idx-1 , sum , n);
        return ;
    }
}
}
