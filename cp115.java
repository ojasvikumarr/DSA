import java.util.* ; 
import java.lang.* ; 
import java.io.* ; 
import java.util.Arrays ;
public class cp115{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String a = st.nextToken();
            String b = st.nextToken();
            dp = new int[b.length() + 1][2];
            for(int[] row : dp) Arrays.fill(row , -1);
            int R = solve(b , 0 , 1);
            for(int[] row : dp) Arrays.fill(row , -1);
            int L = (Integer.parseInt(a) == 0) ? 0 : solve(String.valueOf(Integer.parseInt(a) - 1), 0, 1);
            // System.out.println("L: " + L + " R: " + R);
            sb.append(R-L);

            sb.append("\n");
        }
        System.out.println(sb.toString());
        br.close();
    }
    //only use two tights when same lengths of L and R 
    // public static int solve(String L , String R , int idx , int tightL , int tightR){
    //     if(idx == L.length()){

    //     }
    // }
    static int[][] dp ; 
    public static int solve(String R , int idx , int tight){
        if(idx >= R.length()){
            return 0 ;
        }
        if(dp[idx][tight] != -1){
            return dp[idx][tight];
        }
        int upperLimit = (tight == 1 ? R.charAt(idx) - '0' : 9);

        int res = 0 ; 
        for(int i = 0 ; i <= upperLimit ; i++){
            int newCost = i ; 
            int newTight = (tight == 1 && i == upperLimit) ? 1 : 0 ;
            res += newCost + solve(R , idx + 1 , newTight);
        }
        return dp[idx][tight] = res ;
    }
}