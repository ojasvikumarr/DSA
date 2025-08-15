class Solution {
    public boolean isPowerOfFour(int n) {
        return solve((double)n);
    }
    public boolean solve(double x){
        if(x == 1.0){
            return true ; 
        }else if(x < 1.0){
            return false ;
        }
        return solve((double)x/4);
    }
}