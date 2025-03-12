package SegmentTree;

import java.util.Arrays;

public class AliceNBob {
    class Solution {
    //Segment tree Implementation 
    //Range maximum index query
    int[] segTree ; 
    public void initSegTree(int[] arr , int n){
        segTree = new int[4*n] ;
        buildTree(arr , 0 , 0 , n-1);
    }
    public void buildTree(int[] arr , int i , int l , int r){
        if(l == r){
            segTree[i] = l ;
            return ; 
        }
        int mid = l + (r - l)/2 ; 
        buildTree(arr , 2*i+1 , l , mid);
        buildTree(arr , 2*i+2 , mid+1 , r);
        //While Backtracking
        int left = segTree[2*i+1];
        int right = segTree[2*i+2];

        segTree[i] = (arr[left] > arr[right] ? left : right);
        return ; 
    }
    public int rangeMinIdx(int[] heights , int start , int end , int i , int l , int r){
        if(l > end || r < start){
            return -1 ; 
        }
        if(l >= start && r <= end){
            return segTree[i];
        }
        int mid = l + (r-l)/2 ; 
        int left = rangeMinIdx(heights , start , end , 2*i+1 , l , mid);
        int right = rangeMinIdx(heights , start , end , 2*i+2 , mid+1 , r);

        if(left == -1) return right ; 
        if(right == -1) return left ; 
        return (heights[left] > heights[right] ? left : right);
    }

    public int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
        int n = heights.length ; 
        initSegTree(heights , n);
        int m = queries.length ; 
        int[] res = new int[m];
        for(int i = 0 ; i < m ; i++){
            int alice = queries[i][0];
            int bob = queries[i][1];
            int maxIdx = Math.max(alice , bob);
            int minIdx = Math.min(alice , bob);
            if(alice == bob){
                //if yes then no need to jump 
                res[i] = alice ; 
                continue ;
            }else if(heights[maxIdx] > heights[minIdx]){
                //If it is yes then the one that is at the starting they can jump to the maxIdx 
                res[i] = maxIdx ;
                continue ;
            }else{
                //No chance we'll do a binary search over the segment tree 
                //the range will be 
                int l = maxIdx+1 ; 
                int r = n-1 ; 
                int maxHtAliceBob = Math.max(heights[alice] , heights[bob]);
                int intermediateAns = -1 ; 
                while(l <= r){
                    int mid = l + (r-l)/2 ; 
                    int idx = rangeMinIdx(heights ,l , mid , 0 , 0 , n-1);
                    if(heights[idx] > maxHtAliceBob){
                        intermediateAns = idx ; 
                        r = mid-1 ; 
                    }else{
                        l = mid+1 ; 
                    }
                }
                res[i] = intermediateAns ;
            }
        }
        return res ; 
    }

    public int[] leftmostBuildingQueriesII(int[] heights, int[][] queries) {
        int n = queries.length ;
        int[] ans = new int[n];
        Arrays.fill(ans , -1);
        int x = 0 ; 
        for(int[] query : queries){
            int idx1 = query[0] < query[1] ? query[0] : query[1];
            int idx2 = query[1] > query[0] ? query[1] : query[0];
            if(idx1 == idx2){
                ans[x] = idx1 ;
                x++ ;
                continue ;
            } 
            for(int i = idx2 ; i < heights.length ; i++){
                if(heights[idx1] < heights[i]){
                    ans[x] = i ;
                    break ;
                }
            }
            x++;
        }
        return ans ;
    }

    public int[] leftmostBuildingQueriesIII(int[] heights, int[][] queries) {
        int n = heights.length;
        int[][] st = new int[n][20];
        int[] Log = new int[n + 1];
        Log[0] = -1;
        
        for (int i = 1; i <= n; i++) {
            Log[i] = Log[i >> 1] + 1;
        }

        for (int i = 0; i < n; i++) {
            st[i][0] = heights[i];
        }

        for (int i = 1; i < 20; i++) {
            for (int j = 0; j + (1 << i) <= n; j++) {
                st[j][i] = Math.max(st[j][i - 1], st[j + (1 << (i - 1))][i - 1]);
            }
        }

        int[] res = new int[queries.length];
        
        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0], r = queries[i][1];
            if (l > r) {
                int temp = l;
                l = r;
                r = temp;
            }

            if (l == r) {
                res[i] = l;
                continue;
            }

            if (heights[r] > heights[l]) {
                res[i] = r;
                continue;
            }

            int maxHeight = Math.max(heights[l], heights[r]);
            int left = r + 1, right = n, mid;

            while (left < right) {
                mid = (left + right) / 2;
                int k = Log[mid - r + 1];
                int maxInRange = Math.max(st[r][k], st[mid - (1 << k) + 1][k]);

                if (maxInRange > maxHeight) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }

            res[i] = (left == n) ? -1 : left;
        }

        return res;
    }

}
}
