package LeetCode;

public class Day238 {
    class Solution {
    public long distributeCandies(int n, int limit) {
        long res = 0 ; 
        // for(int ch1 = 0 ; ch1 <= Math.min(n , limit) ; ch1++){
        //     for(int ch2 = 0 ; ch2 <= Math.min(n - ch1 , limit) ; ch2++){
        //         // for(int ch3 = 0 ; ch3 <= Math.min(n - ch1 - ch2 , limit) ; ch3++){
        //         //     if(ch1 + ch2 + ch3 == n){
        //             int ch3 = n - ch1 - ch2 ; 
        //             if(ch1 + ch2 + ch3 == n)
        //                 res++ ; 
        //             // }
        //         // }
        //     }
        // }
        int miniCh1 = Math.max(0 , n - 2*limit );
        int maxiCh1 = Math.min(n , limit);
        for(int ch1 = miniCh1 ; ch1 <= maxiCh1 ; ch1++){
            //now min and max value of ch2 
            int N = n - ch1 ; 
            int miniCh2 = Math.max(0 , N-limit);
            int maxiCh2 = Math.min(N , limit);
            res += maxiCh2 - miniCh2 +1 ;
        }
        return res ;
    }
}
}
