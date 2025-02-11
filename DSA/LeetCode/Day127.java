package LeetCode;

import java.util.Stack;

public class Day127 {
    class Solution {
    public String removeOccurrences(String txt, String pattern) {
        // int n = txt.length();
        int m = pattern.length();
        Stack<Character> st = new Stack<>();
        for(char c : txt.toCharArray()){
            st.push(c);
            if(st.size() >= m){
                // System.out.println(st.size());
                Stack<Character> hold = new Stack<>();
                int j = m-1 ; 
                while(j >= 0){
                    if(pattern.charAt(j) != st.peek()){
                        break ; 
                    }
                    j-- ; 
                    hold.push(st.peek());
                    st.pop();
                }
                if(j != -1){
                    //That means the string didnt match  , thus we need to 
                    //Push back the elements 
                    while(!hold.isEmpty()){
                        st.push(hold.peek());
                        hold.pop();
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.peek());
            st.pop();
        }
        sb.reverse();
        return sb.toString();
    }
}
}
