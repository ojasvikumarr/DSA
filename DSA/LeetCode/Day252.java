class Day252{
    class Solution {
    int MOD = (int)(1e9 + 7); 
    // public double nCr(int n , int r){
    //     int num = 1 ; 
    //     int den = 1 ; 
    //     while(r > 0){
    //         num = (num * n%MOD)%MOD ;
    //         den = (den * r%MOD)%MOD ;
    //         n-- ; 
    //         r-- ;
    //     }
    //     return num/den ;
    // }
    public int countGoodArrays(int n, int m, int k) {
        //m(m-1)^b-1 * n-1Cb-1
        preComputeFactorials(n);
        int b = n-k ;
        long nCb = nCr(n-1 , b-1);
        // double mmone = (m*(Math.pow(m-1 , b-1)%MOD))%MOD;
        long ans = modExp(m-1 , b-1 , MOD);
        ans = (ans * m) % MOD ;
        ans = (ans * nCb) % MOD ;
        return (int)ans ;
    }
    long[] fact , invFact ;
    private void preComputeFactorials(int n){
        fact = new long[n+1];
        invFact = new long[n+1];

        fact[0] = 1 ; 
        for(int i = 1 ; i <= n ; i++){
            fact[i] = (fact[i-1]*i)%MOD ;
        }

        invFact[n] = modExp(fact[n] , MOD - 2 , MOD);
        for(int i = n-1 ; i >= 0 ; i--){
            invFact[i] = (invFact[i+1]*(i+1)) % MOD ;
        }
    }
    public long nCr(int n , int r){
        if( r < 0 || r > n ) return 0 ; 
        return ((fact[n] * invFact[r]) % MOD* invFact[n-r]) % MOD ;
    }

    public long modExp(long x , long y , long m){
        long res = 1 ; 
        x %= m ; 
        while(y > 0){
            if((y & 1) == 1){
                res = (res * x)% m ; 
            }
                x = (x*x)%m ; 
                y >>= 1 ;
        }
        return res ;
    }
}
}
