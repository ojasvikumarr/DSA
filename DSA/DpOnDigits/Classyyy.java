package DpOnDigits;
import java.util.*  ;
import java.math.BigInteger ;

public class Classyyy {
    static long[][][] dp ; 
    public static void main(String args[]) throws Exception{
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            BigInteger l = sc.nextBigInteger();
            BigInteger r = sc.nextBigInteger();
            String L = (l.compareTo(BigInteger.valueOf(1)) > 0) ?  String.valueOf(l.subtract(BigInteger.valueOf(1))) : "0";
            String R = String.valueOf(r);
            dp = new long[19][2][5];
            for(long[][] mat : dp){
                for(long[] row : mat) Arrays.fill(row , -1);
            }
            long Big = solve(R , 0 , true , 0)  ;
            for(long[][] mat : dp){
                for(long[] row : mat) Arrays.fill(row , -1);
            }
            long small = solve(L , 0 , true , 0);
            long ans = Big - small ;
            System.out.println(ans);
        }
        sc.close();

    }

    public static long solve(String s , int idx , boolean tight , int cnt){
        if(cnt > 3) return 0 ; 
        if(idx == s.length()){
            if( cnt > 3 ){
                return 0 ; 
            }
            return 1 ; 
        }
        int flag = tight ? 1 : 0 ; 
        if(dp[idx][flag][cnt] != -1) {
            return dp[idx][flag][cnt] ;
        }
        int limit = tight ? s.charAt(idx) - '0' : 9 ; 
        long ans = 0 ; 
        for(int i = 0 ; i <= limit ; i++){
            int newCnt = cnt + (i != 0 ? 1 : 0);
            ans += solve(s , idx+ 1, tight && (i == s.charAt(idx)- '0') , newCnt);
        }
        return dp[idx][flag][cnt] = ans ;
    }
}
