package SegmentTree ;
public class Revision {
    static int[] segTree ; 
    static int[] lazyTree ; 

    static int n; 
    public static void initSegTree(int[] arr){
        n = arr.length ; 
        segTree = new int[4*n];
        lazyTree = new int[4*n];
        buildTree(arr , 0 , n-1 , 0);
    }
    public static void buildTree(int[] arr , int l , int r , int i ){
        if(l == r){
            segTree[i] = arr[l];
            return ; 
        }
        int mid = l + (r-l)/2 ;
        buildTree(arr, l, mid, 2*i+1);
        buildTree(arr, mid+1, r, 2*i+2);
        segTree[i] = segTree[2*i+1] + segTree[2*i+2];
    }
    //update query 
    public static void update(int[] arr , int val , int idx , int l , int r , int i){
        if(l == r){
            segTree[i] = val ;
            arr[idx] = val ;
            return ; 
        }
        int mid = l + (r - l)/2 ; 
        if(idx > mid){
            update(arr , val , idx , mid + 1 , r , 2*i+2);
        }else{
            update(arr ,val , idx , l , mid , 2*i+1);
        }
        segTree[i] = segTree[2*i+1] + segTree[2*i+2];
    }
    //sum query 
    public static int sumQuery(int l , int r , int start , int end , int i ){
        if(l > end || r < start){
            return 0 ;
        }
        if(l >= start && r <= end){
            return segTree[i];
        }
        int mid = l + (r-l)/2 ; 
        int left = sumQuery(l , mid  , start , end , 2*i+1);
        int right = sumQuery(mid+1 , r , start , end , 2*i+2);
        // segTree[i] = left + right ; we need no update the tree 
        return left + right; 
    }
    //range update
    public static void rangeUpdate(int l , int r , int start , int end , int i , int val){
        lazyPropogate(l, r, i);
        if(l > end || r < start){
            return ; 
        }
        if( l >= start && r <= end){
            // lazyPropogate(l, r, i); no need already done
            segTree[i] += (r-l+1)*val ; 
            if(l != r){
                lazyTree[2*i+1] += val ; 
                lazyTree[2*i+2] += val ; 
            }
            return ;
        }
        int mid = l + (r-l)/2 ; 
        rangeUpdate(l, mid, start, end, 2*i+1, val);
        rangeUpdate(mid+1, r, start, end, 2*i+2, val);
        segTree[i] = segTree[2*i+1] + segTree[2*i+2];
    }
    public static void lazyPropogate(int l , int r , int i){
        if(lazyTree[i] != 0){
            segTree[i] += (r-l+1)*lazyTree[i] ; 
            if(r != l){
                //we have childrens 
                lazyTree[2*i+1] += lazyTree[i];
                lazyTree[2*i+2] += lazyTree[i];
            }
            lazyTree[i] = 0 ; 
        }
        return ;
    }
    public static int kadanes(int[] arr){
        //we need to store l and r also 
        int start = 0 ; 
        int end = 0 ; 
        int maxSum = Integer.MIN_VALUE ;
        int l = 0 ; 
        int r = 0 ; 
        int sum = 0 ;
        while(r < n){
            sum += arr[r];
            if(sum < 0){
                //we incr l till its positive 
                while( sum < 0 && l < n){
                    sum -= arr[l];
                    l++ ; 
                }
            }
            if(maxSum < sum){
                maxSum = Math.max(maxSum , sum);
                start = l ; 
                end = r ; 
            }
            r++ ; 
        }
        System.out.println(maxSum + " " + start + " " + end  );
        return maxSum ;
    }
    public static void main(String args[]){
        int[] arr = {2 , 3 , 1 , 5 , 2 , 5, 3 , 6};
        int[] arrr = {2 , -1 , -3 , 5 , 0 , 1, 3 , -4};
        initSegTree(arr);
        System.out.println("Sum : "+segTree[0]);
        update(arr ,10, 3, 0, n-1, 0);
        for(int ar : arr){
            System.out.print(ar + " ") ; 
        }
        System.out.println("Sum : "+segTree[0]);
        rangeUpdate(0, n-1, 3,5, 0, 100);
        for(int ar : arr){
            System.out.print(ar + " ") ; 
        }
        System.out.println("Sum : "+segTree[0]);
        kadanes(arrr);

        //range update and max subarray sum simultaneously

    }
}
