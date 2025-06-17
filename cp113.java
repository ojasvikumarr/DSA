import java.util.* ; 
import java.lang.* ; 
import java.io.* ; 
import java.util.Arrays ;
public class cp113{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String a = st.nextToken();
            String b = st.nextToken();
            dp = new int[a.length()+1][2][2];
            for(int[][] mat : dp){
                for(int[] row : mat) Arrays.fill(row , -1);
            }
            sb.append(digitDp(0 , a , b, 1 , 1 ));
            sb.append("\n");
        }
        System.out.println(sb.toString());
        br.close();
    }
    static int[][][] dp ;
    public static int digitDp(int idx , String l , String r , int tightL , int tightR ){
        if(idx == l.length()){
            return 0; 
        }
        if(dp[idx][tightL][tightR] != -1){
            return dp[idx][tightL][tightR];
        }
        int res = Integer.MAX_VALUE ; 
        int low = tightL == 1 ? l.charAt(idx) - '0' : 0 ; 
        int high = tightR == 1 ? r.charAt(idx) - '0' : 9 ; 
        for(int i = low ; i <= high ; i++){
            int newCost = (i == l.charAt(idx)-'0' ? 1 : 0) + (i == r.charAt(idx)-'0' ? 1 : 0);
            int newTightL = (tightL == 1 && i == low) ? 1 : 0;
            int newTightR = (tightR == 1 && i == high) ? 1 : 0;
            res = Math.min(res , newCost + digitDp(idx+1 , l , r, newTightL , newTightR ));
        }
        return dp[idx][tightL][tightR] = res ;
    }
}