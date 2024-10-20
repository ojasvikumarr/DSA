package Stacks;
import java.util.*;
public class ReverseStack {
    public static void PushatBottom(Stack <Integer> s , int data){
        if(s.isEmpty()){
            s.push(data);
            return ;
        }
        int top = s.pop();
        PushatBottom(s, data);
        s.push(top);
    }
    public static void Reversestack(Stack <Integer> s){
        if(s.isEmpty()){
            return ;
        }
        int top = s.pop();
        Reversestack(s);
        PushatBottom(s, top);

    }public static void PrintStack(Stack <Integer> s){
        while(!s.isEmpty()){
            System.out.println(s.pop());
        }
    }
    public static void main( String args[ ] ){
        Stack <Integer> s = new Stack<Integer>();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        PrintStack(s);
        //3,2,1
        Reversestack(s);
        PrintStack(s);
        //1,2,3
    }
}
