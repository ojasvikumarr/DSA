package SegmentTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ZeroTransIV {
    class Solution{
    public int minZeroArray(int[] nums, int[][] queries) {
        if(Arrays.stream(nums).allMatch(x -> x == 0)) return 0 ; 
        // int n = nums.length ; 
        int q = queries.length ;
        int l = 0 ; 
        int r = q-1 ; 
        int interRes = -1 ;
        while(l <= r){
            int mid = l + (r-l)/2 ; 
            if(isPossible(nums , queries , mid)){
                interRes = mid+1 ; 
                r = mid - 1; 
            }else{
                l = mid + 1; 
            }
        }
        return interRes ;
    }
    public boolean isPossible(int[] nums ,int[][] queries , int k){
        for(int j = 0 ; j < nums.length ; j++){
            if(nums[j] == 0) continue ; 
            List<Integer> arr = new ArrayList<>();
            for(int i = 0 ; i <= k ; i++){
                int L = queries[i][0];
                int R = queries[i][1];
                int val = queries[i][2];
                if(j >= L && j <= R){
                    arr.add(val);
                }
            }
            if(!targetSum(arr , nums[j])){
                return false ;
            }
        }
        return true ;
    }
    public boolean targetSum(List<Integer> nums , int target){
        //We'll use tabulation for target SUm 
        int n = nums.size();
        boolean[][] dp = new boolean[n+1][target+1];
        for(int i = 0 ; i <= n ; i++){
            dp[i][0] = true ;//bae case as sum of 0 is always possible
        }
        for(int i = 1 ; i <= n ; i++){
            for(int j = 0 ; j <= target ; j++){
                if(j < nums.get(i-1)){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-nums.get(i-1)];
                }
            }
        }
        return dp[n][target];
    }
}
class playGround {

    int[] segTree ; 
    int[] lazyTree ; 
    int n ; 
    int m ;
    public void init(int[] nums){
        n = nums.length ; 
        segTree = new int[4*n];
        lazyTree = new int[4*n];
    }
    public void buildTree(int[] nums , int i , int l , int r){
        if(l == r){
            segTree[i] = nums[l];
            return ;
        }
        int mid = l + (r-l)/2 ; 
        buildTree(nums ,2*i+1 , l , mid);
        buildTree(nums ,2*i+2 , mid+1 , r);
        segTree[i] = segTree[2*i+1] + segTree[2*i+2];
    }
    public boolean solve(int[] nums , int k , int[][] queries){
        int[] diff = new int[m];
        for(int i = 0 ;i <= k ; i++){
            int[] query = queries[i];
            int L = query[0] , R = query[1] , val = query[2]; 
            diff[L] -= val ; 
            if(R+1 < m){
                diff[R+1] += val ; 
            }
        }
        int cumSum = 0 ; 
        for(int i = 0 ; i < m ; i++){
            cumSum += diff[i];
            diff[i] = cumSum ; 
            if(nums[i] + diff[i] > 0) return false ;
        }
        return true ;
    }
    public void lazyUpdate(int start , int end , int l , int r , int i , int val){
        if(lazyTree[i] != 0){
            lazyProp(l , r , i);
        }
        if(l > end || r < start || l > r) return ; 
        if(l >= start && r <= end){
            segTree[i] += (r - l+1)*val ; 
            if(l!=r){
                lazyTree[2*i+1] += val ; 
                lazyTree[2*i+2] += val ; 
            }
            return ;
        }
        int mid = l + (r-l)/2 ; 
        lazyUpdate(start , end , l , mid , 2*i+1 , val);
        lazyUpdate(start , end , mid+1 , r , 2*i+2 , val);
        segTree[i] = segTree[2*i+1] + segTree[2*i+2];
    }
    public void lazyProp(int l , int r , int i){
        segTree[i] += (r-l+1)*lazyTree[i];
        if(l != r){
            lazyTree[2*i+1] += lazyTree[i];
            lazyTree[2*i+2] += lazyTree[i];
        }
        lazyTree[i] = 0 ; 
    }
    public int minZeroArrayIII(int[] nums, int[][] queries) {
        init(nums);
        int operations = 0 ; 
        int i = 0 ; 
        while(segTree[0] != 0 && i < queries.length){
            int query[] = queries[i++];
            int start = query[0];
            int end = query[1] ;
            int val = query[2] ;
            // System.out.println(segTree[0] + " root");
            // for(Integer it : segTree){
            //     System.out.print(it + " - ");
            // }
            // updateRange(start , end , -val , 0 , n-1 , 0);
            NoLazy(start , end , -val , 0 , n-1 , 0);
            // System.out.println();
            operations++ ; 
        }
        return segTree[0] == 0 ? operations : -1 ;   
    }
    public void NoLazy(int start , int end , int l , int r , int i , int val){
        if(l > end || r < start) return ; 
        if(l == r){
            
        }
    }
    public int minZeroArrayII(int[] nums, int[][] queries) {
        boolean zero = true ; 
        // if(Arrays.stream(nums).allMatch(x -> x== 0)) return 0 ; 
        for(Integer it : nums){
            if(it != 0) zero = false ; 
        }
        if(zero == true) return 0 ; 
        int q = queries.length ; 
        int l = 0 ; 
        m = nums.length ;
        int r = q-1 ; 
        int interRes = -1; 
        while(l <= r){
            int mid = l + (r-l)/2 ; 
            if(solve(nums , mid , queries)){
                interRes = mid+1 ; 
                r = mid-1 ;
            }else{
                l = mid + 1 ; 
            }
        }
        return interRes ;
    }
     



    
}
}
