package Stacks;
import java.util.*;
public class ReverseStringusingStack {
    public static String ReverseString( String str){
        Stack<Character> s = new Stack<>();
        int idx = 0 ;
        while(idx<str.length()){
            s.push(str.charAt(idx));
              idx++ ;
        }
        StringBuilder result = new StringBuilder();
        while(!s.isEmpty()){
            char curr = s.pop();
            result.append(curr);
        }
        //str = result.toString();//this function is used so as to assign the value of stringbuilder to a string 
        //better will be to return the string
        return result.toString();
    }
    public static void main(String args[]){
        String str = "abcdefghijklmnopqrstuvwxyz";
        String r = ReverseString(str);
        System.out.println(r);
    }
}
