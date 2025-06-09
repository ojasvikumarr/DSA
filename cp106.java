import java.nio.Buffer;
import java.io.* ;
import java.util.* ; 
import java.lang.StringBuilder ; 
import java.util.Arrays ;
public class cp106 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        // int tc = Integer.parseInt(br.readLine());
        // while(tc-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int[] a = new int[n];
            int[] b = new int[m];
            st = new StringTokenizer(br.readLine());
            for(int i = 0 ; i < n ; i++){
                a[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for(int i = 0 ; i < m ; i++){
                b[i] = Integer.parseInt(st.nextToken());
            }

//          8 6
//          3 1 3 2 7 4 8 2
//          6 5 1 2 3 4

            //     3 1 3 2 7 4 8 2
            //   0 0 0 0 0 0 0 0 0 
            // 6 0 0 0 0 0 0 0 0 0 
            // 5 0 0 0 0 0 0 0 0 0
            // 1 0 0 1 1 1 1 1 1 1
            // 2 0 0 1 1 2 2 2 2 2
            // 3 0 1 1 2 2 2 2 2 2
            // 4 0 1 1 2 2 2 3 3 3 

            int[][] dp = new int[n+1][m+1];

            for(int i = 1 ; i <= n ; i++){
                for(int j = 1 ; j <= m ; j++){
                    if(a[i-1] == b[j-1]){
                        dp[i][j] = dp[i-1][j-1] + 1 ; 
                    }else{
                        dp[i][j] = Math.max(dp[i-1][j] , dp[i][j-1]);
                    }
                }
            }
            
            int i = n ; 
            int j = m ; 
            List<Integer> ls = new ArrayList<>();
            while(i >= 1 && j >= 1){
                if( i >= 1 && j >= 1 && a[i-1] == b[j-1]){
                    // sb.append(" "+a[i-1]);
                    ls.add(a[i-1]);
                    i--;
                    j--; 
                }else{
                    if(dp[i-1][j] == dp[i][j]){
                        i-- ; 
                    }else{
                        j-- ; 
                    }
                }
            }

            // sb.reverse();
            Collections.reverse(ls);
            for(int x : ls){
                sb.append(x + " ");
            }
            System.out.println(dp[n][m]);
            System.out.println(sb.toString());
        // }
        // System.out.print(sb.toString());
        br.close();
    }
    public static int gcd(int a , int b){
        if(b == 0) return a ; 
        return gcd(b , a%b);
    }
}

