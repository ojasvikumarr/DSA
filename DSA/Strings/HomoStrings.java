package Strings;

public class HomoStrings {
    class Solution {
        int MOD = (int)1e9 + 7 ; 
    
        public int countHomogenous(String s) {
            return solve(s);
        }
        public int solve(String s){
            //sliding Window Approach 
            int l = 0 ;
            int n = s.length(); 
            int sum = 0 ; 
            for(int r = 0 ; r < n ; r++){
                System.out.println(sum);
                if(r == 0) sum = 1; 
                else if( r != 0 && s.charAt(r) == s.charAt(r-1)){
                    sum = (sum + (r - l + 1) + MOD)%MOD ; 
                }else{
                    sum = (sum%MOD + 1); 
                    l = r ; 
                }
            }
            return sum%MOD ;
        }
    }
}
