import java.io.* ; 
import java.util.* ; 
import java.lang.StringBuilder; 
public class cp89 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            int[] arr = new int[n];
            st = new StringTokenizer(br.readLine());
            for(int i = 0 ;i  < n ; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            long[] preSum = new long[n+1];
            preSum[0] = arr[0];
            long[] sufSum = new long[n+1];
            sufSum[n-1] = arr[n-1];

            for(int i = 1 ; i < n ; i++){
                preSum[i] = preSum[i-1] + arr[i];
            }
            for(int i = n-1 ; i >= 0 ; i--){
                sufSum[i] = sufSum[i+1] + arr[i];
            }

            while(q-- > 0){
                st = new StringTokenizer(br.readLine());
                int l = Integer.parseInt(st.nextToken())-1;
                int r = Integer.parseInt(st.nextToken())-1;
                int k = Integer.parseInt(st.nextToken());

                long mid =(r-l+1)*k ; 
                long left = l-1 < 0 ? 0 : preSum[l-1];
                long right = sufSum[r+1];
                if((mid+left+right) % 2 != 0){
                    sb.append("Yes");
                }else{
                    sb.append("No");
                }
                sb.append("\n");
            }

        }
        System.out.println(sb.toString());
    }
    public static int gcd(int a , int b){
        if(b == 0){
            return a ; 
        }
        return gcd(b , a%b);
    }
}
