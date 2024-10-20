package DynamicProgramming;
import java.util.* ;
public class ChocolateProblem {
    public static int cost(int n, int c, int cuts[]) {
        // Write your code here..
        ArrayList<Integer> cut = new ArrayList<>() ;
        cut.add(0);
        for(Integer i : cuts){
            cut.add(i);
        }
        cut.add(c+1, n);
        return recur(0, c+1, cut);
    }
    public static int recur(int i , int j , ArrayList<Integer> cuts){
        int min = Integer.MAX_VALUE ;
        for(int idx = i ; idx <= j ; idx++){
            int cost = cuts.get(j+1) - cuts.get(i-1) + recur(i, idx-1, cuts) + recur(idx+1, j, cuts);
            if(min > cost) min = cost ;
        }
        return min ;
    }
    public static int Tab(ArrayList<Integer> cuts){
        int[][] dp = new int[cuts.size()][cuts.size()];
        for(int i = cuts.size()-2 ; i > 0 ; i--){
            for(int j = 1 ; j <= cuts.size()-2 ; j++){
                int min = Integer.MAX_VALUE ;
                for(int idx = i ; idx <= j ; idx++){
                    int cost = cuts.get(j+1)-cuts.get(i-1) + dp[i][idx-1] + dp[idx+1][j];
                    if(min > cost) min = cost ;
                }
            }
        }
        return dp[1][cuts.size()-2];
    }
}
