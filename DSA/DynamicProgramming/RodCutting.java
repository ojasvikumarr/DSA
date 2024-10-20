package DynamicProgramming;

public class RodCutting {
    //Given a rod of length n inches and an array of prices that includes prices of all pieces of size smaller
    //than n determine the maximum value obtainable by cutting up the rod and selling the pieces 

    public static int rodCutting(int length[] , int price[] , int totRod){
        int n = length.length ;
        int dp[][] = new int[n + 1][totRod + 1];
        //java set every element as 0 
        for(int i = 0 ; i < n+1 ; i++){
            for(int j = 0 ; j < totRod+1 ; j++){
                if(i == 0 || j == 0){
                    dp[i][j] = 0 ;
                }
            }
        }

        for(int i = 1 ; i < n+1 ; i++){
            for(int j = 1 ; j < totRod+1 ; j++){
                if(length[i-1] <= j){
                    dp[i][j] = Math.max(price[i-1] + dp[i][j - length[i-1]] , dp[i-1][j]);
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][totRod];
    }
    public static void main(String args[]){
        int length[] = {1 , 2 , 3 , 4, 5, 6 , 7 , 8 };
        int price[] = {1 , 5 , 8 , 9 , 10 , 17 , 17 , 20};
        int totRod = 8; 

        System.out.println(rodCutting(length, price, totRod));
    }

    public static int Recurr(int[] val , int length  , int idx){
        if(idx == 0){
            if(length == 0){
                return 0 ;
            }else{
                return val[0]*(length/1);
            }
        }
        int notPick = Recurr(val, length, idx-1) + 0 ;
        int Pick = Integer.MIN_VALUE ;
        int rodLen = idx+1 ;
        if(length <= rodLen){
            Pick = val[idx] + Recurr(val, length - rodLen, idx-1);
        }
        return Integer.max(Pick , notPick);
    }
    public static int Dp(int[] val , int length  , int idx , int[][] dp){
        if(idx == 0){
            if(length == 0){
                return 0 ;
            }else{
                return val[0]*(length/1);
            }
        }
        if(dp[idx][length] != -1){
            return dp[idx][length];
        }
        int notPick = Recurr(val, length, idx-1) + 0 ;
        int Pick = Integer.MIN_VALUE ;
        int rodLen = idx+1 ;
        if(length <= rodLen){
            Pick = val[idx] + Recurr(val, length - rodLen, idx-1);
        }
        return dp[idx][length] = Integer.max(Pick , notPick);
    }

    public static int Tab(int[] val , int length){
        int[][] dp = new int[val.length][length];
        for(int i = 0 ; i < length ; i++){
            dp[0][i] = (i+1)*val[i];
        }
        for(int idx = 1 ; idx < val.length ; idx++){
            for(int len = 0 ; len < length ; len++ ){
                int notPick = dp[idx-1][len];
                int Pick = Integer.MIN_VALUE ;
                int currLen = idx + 1 ;
                if(len <= currLen){
                    Pick = val[idx] + dp[idx][len];
                }
                dp[idx][len] = Math.max(Pick , notPick);
            }
        }
        return dp[val.length-1][length];
    }

    public static int SpaceOptTab(int[] val , int length){
        int[][] dp = new int[val.length][length];
        int[] prev = new int[length];
        int[] curr = new int[length];

        for(int i = 0 ; i < length ; i++){
            prev[i] = (i+1)*val[i];
        }
        for(int idx = 1 ; idx < val.length ; idx++){
            for(int len = 0 ; len < length ; len++ ){
                int notPick = prev[len];
                int Pick = Integer.MIN_VALUE ;
                int currLen = idx + 1 ;
                if(len <= currLen){
                    Pick = val[idx] + curr[len];
                }
                curr[len] = Math.max(Pick , notPick);
            }
            curr = prev ;
        }
        return prev[length];
    }

    public static int UltiApproach(int[] prices , int n , int idx , int sum){
        //pick and not pick approach of subsquences 
        if(idx == 0){
            if(sum == n){
                
            }
        }
        sum += (idx + 1);
        UltiApproach(prices, n, idx-1, sum);
        sum += (idx - 1);
        UltiApproach(prices, n, idx-1, sum);
    }
}
