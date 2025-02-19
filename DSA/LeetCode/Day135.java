package LeetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Day135 {
    class Solution {
    List<String> result ; 
    public String getHappyString(int n, int k) {
        result = new ArrayList<>();
        // solve(new StringBuilder() , n);
        // solveI(new String() , n);
        solveII(new StringBuilder() , n);
        Collections.sort(result);
        // System.out.println(result);
        return k <= result.size() ? result.get(k-1) : "";
    }
    public void solveII(StringBuilder sb , int n){
        if(n == 0 ){
            result.add(sb.toString());
            return ; 
        }
        for(char c = 'a' ; c <= 'c' ; c++){
            if(sb.length() > 0 && sb.charAt(sb.length()-1) == c) continue ; 
            solveII(sb.append(c) , n-1);
            sb.deleteCharAt(sb.length()-1);
        }
    }
    public void solveI(String s , int n){
        if(n == 0 ){
            result.add(s);
            return ; 
        }
        for(char c = 'a' ; c <= 'c' ; c++){
            if(s.length() > 0 && s.charAt(s.length()-1) == c) continue ; 
            solveI(s + c , n-1);
        }
    }

    public void solve(StringBuilder sb , int n){
        if(n == 0){
            //store sb in result
            result.add(sb.toString());
            return ; 
        }
        if(sb.length() == 0){
            //We'll add all three as 1st 
            for(int i = 0 ; i <= 2 ; i++){
                sb.append((char)(i+'a'));
                solve(sb , n-1);
                sb.deleteCharAt(sb.length()-1);
            }
        }else{
            char c = sb.charAt(sb.length()-1);
            if(c == 'a'){
                //Then can add b or c 
                sb.append('b');
                solve(sb , n-1);
                sb.deleteCharAt(sb.length()-1);
                sb.append('c');
                solve(sb , n-1);
                sb.deleteCharAt(sb.length()-1);
            }else if(c == 'b'){
                //Then can add a or c 
                sb.append('a');
                solve(sb , n-1);
                sb.deleteCharAt(sb.length()-1);
                sb.append('c');
                solve(sb , n-1);
                sb.deleteCharAt(sb.length()-1);
            }else{
                //Then can add a or b 
                sb.append('b');
                solve(sb , n-1);
                sb.deleteCharAt(sb.length()-1);
                sb.append('a');
                solve(sb , n-1);
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }
}
}
