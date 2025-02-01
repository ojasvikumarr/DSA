package DynamicProgramming;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ValidNum {
    class Solution {
    public int rotatedDigits(int n) {
        Set<Integer> validDg = new HashSet<>(Arrays.asList(2 , 5 , 6 , 9));
        Set<Integer> invalidDg = new HashSet<>(Arrays.asList(3 , 4 , 7));
        int result = 0 ; 
        for (int num = 1; num <= n; num++) {
            boolean valid = false;
            int temp = num;
            while (temp > 0) {
                int digit = temp % 10;
                if (invalidDg.contains(digit)) {
                    valid = false;
                    break;
                }
                if (validDg.contains(digit)) {
                    valid = true;
                }
                temp /= 10;
            }
            if (valid) {
                result++;
            }
        }
        return result;
    }
    public int solve(String s, int idx , boolean tight , int cnt){
        if(idx == s.length()){
            return cnt; 
        }
        int limit = tight ? s.charAt(idx) - '0' : 9 ; 
        int ans = 0 ; 
        for(int i = 0 ; i <= limit ; i++){
            int newCnt = cnt ;
            if(i == 2 || i == 5 || i == 6 || i == 9){
                newCnt++ ;
            }
            ans += solve(s , idx+1 , tight && i == s.charAt(idx)-'0' , newCnt);
        }
        return ans ; 
    }
}
}
