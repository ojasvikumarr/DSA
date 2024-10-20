package Stacks;
import java.util.*;
public class PushatBottom {
    public static void PushBottom(Stack <Integer> s , int data){
        if(s.isEmpty()){
            s.push(data);
            return ;
        }
        int top = s.pop();//elements are getting stored
        PushBottom(s, data);
        s.push(top);//adding all the elements back
    }

    public static void main(String args[]){
        Stack <Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);

        PushBottom(s, 4);
        System.out.println(s);
        while(!s.isEmpty()){
            System.out.println(s.pop());
        }
    }
}
