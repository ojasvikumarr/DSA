package Strings;

import java.util.Stack;

public class convertInteger {
    class Solution {
    public int reverse(int x) {
        int sign = x > 0 ? 1 : -1 ; 

        Stack<Character> st = new Stack<>();
        StringBuilder sb = new StringBuilder(String.valueOf(Math.abs(x)));
        StringBuilder res = new StringBuilder();

        for(int i = 0 ; i < sb.length() ; i++){
            if(sb.charAt(i) == '-') continue ; 
            st.push(sb.charAt(i));
        }
        while(!st.isEmpty() && st.peek() == '0') st.pop();
        while(!st.isEmpty()){
            res.append(st.peek());
            // System.out.println(res);
            st.pop();
        }
        if(res.length() == 0){
            return 0 ; 
        }
        long val = Long.valueOf(res.toString());
        System.out.println(val);
        if(val > Integer.MAX_VALUE){
            return 0 ; 
        }else{
            return sign*(int)val ;
        }
    }
}
}
