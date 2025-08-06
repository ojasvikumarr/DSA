class Solution {
    int[] segTree ;
    int n ;
    public void init(int[] baskets ){
        n = baskets.length ; 
        segTree = new int[4*n];
        buildTree(baskets ,0 , 0 , n-1 );
    }
    public void buildTree(int[] arr , int i , int l , int r){
        if(l == r){
            segTree[i] = l;
            return ; 
        }
        int mid = l + (r-l)/2 ; 
        buildTree(arr , 2*i+1 , l , mid);
        buildTree(arr , 2*i+2 , mid + 1 , r);
        int left = segTree[2*i+1];
        int right = segTree[2*i+2];
        segTree[i] = (arr[left] > arr[right] ? left : right);
        return ; 
    }
    public int rangeMinIdx(int arr[] ,int i , int start , int end , int l , int r){
        if(l > end || r < start){
            return -1 ; 
        }
        if(l >= start && r <= end){
            return segTree[i];
        }
        int mid = l + (r-l)/2 ;
        int left = rangeMinIdx(arr , 2*i+1 , start , end , l , mid);
        int right = rangeMinIdx(arr , 2*i+2 , start , end , mid+1 , r);
        if(left == -1) return right ;
        if(right == -1) return left ;
        return (arr[left] > arr[right] ? left : right);
    }
    public void updateTree(int arr[] , int idx , int l , int r , int i){
        if(l == r){
            //segTree index doesnot changes but the internal nodes gets changed   
            return ; 
        }
        int mid = l + (r-l)/2 ; 
        if(idx > mid){
            //we go right side 
            updateTree(arr , idx , mid+1 , r , 2*i+2);
        }else{
            //we go left side 
            updateTree(arr , idx , l , mid , 2*i+1);
        }
        // we need to backtrack 
        int left = segTree[2*i+1];
        int right = segTree[2*i+2];
        segTree[i] = (arr[left] > arr[right] ? left : right);
        return ;
    }
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        init(baskets);
        int unplaced = 0; 

        for(int i = 0 ; i < n ; i++){
            int fruit = fruits[i];
            //binary search 
            int l = 0 ; 
            int r = n-1 ; 
            int interRes = -1 ; 
            while(l <= r){
                int mid = l+(r-l)/2 ; 
                int idx = rangeMinIdx(baskets, 0 , l , mid , 0 , n-1);
                if(baskets[idx] >= fruit){
                    interRes = idx ; 
                    r = mid-1 ; 
                }else{
                    l = mid+1 ; 
                }
            }
            if(interRes == -1){
                // it has remained unplaced 
                unplaced++ ; 
            }else{
                //it is placed thus 
                baskets[interRes] = -1 ; //here we need to update the tree 
                updateTree(baskets , interRes , 0 , n-1 , 0 );
            }
        }
        return unplaced ; 
    }
}