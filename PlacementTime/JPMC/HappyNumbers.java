package PlacementTime.JPMC;

import java.util.HashSet;
import java.util.Set;

public class HappyNumbers {
    class Solution {
    public boolean isHappy(int n) {
        Set<Long> set = new HashSet<>();
        StringBuilder sb = new StringBuilder(String.valueOf(n));
        while(sb.length() != 0 ){
            long sum = 0 ;
            for(char c : sb.toString().toCharArray()){
                sum += (c-'0')*(c-'0');
            }
            if(sum == 1){
                return true ;
            }else if(set.contains(sum)){
                return false ; 
            }
            set.add(sum);
            sb = new StringBuilder(String.valueOf(sum));
        }
        return true ;
    }
}
}
