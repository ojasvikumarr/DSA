import java.io.* ; 
import java.util.* ; 
import java.util.Arrays;
import java.lang.StringBuilder ; 

public class cp96 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());
        while(tc-- > 0){
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            long[] arr = new long[n];
            boolean flag = true ; 
            for(int i = 0 ; i < n ; i++){
                arr[i] = Long.parseLong(st.nextToken());
                if(i > 0){
                    if(arr[i] != arr[i-1]){
                        flag = false ;
                    }
                }
            }
            if(flag){
                sb.append("0");
                sb.append("\n");
                continue ;
            }

            int i = 0 ; 
            long mini = Long.MAX_VALUE;

            while(i < n ){
                long cost = (long)(i)*arr[i];
                while(i < n-1 && arr[i] == arr[i+1]){
                    i++ ; 
                }
                cost += (long)(n-i-1)*arr[i];
                mini = Math.min(mini , cost);
                // System.out.println("Cost : " + cost + " i : " + i);
                i++ ; 
            }
            // if(i == n-1){
            //     int cost = (i-1)*arr[i]; 
            //     mini = Math.min(mini , cost);
            // }
            sb.append(mini);
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
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
