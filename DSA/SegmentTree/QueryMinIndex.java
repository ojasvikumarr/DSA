package SegmentTree;

public class QueryMinIndex {
    int[] segTree ; 
    public void init(int[] arr , int n){
        segTree = new int[4*n];
        buildTree(arr, 0, 0, n-1);
    }
    public void buildTree(int arr[] , int i , int l , int r){
        if(l == r){
            // segTree[i] = arr[l];
            segTree[i] = l;//storing the index
            return ;
        }
        int mid = l + (r-l)/2 ; 
        buildTree(arr , 2*i+1 , l , mid);
        buildTree(arr , 2*i+2 , mid+1 , r);
        // segTree[i] = Math.min(segTree[2*i+1] , segTree[2*i+2]);
        int leftIdx = segTree[2*i + 1];
        int rightIdx = segTree[2*i + 2];
        segTree[i] = (arr[leftIdx] > arr[rightIdx] ? rightIdx : leftIdx);
        return ; 
    }
    public int minIndexRange(int[] arr , int i , int start , int end , int l , int r){
        if(l > end || r < start){
            return -1 ;
        }
        if(l >= start && r <= end){
            return segTree[i];
        }

        int mid = l + (r-l)/2 ; 
        int leftIdx = minIndexRange(arr , 2*i+1, start, end, l, mid);
        int rightIdx = minIndexRange(arr , 2*i+2, start, end, mid+1, r);
        if(leftIdx == -1) return rightIdx ; 
        if(rightIdx == -1) return leftIdx ; 
        return (arr[leftIdx] > arr[rightIdx] ? rightIdx : leftIdx);
    }
}
