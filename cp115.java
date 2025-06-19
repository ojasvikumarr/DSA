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
    class Solution {
    private int min_sum ; 
    private int max_sum ;
    private int MOD ; 
    public int count(String num1, String num2, int min_sum, int max_sum) {
        this.min_sum = min_sum ; 
        this.max_sum = max_sum ; 
        MOD = (int)1e9 + 7 ; 

        String L = num1;
        String R = num2;


        dp = new int[L.length()+1][2][199];
        for(int[][] mat : dp){
            for(int[] row : mat){
                Arrays.fill(row , -1);
            }
        }

        int lowerRes = solve(L , 0 , 1 , 0)%MOD;

        dp = new int[R.length()+1][2][199];
        for(int[][] mat : dp){
            for(int[] row : mat){
                Arrays.fill(row , -1);
            }
        }

        int upperRes = solve(R , 0 , 1 , 0)%MOD;

        int sum = 0 ; 
        for(char c : L.toCharArray()){
            sum += c - '0';
        }
        if(sum >= min_sum && sum <= max_sum){
            sum = 1 ;
        }else{
            sum = 0 ; 
        }
        return (upperRes - lowerRes + sum + MOD)%MOD ;
    }
    int[][][] dp ;
    public int solve(String s, int idx , int tight , int sum ){
        if(idx == s.length()){
            if(sum >= min_sum && sum <= max_sum){
                return 1 ;
            }
            return 0 ;
        }
        if(dp[idx][tight][sum] != -1){
            return dp[idx][tight][sum] ;
        }
        int upperLimit = (tight == 1 ? s.charAt(idx) - '0' : 9);
        int res = 0; 
        for(int i = 0 ; i <= upperLimit ; i++){
            int newTight = (tight == 1 && i == upperLimit ? 1 : 0);
            res = (res + solve(s , idx+1 , newTight , sum + i))%MOD;
        }
        return dp[idx][tight][sum] = res%MOD ; 
    }
}
class SolutionIv {


    public int jobScheduling(int[] start, int[] end, int[] profit) {
        int n = start.length ;

        int[][] schedule = new int[n][3];
        for(int i = 0 ; i < n ; i++){
            schedule[i][0] = start[i];
            schedule[i][1] = end[i];
            schedule[i][2] = profit[i];
        }

        Arrays.sort(schedule , (a , b) -> a[0] - b[0]);

        memo = new int[n+1];
        Arrays.fill(memo , -1);
        return solveII(schedule , 0);
    }
    int[] memo ; 
    public int solveII(int[][] sch , int idx){
        if(idx >= sch.length){
            return 0 ;
        }
        if(memo[idx] != -1){
            return memo[idx];
        }
        int next = bsIdx(sch , idx);
        int pick = sch[idx][2] + solveII(sch , next);
        int skip = solveII(sch ,idx+1);
        return memo[idx] = Math.max(pick , skip);
    }
    public int bsIdx(int[][] sch , int idx){
        int l = idx+1 ; 
        int r = sch.length-1 ; 
        int res = 0 ; 
        while(l <= r){
            int mid = l + (r-l)/2 ;
            if(sch[mid][0] >= sch[idx][1]){
                res = mid ; 
                r = mid-1 ;
            }else{
                l = mid + 1;
            }
        }
        return l ;
    }
    public int jobSchedulingII(int[] start, int[] end, int[] profit) {
        int n = start.length ;

        int[][] schedule = new int[n][3];
        for(int i = 0 ; i < n ; i++){
            schedule[i][0] = start[i];
            schedule[i][1] = end[i];
            schedule[i][2] = profit[i];
        }

        Arrays.sort(schedule , (a , b) -> a[0] - b[0]);

        int[] tab = new int[n+1];
        tab[n-1] = schedule[n-1][2];

        for(int i = n-2 ; i >= 0 ; i--){
            for(int endIdx = i+1 ; endIdx < n ; endIdx++){
                if(schedule[endIdx][0] >= schedule[i][1]){
                    tab[i] = Math.max(schedule[i][2] + tab[endIdx] , tab[i+1]);
                }
            }
            tab[i] = Math.max(schedule[i][2] , tab[i+1]);
        }
        return tab[0];
    }


    public int jobSchedulingI(int[] start, int[] end, int[] profit) {
        int n = start.length ;

        dp = new int[n+1][n+1];
        for(int[] row : dp) Arrays.fill(row , -1);
        
        int[][] schedule = new int[n][3];
        for(int i = 0 ; i < n ; i++){
            schedule[i][0] = start[i];
            schedule[i][1] = end[i];
            schedule[i][2] = profit[i];
        }

        Arrays.sort(schedule , (a , b) -> a[0] - b[0]);

        return solve(0 , n , schedule);
    }
    int[][] dp ; 
    public int solve(int idx , int endTimeIdx , int[][] sch){
        if(idx == sch.length){
            return 0 ;
        }
  
        if(dp[idx][endTimeIdx] != -1){
            return dp[idx][endTimeIdx];
        }

        int pick = 0 ; 
        if(endTimeIdx == sch.length || sch[endTimeIdx][1] <= sch[idx][0] ){
            pick = sch[idx][2] + solve(idx+1 , idx , sch);
        }

        int notpick = 0 + solve(idx + 1, endTimeIdx , sch);

        return dp[idx][endTimeIdx] = Math.max(pick , notpick) ;
    }
}
}