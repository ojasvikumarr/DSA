package MathConcepts;

public class countPrime {
    class Solution {
        public int countPrimes(int n) {
            //O(n*n)
            //A naive solution where every element in the range is checked 
            //O(n*n/2)
            //A better solution where we only go till n/2 while checking for prime 
            //O(n*sqrt(n))
            //A better solution where only go till Math.sqrt(n) as we only check till half of the factors 
            // -------These approaches wont work -------- //
            //O(n*log(logn))
            //This should get accepted 
            if(n <= 2) return 0 ; 
            return seiveOfEratothenes(n-1);
        }
        public int seiveOfEratothenes(int n){
            boolean[] isPrime = new boolean[n+1];
            for(int i = 2 ; i <= n ; i++){
                isPrime[i] = true ;
            }
    
            for(int i = 2 ; i*i <= n ; i++){
                if(isPrime[i] == true){
                    for(int j = i*i ; j <= n ; j+=i){
                        isPrime[j] = false ;
                    }
                }
            }
            int count = 0 ; 
            for(boolean prime : isPrime){
                if(prime) count++ ; 
            }
            return count ; 
        }
    }
}
