package LeetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Day243 {
    class Solution {
    public String robotWithString(String s) {
        int n = s.length();
        int[] arr = new int[n];
        for(int i = 0 ; i < n ; i++){
            char c = s.charAt(i);
            arr[i] = c-'a';
        }
        //suf arr 
        int[] suffix = new int[n];
        suffix[n-1] = arr[n-1];
        for(int i = n-2 ; i >= 0 ; i--){
            suffix[i] = Math.min(suffix[i+1], arr[i]);
        }

        //now we need to front track it 
        int i = 0 ; 
        int j = 0 ; 
        List<Integer> ls = new ArrayList<>();
        Stack<Integer> st = new Stack<>();
        while(i < n){
            if(arr[i] == suffix[i]){  
                while(!st.isEmpty() && st.peek() <= suffix[i]){
                    ls.add(st.peek());
                    st.pop();
                }  
                ls.add(arr[i]);
                //now we need to backtrack and keep on tracking 
                while(!st.isEmpty() && (i < n-1) &&  st.peek() <= suffix[i+1]){
                    ls.add(st.peek());
                    st.pop();
                }
            }else{
                st.push(arr[i]);
            }
            i++ ; 
        }
        while(!st.isEmpty()){
            ls.add(st.pop());
        }
        StringBuilder sb = new StringBuilder();
        for(int ele : ls){
            sb.append((char)(ele+'a'));
        }
        return sb.toString();

    }
}
}
