package LeetCode;

public class Day141 {
    class Solution {
        int MOD = (int)1e9 + 7 ;
        public int numOfSubarrays(int[] arr) {
            int n = arr.length ; 
            int[] preSum = new int[n+1];
            preSum[1] = arr[0];
            for(int i = 1 ; i < n; i++){
                preSum[i+1] = preSum[i] + arr[i];
            }
    
            int evenCount = 1 ; 
            int oddCount = 0 ; 
    
            int result = 0 ; 
            for(int i = 1 ; i < n+1 ; i++){
                if(preSum[i] % 2 == 0){
                    result = (oddCount%MOD + result)%MOD;
                    evenCount++ ; 
                }else{
                    result = (evenCount%MOD + result)%MOD ; 
                    oddCount++ ;
                }
            }
    
            return result ; 
        }
    }
}
