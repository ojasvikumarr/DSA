package DynamicProgramming;

public class LongestCOmmonSubArray {
    class Solution {
        public int findLength(int[] nums1, int[] nums2) {
            int n = nums1.length ; 
            int m = nums2.length ; 
            int[][] tab = new int[n+1][m+1];
            //This array is already initialised with 0 value 
    
            int maxi = 0 ; 
    
            for(int i = 1 ; i <= n ; i++){
                for(int j = 1 ; j <= m ; j++){
                    if(nums1[i-1] == nums2[j-1]){
                        tab[i][j] = tab[i-1][j-1] + 1 ;
                        maxi = Math.max(maxi , tab[i][j]);
                    }else{
                        //let it be 0 
                        tab[i][j] = 0 ;
                    }
                }
            }
            //Again traverse the array and find out the max length 
            //Or we can just have a maxi variable noting down the max lengths of the subarrays 
            return maxi ; 
        }
    }
}
