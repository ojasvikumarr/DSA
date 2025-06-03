import java.io.* ; 
import java.util.* ; 
import java.lang.StringBuilder ; 

public class cp96 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());
        while(tc-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            long a = Long.parseLong(st.nextToken());
            long b = Long.parseLong(st.nextToken());

            long diff = Math.abs(a - b);
            if(diff == 0){
                sb.append(0 + " " + 0);
                sb.append("\n");
                continue;
            }
            long moves = 0 ; 
            long floor =(int) Math.floor((double)a/diff)*diff ; 
            long ceil = (int)Math.ceil((double)a/diff)*diff ;
            // System.out.println("floor = " + floor + " ceil = " + ceil);
            moves = Math.min(Math.abs(a - floor) , Math.abs(ceil - a));
            sb.append(diff + " " + moves);
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
