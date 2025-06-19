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
            int R = solve(b , 0 , 1 , 0);
            for(int[] row : dp) Arrays.fill(row , -1);
            int L = (Integer.parseInt(a) == 0) ? 0 : solve(String.valueOf(Integer.parseInt(a) - 1), 0, 1 , 0);
            // System.out.println("L: " + L + " R: " + R);
            sb.append(R-L);

            sb.append("\n");
        }
        System.out.println(sb.toString());
        br.close();
    }
    static int[][] dp ; 
    public static int solve(String R , int idx , int tight , int sum ){
        if(idx >= R.length()){
            return sum ;
        }
        if(dp[idx][tight] != -1){
            return dp[idx][tight];
        }
        int upperLimit = (tight == 1 ? R.charAt(idx) - '0' : 9);

        int res = 0 ; 
        for(int i = 0 ; i <= upperLimit ; i++){
            int newCost = i ; 
            int newTight = (tight == 1 && i == upperLimit) ? 1 : 0 ;
            res += solve(R , idx + 1 , newTight , sum + newCost);
        }
        return dp[idx][tight] = res ;
    }
    public int numDupDigitsAtMostN(int n) {
        dp = new int[10][2][2][1024];
        for(int[][][] grid : dp){
            for(int[][] mat : grid){
                for(int[] row : mat){
                    Arrays.fill(row , -1);
                }
            }
        }
        String s = String.valueOf(n);
        return solve(s , 0 , 1 , 0 , 0);
    }
    int[][][][]dp ;
    public int solve(String s , int idx , int tight , int repeated , int bitmask){
        if(idx == s.length()){
            if(repeated == 1 && bitmask != 0){
                return 1 ;
            }
            return 0 ;
        }

        if(dp[idx][tight][repeated][bitmask] != -1){
            return dp[idx][tight][repeated][bitmask];
        }
        int upperLimit = tight == 1 ? s.charAt(idx) - '0' : 9 ; 
        int res = 0 ; 
        for(int i = 0 ; i <= upperLimit ; i++){
            int newTight = (tight == 1 && i == s.charAt(idx) - '0' ? 1 : 0);
            if(bitmask == 0 && i == 0){
                res += solve(s , idx+1 , newTight , repeated , bitmask);
            }else if((bitmask & (1<<i)) > 0){//it is repeated thus change the boolean , no need to change bit
                res += solve(s , idx+1 , newTight , 1 , bitmask);
            }else{//not repeated so move on updating the bitmask
                res += solve(s , idx+1 , newTight , repeated , bitmask | (1<<i));
            }
        }
        return dp[idx][tight][repeated][bitmask] = res ;
    }
}