package SegmentTree ; 

public class QueryMin {
    static int st[];
    
    public static int[] constructST(int arr[], int n)
    {
        // Add your code here
        st = new int[4*n];
        buildTree(arr , 0 , n-1 , 0);
        return st ; 
    }
    
    public static void buildTree(int[] arr , int l , int r , int i){
        if(l == r){
            st[i] = arr[l];
            return ; 
        }
        int mid = l+(r-l)/2 ; 
        buildTree(arr , l , mid , 2*i+1);
        buildTree(arr , mid+1 , r , 2*i+2);
        st[i] = Math.min( st[2*i+1] , st[2*i+2]);
        return ; 
    }
    /* The functions returns the
      min element in the range
      from l and r */
    public static int minQuery(int i , int start , int end , int l , int r){
       if(l > end || r < start){
           return Integer.MAX_VALUE ;
       }
       if(l >= start && r <= end){
           return st[i];
       }
       
       int mid = l + (r-l)/2 ; 
       int left = minQuery(2*i+1 , start , end , l , mid);
       int right = minQuery(2*i+2 , start , end , mid+1 , r);
       return Math.min(left , right);
    }
    public static int RMQ(int st[], int n, int start, int end)
    {
       // Add your code here
       return minQuery(0 , start , end , 0 , n-1);
    }
    
}