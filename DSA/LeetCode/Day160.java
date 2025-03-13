package LeetCode;

import java.util.Arrays;

public class Day160 {
    class Solution{
    public int minZeroArray(int[] nums, int[][] queries) {
        //firstly we just use difference array tech 
        //to check whther we are able to make the sum 0 
        if(Arrays.stream(nums).allMatch(x -> x == 0)){
            return 0 ; 
        }
        int q = queries.length ; 
        int l = 0 ; 
        int r = q-1 ; 
        int interRes = -1 ; 
        while(l <= r){
            int mid = l + (r-l)/2 ; 
            if(checkDiff(nums , queries ,mid)){
                interRes = mid+1 ; 
                r = mid-1 ;
            }else{
                l = mid+1 ; 
            }
        }
        return interRes ; 
    }
    public boolean checkDiff(int[] nums , int[][] queries , int k ){
        int n = nums.length ; 
        int[] diff = new int[n];
        for(int i = 0 ; i <= k ; i++){
            int[] query = queries[i];
            int L = query[0];
            int R = query[1];
            int val = query[2];
            diff[L] -= val ; 
            if(R < n-1) diff[R+1] += val ; 
        }
        //now we do the cum sum 
        int cumSum = 0 ; 
        for(int i = 0 ; i < n ; i++){
            cumSum += diff[i];
            diff[i] = cumSum ; 
            // System.out.print(diff[i]);
            if(nums[i] + diff[i] > 0){
                return false ;
            }
        }
        // System.out.println();
        return true ; 
    }
}
class SegTree {
    //lets build the segTree 
    int[] segTree ; 
    int[] lazyTree ;
    int n ;
    public void init(int[] arr){
        n = arr.length ; 
        segTree = new int[4*n];
        lazyTree = new int[4*n];
        buildTree(arr , 0 , 0 , n-1);
    }
    public void buildTree(int[] arr , int i , int l , int r){
        if(l == r){
            segTree[i] = arr[l];
            return ; 
        }
        int mid = l + (r - l)/2 ; 
        buildTree(arr, 2*i+1 , l , mid);
        buildTree(arr, 2*i+2 , mid+1 , r);
        segTree[i] = segTree[2*i+1] + segTree[2*i+2];
        return ; 
    }
    public void updateRange(int start , int end , int val , int l , int r , int i ){
        //O(logn)
        //But cant use sadly 
        if(lazyTree[i] != 0){
            propogateLazy(l , r , i);
        }
        if(l > end || r < start){
            //out of range 
            return ; 
        }
        if(l >= start && r <= end){
            segTree[i] += (r-l+1)*val ;
            segTree[i] = (segTree[i] < 0 ? 0 : segTree[i]);
            //why do we do r-l+1 as we are adding the updation worth all the element 
            //in the internal node itself and not going down the tree THUS SAVING TIME 
            if(l!=r){
                //we have children everybody 
                lazyTree[2*i+1] += val ; 
                lazyTree[2*i+2] += val ; 
            }
            return ; 
        }
        int mid = l + (r-l)/2 ; 
        updateRange(start , end , val , l , mid , 2*i+1);
        updateRange(start , end , val , mid+1 , r , 2*i+2);
        //While backtracking we update the tree with new range 
        segTree[i] = segTree[2*i+1] + segTree[2*i+2];
        return ;
    }
    public void propogateLazy(int l , int r , int i ){
        segTree[i] += (r-l+1)*lazyTree[i];
        segTree[i] = (segTree[i] < 0 ? 0 : segTree[i]);
        if(l != r){
            //that there are children thus pass that onto them 
            lazyTree[2*i+1] += lazyTree[i];
            lazyTree[2*i+2] += lazyTree[i];
        }
        lazyTree[i] = 0 ; //as the prev work is completed 
    }
    public int minZeroArray(int[] nums, int[][] queries) {
        //the max i can think of it is to reduce O(n^3) to O(n^2logn)using segment tree 
        //or we can also reduce that O(n) checking that the array is zero 
        //by just checkng the root element of segtree 
        //if it is zero that means all the elements got zero voila!!!!


        //with the help of lazy propogatio we can do this i think 
        
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
            updateRangeNoLazy(start , end , -val , 0 , n-1 , 0);
            // System.out.println();
            operations++ ; 
        }
        return segTree[0] == 0 ? operations : -1 ;
    }
//     no shut up and listen to me you piece of shit 
// the problem is that while lazy propogating we are assuming that the internal nodes are getting the value from respective leaf nodes but in case of 0 , 8 
// there is only one node providing value to the root 
// thus getting 2*val at internal node it causing problem 
public void updateRangeNoLazy(int start , int end , int val , int l , int r , int i ){
    //O(N)
        if(l > end || r < start){
            //out of range 
            return ; 
        }
        if(l == r){
            //that is the leaf node 
            segTree[i] += val ; 
            // segTree[i] = (segTree[i] > 0 ? segTree[i] : 0);
            if(segTree[i] < 0) segTree[i] = 0 ; 
            return ; 
        }
        int mid = l + (r-l)/2 ; 
        updateRangeNoLazy(start , end , val , l , mid , 2*i+1);
        updateRangeNoLazy(start , end , val , mid+1 , r , 2*i+2);
        //While backtracking we update the tree with new range 
        segTree[i] = segTree[2*i+1] + segTree[2*i+2];
        return ;
    }
}
}
