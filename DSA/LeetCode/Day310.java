class Solution {
    public boolean isPowerOfTwo(int n) {
        if(popCount(n) == 1){
            return true ;
        }else{
            return false ;
        }
    }
    public int popCount(int x){
        int count = 0 ; 
        while( x > 0 ){
            x ^= (x&-x);
            count++ ; 
        }
        return count ;
    }
}