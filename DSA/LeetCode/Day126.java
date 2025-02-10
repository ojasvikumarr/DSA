package LeetCode;

import java.util.Stack;

public class Day126 {
    class Solution {
    public String clearDigits(String s) {
        Stack<Character> st = new Stack<>();
        for(char c : s.toCharArray()){
            int val = (c - '0');
            //check if its a digit
            if(val >= 0 && val <= 9){
                //this is a digit 
                //We'll pop the top of stack 
                if(!st.isEmpty()){
                    st.pop();
                }
            }else{
                //Its an alphabest 
                //Then we'll just put it in the stack 
                st.push(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.peek());
            st.pop();
        }
        return sb.reverse().toString();
    }
}
}
