import java.io.* ; 
import java.util.* ; 
import java.lang.StringBuilder ; 

public class cp96 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());
        while(tc-- > 0){
            long n = Long.parseLong(br.readLine());
            int res = 0 ; 
            while( n%6 == 0 || n%3 == 0){
                if(n%6 == 0){
                    n /= 6;
                }else if(n%3 == 0){
                    n *= 2;
                }
                res++;
                if(n == 1) break ; 
            }
            if(n == 1){
                sb.append(res);
            }else{
                sb.append(-1);
            }

            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
    // Fast exponentiation for 2^k
    static long pow2(long k) {
        // int MOD = 1000000007;
        long res = 1, base = 2;
        while(k > 0) {
            if((k & 1) == 1) res = (res * base);
            base = (base * base) ;
            k >>= 1;
        }
        return res;
    }
    public static int gcd(int a , int b){
        if(a == 0) return b ;
        return gcd(b%a , a);
    }
}
