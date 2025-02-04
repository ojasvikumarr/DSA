package DynamicProgramming;

public class BeautifulArray {
    class Solution {
        public int minDeletion(int[] arr) {
            int n = arr.length ;
            if(n == 1) return 1; 
            int i = 1 ; 
            int j = 0 ; 
            int ops = 0 ; 
            while(i < n && j < n){
                while(arr[j] == arr[i]){
                    arr[i] = -1 ;
                    ops++ ;
                    i++ ;
                    if(i == n) break ; 
                }
                j = i+1 ; 
                i = j+1 ; 
                // while(arr[i] == -1) i++ ;
            }
            return (n-ops)%2 == 0 ? ops : ops+1 ; 
        }
    }
}
