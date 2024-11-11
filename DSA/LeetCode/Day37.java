public class Day37 {
    class Solution {
        // static boolean signal = true ;
        public boolean primeSubOperation(int[] nums) {
            int n = nums.length ;
            for(int i = n-2 ; i >= 0 ; i--){
                if(nums[i] < nums[i+1]) continue ;
                else{
                    int newValue= primeSub(nums[i] , nums[i+1]);
                    if(newValue == nums[i]) return false ;
                    nums[i] = newValue ;
                }
            }
            return true;
        }
        public int primeSub(int dummy , int target){
            for(int prime = 2 ; prime < dummy ; prime++){
                if(isPrime(prime) && dummy - prime < target){
                    return dummy - prime ;
                }
            }
            return dummy ;
        }
        public boolean isPrime(int n ){
            if(n <= 1) return false ;
            for(int i = 2 ; i <= Math.sqrt(n) ; i++){
                if(n%i == 0) return false ;
            }
            return true ;
        }
    
    }
}
