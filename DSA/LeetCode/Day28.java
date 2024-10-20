import java.util.Stack;
import java.util.* ;
public class Day28 {
    public static void ValidParenthesis(String s){
        char[] c = s.toCharArray() ;
        Stack<Character> st = new Stack<>();
        for(int i = 0 ; i < c.length ; i++){
            if(c[i] == '('){
                st.push(c[i]);
            }else if(c[i] == ')'){
                if(st.peek() == '('){
                    st.pop();
                }else{
                    st.push(c[i]);
                }
            }
        }
        StringBuilder sb = new StringBuilder(s);
        for(int z = 0 ; z < sb.length() ; z++){
            if(sb.charAt(z) == st.peek()){
                sb.delete(z-1 , z);
            }
            z = Math.max(z-1 , -1);
        }
        return sb.toString() ;
    }
}
