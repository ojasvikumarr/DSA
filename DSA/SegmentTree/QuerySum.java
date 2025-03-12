package SegmentTree;
import java.util.* ; 

public class QuerySum {
    //{ Driver Code Starts
//Initial Template for Java
// } Driver Code Ends


//User function Template for Java

class Solution{
    int[] segTree ; 
    public void init(int n){
        segTree = new int[4*n];
    }
    public void buildTree(int[] arr , int l , int r , int i){
        if(l == r){
            segTree[i] = arr[l];
            return ; 
        }
        int mid = (l+r)/2 ; 
        buildTree(arr , l , mid , 2*i+1);
        buildTree(arr , mid+1 , r , 2*i+2);
        segTree[i] = segTree[2*i+1] + segTree[2*i+2];
        return ; 
    }
    public int queryTree(int start , int end , int l , int r , int i){
        if(l > end || r < start){
            return 0 ;
        }
        if(start <= l && end >= r){
            return segTree[i];
        }
        int mid = (l+r)/2 ; 
        return queryTree(start , end , l , mid , 2*i+1) + 
               queryTree(start , end , mid+1 , r , 2*i+2);
    }
    List<Integer> querySum(int n, int arr[], int q, int queries[])
    {
        // code here
        init(n);
        buildTree(arr , 0 , n-1 , 0);
        List<Integer> result = new ArrayList<>();
        for(int i = 0 ; i < queries.length ; i += 2){
            int start = queries[i]-1;
            int end = queries[i+1]-1;
            result.add(queryTree(start , end , 0 , n-1 , 0));
        }
        return result ; 
        }
    }
}
