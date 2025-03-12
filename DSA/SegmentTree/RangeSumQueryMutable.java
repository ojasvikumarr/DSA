package SegmentTree;

public class RangeSumQueryMutable {
    class NumArray {
        int[] segTree ; 
        int n ; 
        public NumArray(int[] nums) {
            n = nums.length ; 
            segTree = new int[4*n];
            //We'll call buildSegtree
            buildTree(nums , 0 , 0 , n-1);
        }
        public void buildTree(int[] arr , int i , int l , int r){
            if(l == r){
                segTree[i] = arr[l];
                return ;
            }
            int mid = l + (r - l)/2 ; 
            buildTree(arr , 2*i+1 , l , mid);
            buildTree(arr , 2*i+2 , mid+1 , r);
            segTree[i] = segTree[2*i+1] + segTree[2*i+2];
            return ; 
        }
        public void update(int index, int val) {
            updateTree(index , 0 , 0 , n-1 , val);
            return ; 
        }
        public void updateTree(int index , int i , int l , int r , int val){
            if(l == r){
                segTree[i] = val ; 
                return ; 
            }
            int mid = l + (r-l)/2 ; 
            if(index <= mid){
                updateTree(index , 2*i+1 , l , mid , val);
            }else{
                updateTree(index , 2*i+2 , mid+1 , r , val);
            }
            segTree[i] = segTree[2*i+1] + segTree[2*i+2];
            return ; 
        }
        public int sumRange(int left, int right) {
            return sumTree(left , right , 0 , n-1 , 0);
        }
        public int sumTree(int start , int end , int l , int r , int i ){
            if(l > end || r < start){
                return 0 ; 
            }
            if(l >= start && r<= end){
                return segTree[i];
            }
            int mid = l + (r-l)/2 ; 
            int left = sumTree(start, end , l , mid , 2*i+1);
            int right = sumTree(start , end , mid+1, r , 2*i+2);
            return left + right; 
        }
    }
    
    /**
     * Your NumArray object will be instantiated and called as such:
     * NumArray obj = new NumArray(nums);
     * obj.update(index,val);
     * int param_2 = obj.sumRange(left,right);
     */
}
