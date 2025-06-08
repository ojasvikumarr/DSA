import java.nio.Buffer;
import java.io.* ;
import java.util.* ; 
import java.lang.StringBuilder ; 
import java.util.Arrays ;
public class cp102 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int[][] dp = new int[n+1][m+1] ;
        //base case 
        for(int i = 1 ; i <= m ; i++){
            if(arr[0] == 0 || arr[0] == i){
                //agar 0 hai toh ? and agar i har toh vo toh hum dhundh hi rhe hai 
                dp[1][i] = 1 ;
            }
        }

        int Mod = (int)1e9 + 7 ;

        for(int i = 2 ; i <= n ; i++){
            for(int k = 1 ; k <= m ; k++){
                if(arr[i-1] != 0 && arr[i-1] != k){
                    continue;
                }
                for(int prev = k-1 ; prev <= k+1 ; prev++){
                    if(prev >= 1 && prev <= m){
                        dp[i][k] = (dp[i][k] + dp[i-1][prev])%Mod ;
                    }
                }
            }
        }
        long res = 0 ; 
        for(int i = 1 ; i <= m ; i++){
            res = (res + dp[n][i])%Mod ;
        }
        System.out.println(res);
        br.close();
    }
    
}

