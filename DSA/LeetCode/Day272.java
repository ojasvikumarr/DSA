class Solution {
    public int minStable(int[] nums, int maxC) {
        
    }
    int[] segTree ; 
    public void init(int n ){
        segTree = new int[4*n];
        buildTree();
    }
    public void builTree(int i , int l , int r , int[] arr ){
        if(l == r){
            segTree[i] = arr[l];
            return ; 
        }
        int mid = l + (r-l)/2 ; 
        buildTree(2*i+1 , l , mid , arr);
        buildTree(2*i+2 , mid + 1, r , arr);
        segTree[i] = gcd(segTree[2*i+1] , segTree[2*i+2]);
    }
    
    public int gcd(int a , int b){
        if(b == 0){
            return a ;
        }
        return gcd( b, a%b);
    }
}