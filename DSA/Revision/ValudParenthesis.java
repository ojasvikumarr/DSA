package Revision;
import java.util.*;
public class ValudParenthesis {
    public static boolean ValidParas(String str){
        Stack<Character> s = new Stack<>();
        for( int i = 0 ; i<str.length() ; i++ ){
            char ch = str.charAt(i);
            if( ch == '[' || ch == '{' || ch == '('){
                s.push(ch);
            }else{
                if(s.isEmpty()){
                    return false;
                }
                if(s.peek() =='(' && ch == ')'
                || s.peek() =='{' && ch == '}'
                || s.peek() =='[' && ch == ']' ){
                    s.pop();
                }
                else{
                    return false ;
                }
            }
                
        }
        if(s.isEmpty()){
            return true ;
        }
        else{
            return false ;
        }
    }

    public static boolean DuplicateParenthesis(String str){
        Stack<Character> s = new Stack<>();
        for( int i = 0 ; i < str.length() ; i++){
            char ch = str.charAt(i);
            if( ch == ')'){
                int count = 0 ; 
                while(s.peek() != '('){
                    s.pop();
                    count++ ;
                }
                if(count < 1){
                    return true ;
                }else{
                    s.pop();
                }
            }
            else{
                s.push(ch);
            }
        }
        return false ;
    }
    public static void main(String args[]){
        String str = "(({}))";
        String a = "(a+b)+(a+b)";
        System.out.println(ValidParas(str));
        System.out.println(DuplicateParenthesis(a));
    }
}
