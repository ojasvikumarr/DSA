package LeetCode;

public class Day118 {
    class Solution {
        public int longestMonotonicSubarray(int[] arr) {
            int count1 = 0 ; 
            int count2 = 0 ; 
            int maxi = 0 ; 
            int n = arr.length ;
            if(n == 1) return 1 ; 
            for(int i = 0 ; i < n-1 ; i++){
                count1++ ; 
                maxi = Math.max(maxi , count1);
                if(arr[i] >= arr[i+1]){
                    count1 = 0 ; 
                }
                count2++ ; 
                maxi = Math.max(maxi , count2);
                if(arr[i] <= arr[i+1]){
                    count2 = 0 ; 
                }
            }
            count1++ ; 
            maxi = Math.max(maxi , count1);
            count2++ ; 
            maxi = Math.max(maxi , count2);
    
            return maxi ; 
        }
        public int longestMonotonicSubarrayII(int[] arr) {
            boolean flag = true ; 
            int n = arr.length ;
            if(n == 1) return 1 ;
            if(arr[0] < arr[1]) flag = true ; 
            else flag = false ; 
            int count = 0 ;  
            int maxi = 0 ; 
            for(int i = 0 ;i < n-1 ; i++){
                if(flag == true){
                    //we need to fid the increasing. 
                    count++ ; 
                    maxi = Math.max(maxi , count);
                    if(arr[i] >= arr[i+1]){
                        flag = false ; 
                        count = 0 ; 
                    }
                }else{
                    count++ ; 
                    maxi = Math.max(maxi , count);
                    if(arr[i] <= arr[i+1]){
                        flag = true ; 
                        count = 0 ; 
                    }
                }
            }
            count++ ; 
            maxi = Math.max(maxi , count);
            return maxi ;
        }
    }
}
