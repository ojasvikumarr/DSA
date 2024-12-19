package LeetCode ;

public class Day79 {
    class Solution {

        public int maxChunksToSorted(int[] arr) {
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
