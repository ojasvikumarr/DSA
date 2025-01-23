package DpOnDigits;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class GoneNumbers {
    static long[][][] dp ; 
    public static void main(String args[]) throws Exception{
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            BigInteger l = sc.nextBigInteger();
            BigInteger r = sc.nextBigInteger();
            String L = (l.compareTo(BigInteger.valueOf(1)) > 0) ?  String.valueOf(l.subtract(BigInteger.valueOf(1))) : "0";
            String R = String.valueOf(r);
            dp = new long[9][2][80];
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

    public static long solve(String s , int idx , boolean tight , int sum){
        if(idx == s.length()){
            if(checkPrime(sum)){
                return 1 ; 
            }
            return 0 ; 
        }
        int flag = tight ? 1 : 0 ;
        if(dp[idx][flag][sum] != 1){
            return dp[idx][flag][sum];
        }
        int limit = tight ? s.charAt(idx) - '0' : 9 ; 
        long ans = 0 ; 
        for(int i = 0 ; i <= limit ; i++){
            ans += solve(s , idx + 1 , tight && (i == s.charAt(idx) - '0') , sum + i) ;
        }
        return dp[idx][flag][sum] = ans ; 
    }
    public static boolean checkPrime(int sum){
        if( sum <= 2 ) return false ;
        for(int i = 2 ; i < sum/2 ; i++){
            if(sum % i == 0){
                return false ;
            }
        }
        return true ;
    }
}
