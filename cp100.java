import java.util.* ; 
import java.io.* ; 
import java.lang.StringBuilder ; 
import java.util.Arrays ; 

public class cp100 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            long n = Long.parseLong(br.readLine());
            long mod = ((int)1e9 + 7 ) ;
            long val1 = 4*n %mod ;
            val1 = (val1*n)%mod ;
            val1 = (val1*n)%mod ;

            long val2 = 3*n %mod ; 
            val2 = (val2*n)%mod ;

            long val3 = -n ; 
            long val = (val1 + val2 + val3 + mod) % mod;
            val = (val * modInverse(6, mod)) % mod;
            val = (val * 2022L) % mod;
            sb.append(val);
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
    public static long gcd(long a , long b){
        if(b == 0 ) return a ; 
        return gcd(b, a%b);
    }
    public static long lcm(long a, long b){
        return (a*b)/gcd(a , b);
    }
    public static long modInverse(long a, long mod) {
        return power(a, mod - 2, mod);
    }

    public static long binMul(long a ,long b , long mod){
        long res = 0 ; 
        a = a%mod ; 
        while(b != 0){
            if((b&1) == 1){
                res = (res+a)%mod ; 
            }
            a = (a+a)%mod ;
            b >>= 1 ;
        }
        return res ;
    }
    public static long binExp(long a, long b , long mod){
        long res = 1 ; 
        a = a%mod ; 
        while( b > 0 ){
            if((b&1) == 1){
                res = binMul(res ,a , mod);
            }
            a = binMul(a , a , mod);
            b >>= 1 ; 
        }
        return res ; 
    }
    public static long power(long a, long b, long mod) {
        long res = 1;
        a %= mod;
        while (b > 0) {
            if ((b & 1) == 1)
                res = (res * a) % mod;
            a = (a * a) % mod;
            b >>= 1;
        }
        return res;
    }
}
