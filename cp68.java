import java.util.* ; 
import java.util.Arrays ; 
import java.io.* ; 

public class cp68{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int total = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] prices = new int[n];
        for(int i = 0 ; i < n ; i++){
            prices[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int[] pages = new int[n];
        for(int i = 0 ; i < n ; i++){
            pages[i] = Integer.parseInt(st.nextToken());
        }

        // solve(prices, pages, n, total);
        // solveII(prices, pages, n, total);
        OIKnpasack(prices, pages, n, total);
        br.close();
    }


    public static void OIKnpasack(int[] prices , int[] pages , int n , int amt){
        int[][] dp = new int[n+1][amt+1];
        for(int i = 1 ; i <= n ; i++){
            for(int j = 0 ; j <= amt ; j++){
                if(prices[i-1] <= j){
                    dp[i][j] = Math.max(dp[i-1][j] , pages[i-1] + dp[i][j-prices[i-1]]) ;
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        System.out.println(dp[n][amt]);
    }
    public static void solveII(int[] prices , int[] pages , int n , int amt){
        int[] dp = new int[amt+1];
        for(int j = 1 ; j <= amt ; j++){
            int maxi = 0 ;
            for(int i = 0 ; i < n ; i++){
                if(prices[i] <= j){
                    maxi = Math.max(maxi , pages[i] + dp[j-prices[i]]);
                }
            }
            dp[j] = maxi ; 
        }
        for(int j = 0 ; j <= amt ; j++){
            System.out.print(dp[j]+" ");
        }
        
        System.out.println(dp[amt]);
    }
    public static void solve(int[] prices , int[] pages , int n , int amt){
        int[][] dp = new int[n][amt+1];
        for(int j = 1 ; j <= amt ; j++){
            for(int i = 0 ; i < n ; i++){
                if(prices[i] <= j){
                    dp[i][j] = pages[i] + dp[i][j-prices[i]];
                }
            }
        }
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j <= amt ; j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        int maxi = 0 ; 
        for(int i = 0 ; i < n ; i++){
            maxi = Math.max(maxi , dp[i][amt]);
        }
        System.out.println(maxi);
    }
}