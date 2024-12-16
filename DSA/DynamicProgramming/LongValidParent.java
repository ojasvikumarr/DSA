package DynamicProgramming;

import java.util.Stack;

public class LongValidParent {
    class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> st = new Stack<>();
        int maxi = 0 ;
        st.push(-1);
        for(int i = 0 ; i < s.length() ; i++){
            if(s.charAt(i) == '('){
                st.push(i);
            }else{
                st.pop();
                if(st.isEmpty()){
                    st.push(i);
                }else{
                    maxi = Math.max(maxi , i - st.peek());
                }
            }
        }
        return maxi ;
    }
}
}
