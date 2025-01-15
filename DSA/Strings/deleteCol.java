package Strings;

public class deleteCol {
    class Solution {
        public int minDeletionSize(String[] strs) {
            int n = strs[0].length() ; 
            int m = strs.length ; 
            int count = 0; 
            for(int idx = 0 ; idx < n ; idx++){
                for(int i = 1 ; i < m ; i++){
                    if(strs[i-1].charAt(idx) - strs[i].charAt(idx) > 0){
                        count++ ;
                        break ;
                    }
                }
            }
            return count ;
        }
    }
}
