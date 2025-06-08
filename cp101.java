import java.io.* ; 
import java.lang.StringBuilder; 
import java.util.* ; 

public class cp101 {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        // int tc = Integer.parseInt(br.readLine());
        // while(tc-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int[] coins = new int[n];
            for(int i =  0 ; i < n; i++){
                coins[i] = Integer.parseInt(st.nextToken());
            }
            int Mod = (int)1e9 + 7 ; 
            int[] dp = new int[x+1];
            dp[0] = 1 ; 
            for(int i = 1 ; i <= x ; i++){
                for(int j = 0 ; j < n ; j++){
                    if(i >= coins[j]){
                        dp[i] = (dp[i] + dp[i-coins[j]])%Mod;
                    }
                }
            }
            sb.append(dp[x]);
            sb.append("\n");
        // }
        System.out.println(sb.toString());
        br.close();
    }
}
