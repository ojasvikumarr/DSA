import java.io.* ; 
import java.util.* ; 
import java.lang.StringBuilder ; 

public class cp93 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());
        while(tc-- > 0){
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] p = new int[n];
            for(int i = 0 ; i < n ; i++){
                p[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            int[] q = new int[n];
            for(int i = 0 ; i < n ; i++){
                q[i] = Integer.parseInt(st.nextToken());
            }

            int maxi1 = p[0] ; 
            int up = 0 ; 
            int maxi2 = q[0] ; 
            int down = 0 ; 
            long[] res = new long[n];

            for(int i = 0 ; i < n ; i++){
                if(maxi1 < p[i]){
                    maxi1 = p[i];
                    up = i ; 
                }
                if(maxi2 < q[i]){
                    maxi2 = q[i];
                    down = i ; 
                }
                int m = Math.max(maxi1 , q[i-up]);
                int mm = Math.max(maxi2 , p[i-down]);
                // int val1 = 
                if(m > mm){
                    res[i] = power(maxi1 , q[i-up]) ;
                }else if(m == mm){
                    if(q[i-up] > p[i-down]){
                        res[i] = power(maxi1 , q[i-up]) ;
                    }else{
                        res[i] = power(maxi2 , p[i-down]) ;
                    }
                }else{
                    res[i] = power(maxi2 , p[i-down]) ;
                }
                // res[i] = Math.max(power(maxi1 , q[i-up]) , power(maxi2 , p[i-down])) ;
                // System.out.println(maxi1 + " - " + maxi2 + " - " + q[i-up] + " - " + q[i-down] + " - " + res[i]);
            }
            for(int i= 0 ; i < n ; i++){
                sb.append(res[i]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
    static int mod = 998244353 ;
    public static long power(int p , int q){
        // long v = 1L<<p ;
        long v = modpow(2, p);
        long u = modpow(2, q);
        return (v + u)%mod ;
    }
    public static long modpow(long base , int exp ){
        base = base%mod ;
        long res = 1 ; 
        while(exp > 0){
            if((exp&1) == 1) res = (res*base)%mod ;
            base = (base*base)%mod ;
            exp >>= 1 ;
        }
        return res ;
    }
}
