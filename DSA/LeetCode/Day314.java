class Solution {
    public boolean isPowerOfThree(int n) {
        return solve(n);
    }
    public boolean solve(double n){
        if(n == 1){
            return true ; 
        }else if (n <= 0){
            return false ; 
        }
        return solve((double)n/3);
    }
}