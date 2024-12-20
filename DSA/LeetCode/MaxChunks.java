package LeetCode;

import java.util.Arrays;

public class MaxChunks {
    class Solution {
    public int maxChunksToSorted(int[] arr) {
        int n = arr.length ; 
        int chunks = 0 ; 
        int[] prefMax = new int[n];
        int[] suffMin = new int[n];
        Arrays.fill(suffMin , Integer.MAX_VALUE);
        prefMax[0] = arr[0];
        suffMin[n-1] = arr[n-1];
        for(int i = 1 ; i < n ; i++){
            prefMax[i] = Math.max(prefMax[i-1] , arr[i]);
            suffMin[n-i-1] = Math.min(suffMin[n-i] , arr[n-i-1]);
        }
        for(int i = 0 ; i < n-1 ; i++){
            if(prefMax[i] < suffMin[i+1]) chunks++ ;
        }
        return chunks+1 ;
    }
    public int maxChunksToSortedII(int[] arr) {
        int n = arr.length;
        int chunks = 0, prefixSum = 0, sortedPrefixSum = 0;

        for (int i = 0; i < n; i++) {
            prefixSum += arr[i];
            sortedPrefixSum += i;
            if (prefixSum == sortedPrefixSum) {
                chunks++;
            }
        }
        return chunks;
    }
}
}
