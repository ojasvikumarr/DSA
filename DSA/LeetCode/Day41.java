public class Day41 {
    class Solution {
        public int[] resultsArray(int[] nums, int k) {
            int l = 0 ; 
            int n = nums.length ;
            int[] results = new int[n-k+1];
            int itr = 0 ; 
            for(int r = k-1 ; r < nums.length ; r++){
                results[itr++] = helper(nums , l , r);
                l++ ;
            }
            return results ;
        }
        public int helper(int[] arr , int i , int j ){
            for(int x = i ; x < j ; x++){
                if(arr[x]+1 != arr[x+1]) return -1 ;
            }
            return arr[j];
        }
    }
}
