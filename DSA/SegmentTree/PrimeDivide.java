class PrimeDivide{
    int[][] segTree;
    public void buildTree(int[] arr){
        int n = arr.length ; 
        segTree = new int[n][3];
    }
    public void rangeUpdate(int i , int l , int r , int start, int end ,int prime){
        //the prime with which i need to divide every element in the range who is multiple of prime
        if(l > end || r < start){
            return ; 
        }
        int idx = -1 ;
        if(prime == 2) idx = 0 ; 
        if(prime == 3) idx = 1 ; 
        if(prime == 5) idx = 2 ; 

        if(l >= start && r <= end){
            segTree[i][idx]++ ;
            return ; 
        }
        int mid = l + (l - r)/2 ; 
        rangeUpdate(2*i+1 , l , mid , start , end , prime);
        rangeUpdate(2*i+2 , mid+1 , r , start , end , prime);
    }
    public void pointUpdate(int i , int idx , int val , int l , int r){
        //at the point , we need to propogate all the divisors of val 
        propogate();
        if(l == r){
            arr[idx] = val ; 
            return ;
        }
        int mid = l + (l-r)/2 ; 
        if(idx <= mid){
            return pointUpdate(2*i+1 , idx , val , l , mid);
        }else{
            return pointUpdate(2*i+2 , idx , val , mid+1 , r);
        }
    }
    public void propogate(int i , int l , int r){
        if(l == r){
            while(arr[l]%2 == 0 && segTree[i][0] > 0){
                arr[l] /= 2 ; 
                segTree[i][0]-- ; 
            }
            while(arr[l]%3 == 0 && segTree[i][1] > 0){
                arr[l] /= 2 ; 
                segTree[i][1]-- ; 
            }
            while(arr[l]%5 == 0 && segTree[i][2] > 0){
                arr[l] /= 5 ; 
                segTree[i][2]-- ; 
            }
            segTree[i][0] = 0 ; 
            segTree[i][1] = 0 ; 
            segTree[i][2] = 0 ; 
        }else{
            for(int i = 0 ;i < 3 ; i++){
                segTree[2*i+1][i] = segTree[i][i];
                segTree[2*i+2][i] = segTree[i][i];
            }
        }

    }
    //after this function print the desired array ;
    public void propogateAll(int i , int l , int r){
        propogate(i , l , r);
        if(l == r){
            return ; 
        }
        int mid = l + (l - r)/2 ; 
        propogateAll(2*i + 1 , l , mid);
        propogateAll(2*i + 2 , mid+1 , r);
    }
}