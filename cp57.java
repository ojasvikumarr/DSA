import java.io.*;
import java.util.*;
import java.lang.StringBuilder ;
public class cp57 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int t = Integer.parseInt(br.readLine().trim());
        
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            long[] x = new long[n + 1];
            long[] y = new long[n + 1];

            for (int i = 1; i <= n; i++) {
                st = new StringTokenizer(br.readLine());
                x[i] = Long.parseLong(st.nextToken());
                y[i] = Long.parseLong(st.nextToken());
            }

            long ans = Math.abs(x[a] - x[b]) + Math.abs(y[a] - y[b]);
            long mini = Long.MAX_VALUE / 2;
            long minit = Long.MAX_VALUE / 2;

            for (int i = 1; i <= k; i++) {
                mini = Math.min(mini, Math.abs(x[i] - x[a]) + Math.abs(y[i] - y[a]));
                minit = Math.min(minit, Math.abs(x[i] - x[b]) + Math.abs(y[i] - y[b]));
            }

            ans = Math.min(ans, mini + minit);
            sb.append(ans).append("\n");
        }
        
        System.out.print(sb.toString());
    }
}