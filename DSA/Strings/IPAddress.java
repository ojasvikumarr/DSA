package Strings;

import java.util.ArrayList;
import java.util.List;

public class IPAddress {
    class Solution {
    List<String> ans ;
    public List<String> restoreIpAddresses(String s) {
        ans = new ArrayList<>();
        // solve(s , 1 , 0 , 4 , new StringBuilder());
        solveII(s , 0 , 0 , new StringBuilder());
        return ans ;
    }

    public void solveII(String s , int idx ,int count , StringBuilder sb){
        if(idx == s.length() && count == 4){
            ans.add(sb.toString());
            return ;
        }

        if(count > 4 || idx >= s.length()) return ; 

        for(int i = 1 ; i <=3  && idx+i <=s.length() ; i++){
            String part = s.substring(idx , idx+i);
            int val = Integer.valueOf(part);

            if(val > 255 || (part.length() > 1 && part.startsWith("0"))) continue ;

            int prevLength = sb.length();
            if(count > 0) sb.append(".");
            sb.append(part);

            solveII(s , idx+i , count+1 , sb);

            sb.setLength(prevLength);
        }
    }
    public void solve(String s , int idx , int prev , int count , StringBuilder sb){
        if(idx == s.length()+1){
            if(count == 0){
                ans.add(sb.toString());
            }
            return ;
        }
        //pick 
        int len = s.substring(prev , idx).length() ;
        if(len > 3) return ;
        int val = Integer.valueOf(s.substring(prev , idx));
        if(val <= 255 && count > 0){
            if(String.valueOf(val).length() < len) return ;
            sb.append(String.valueOf(val));
            if(count != 1) sb.append(".");
            if(idx+1 < s.length())
            solve(s , idx+1 , idx , count-1, sb) ;
        }
        solve(s , idx+1 , prev , count , sb);
    }

}
}
