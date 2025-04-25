import java.util.* ; 
import java.io.* ; 
import java.lang.StringBuilder ; 

public class cp83 {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // Scanner sc = new Scanner(System.in);
        // int t = sc.nextInt();
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(t-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            long[] a = new long[n];
            long[] b = new long[m];

            st = new StringTokenizer(br.readLine());
            for(int i = 0 ; i < n ; i++){
                a[i] = Long.parseLong(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for(int i = 0 ; i < m ; i++){
               b[i] = Long.parseLong(st.nextToken());

            }


    // dp[i][j] = true if we can reach a[i] using b[j] with 0 or 1 skip
    // boolean[][] dp = new boolean[n + 1][2]; // dp[i][0] = no skip used, dp[i][1] = one skip used
    // dp[0][0] = true;

    // for (int i = 0; i < n; i++) {
    //     for (int skip = 0; skip <= 1; skip++) {
    //         if (!dp[i][skip]) continue;

    //         // Case 1: assign b[i - skip] to a[i]
    //         if (i - skip < m && a[i] >= b[i - skip]) {
    //             dp[i + 1][skip] = true;
    //         }

    //         // Case 2: skip b[i - skip], only if skip not used yet
    //         if (skip == 0 && i - skip + 1 < m) {
    //             // Skip b[i]
    //             if (a[i] >= b[i - skip + 1]) {
    //                 dp[i + 1][1] = true;
    //             }
    //         }
    //     }
    // }

    // if (dp[n][0]) return 0; // no skip used, all assigned
    // if (!dp[n][1]) return -1; // not possible

    // // Find which b[i] was skipped
    // for (int i = 0; i < m; i++) {
    //     List<Integer> newB = new ArrayList<>();
    //     for (int j = 0; j < m; j++) if (j != i) newB.add(b[j]);

    //     boolean ok = true;
    //     for (int j = 0; j < newB.size(); j++) {
    //         if (a[j] < newB.get(j)) {
    //             ok = false;
    //             break;
    //         }
    //     }
    //     if (ok) return b[i]; // this skipped element makes it work
    // }

    // return -1;
            int[][] dp = new int[n+1][2];
            dp[0][0] = 1 ; 
            for(int i = 0 ; i < n ; i++){
                for(int j = 0 ; j <= 1; j++){
                    if(dp[i][j] == 1) continue ;
                    if(i-j < m && a[i] >= b[i-j]){
                        dp[i+1][j] = 1 ;
                    }
                    if(j==0 && i-j+1 < m){
                        dp[i+1][1] = 1 ;
                    }
                }
            }
            if(dp[n][0] == 1){
                sb.append(0);
                sb.append("\n");
                continue ;
            }
            if(dp[n][1] == 0){
                sb.append(-1);
                sb.append("\n");
                continue ; 
            }

            // for(int i = 0 ; i < m ; i++){
            //     List<Integer> ls = new ArrayList<>();
            //     for(int j = 0 ; j < m ; j++)
            // }
            sb.append("\n"  );
        }
        System.out.println(sb); 
    }
}
