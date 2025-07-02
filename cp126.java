import java.util.* ; 
import java.io.* ; 
import java.lang.StringBuilder ; 

public class cp126{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());
        while(tc-- > 0){
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] freq = new int[n+1];
            for (int i = 0; i < n; i++) {
                int x = Integer.parseInt(st.nextToken());
                if (x <= n) freq[x]++;
            }
            // ansDiff[k] will be the difference array for ans[k]
            int[] ansDiff = new int[n+2];

            // We will scan m = 0..n+1, but stop once some m-1 is missing.
            boolean ok = true;
            for (int m = 0; m <= n; m++) {
                if (m > 0 && freq[m-1] == 0) {
                    // we no longer can achieve any higher m
                    break;
                }
                int low = freq[m];      // minimum removals: delete all m's
                int high = n - m;       // maximum removals without breaking presence of [0..m-1]
                if (low <= high) {
                    ansDiff[low] += 1;
                    ansDiff[high+1] -= 1;
                }
            }

            // build ans array by prefix‐summing ansDiff
            int cur = 0;
            for (int k = 0; k <= n; k++) {
                cur += ansDiff[k];
                out.append(cur).append(k==n?'\n':' ');
            }
        }
        System.out.println(out.toString());
        br.close();
    }
}