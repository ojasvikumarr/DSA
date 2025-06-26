class MultipleOf3{
    int[] segTree ; 
    public void init(int n){
        segTree = new int[n][3];
    }
    public void buildTree(int i , int l , int r){
        if(l == r){
            segTree[i][0] = 1; 
            return ;
        }
        int mid = l + (l - r)/2 ; 
        buildTree(2*i + 1, l , mid);
        buildTree(2*i + 2, mid+1 , r);
        segTree[i] = segTree[2*i+1] + segTree[2*i+2];
    }
    public void rangeUpdate(int i , int l , int r , int start , int end){
        if(l > end || r < start){
            return ; 
        }
        if(l >= start && r <= end){
            //we are adding 1 to all the elements in the range , shift by one index 
            int temp = segTree[i][0] ;
            segTree[i][0] = segTree[i][2];
            segTree[i][2] = segTree[i][1];
            segTree[i][1] = temp ; 
            return ; 
        }
        int mid = l + (l - r)/2 ; 
        rangeUpdate(2*i + 1, l , mid , start , end);
        rangeUpdate(2*i + 2, mid+1 , r , start , end);
        segTree[i] = segTree[2*i + 1] + segTree[2*i + 2];
    }
    public void rangeMultiples(int i , int l , int r , int start , int end){
        if(l > end || end < start){
            return 0 ; 
        }
        if(l >= start && r <= end){
            return segTree[i][0];
        }
        int mid = l + (l-r)/2 ; 
        int left = rangeMultiples(2*i + 1 , l , mid , start , end);
        int right = rangeMultiples(2*i + 2 , mid+1 , r , start , end);
        return left + right ; 
    }
}