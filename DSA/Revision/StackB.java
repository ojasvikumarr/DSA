package Revision;
import java.util.ArrayList ;
import java.util.Stack;
public class StackB {
    static class StackAl{
        static ArrayList<Integer> list = new ArrayList<>();
        public static boolean isEmpty(){
            return list.size() == 0 ;
        }
        //push
        public static void push(int data){
            list.add(data);
        }
        //pop
        public static int pop(){
            if(isEmpty()){
                return -1 ;
            }
            int top = list.get(list.size()-1);
            list.remove(list.size()-1);
            return top ;
        }
        //peek
        public static int peek(){
            if(isEmpty()){
                return -1 ;
            }
            return list.get(list.size()-1);
        }
    
        static class Node{
            int data ;
            Node next ;
            Node(int data){//this is the constructor 
                this.data = data ;
                this.next = null ;
            }
        }

        static class StackLL{
            static Node head = null ;

            public static boolean isEmptyy(){
                return head == null ;
            }

            //push
            public static void push(int data){
                Node newNode = new Node( data );
                if(isEmptyy()){
                    head = newNode ;
                    return;
                }

                newNode.next  = head ;
                head = newNode;
            }

            //pop
            public static int pop(){
                if(isEmptyy()){
                    return -1 ;
                }
                int top = head.data;
                head = head.next ;
                return top ;
            }

            //peek
            public static int peek(){
                return head.data ;
            }
        }

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        //push at the bottom

        public static void pushAtBottom(Stack<Integer> s , int data){
            if(s.isEmpty()){
                s.push(data);
                return ;
            }
            int top = s.pop();
            pushAtBottom(s, data);
            s.push(top);
        }

        //Reverse a String using Stack 

        public static String ReverseS(String s){
            Stack<Character> ss = new Stack<>();
            int idx = 0 ;
            while(idx < s.length() ){
                ss.push(s.charAt(idx));
                idx++ ;
            }

            StringBuilder result = new StringBuilder("");

            while(!ss.isEmpty()){
                // char curr = ss.pop();
                result.append(ss.pop());
            }
            // s = result.toString();
            return result.toString() ;
        }

        public static void ReverseAStack(Stack<Integer> s){
            ArrayList<Integer> Al = new ArrayList<>();
            while(!s.isEmpty()){
                Al.add(s.pop());
            }
            int idx = 0 ;
            while(idx < Al.size()){
                s.push(Al.get(idx++ ));
            }
        }

        public static void ReverseRecursion(Stack<Integer> s){
            if(!s.isEmpty()){
                return ;
            }

            int top = s.pop();
            ReverseRecursion(s);
            pushAtBottom(s, top);
        }
        public static void main( String args[] ){
            StackAl s = new StackAl();
            // s.push(1);
            // s.push(2);
            // s.push(3);
            // while(!s.isEmpty()){
            //     System.out.println(s.peek());
            //     s.pop();
            // }

            StackLL sLL = new StackLL();
            // sLL.push(1);
            // sLL.push(2);
            // sLL.push(3);
            // sLL.push(4);
            // while(!sLL.isEmptyy()){
            //     System.out.println(sLL.peek());
            //     sLL.pop();
            // }

            Stack<Integer> S = new Stack<>();
            S.push(1);
            S.push(2);
            S.push(3);
            S.push(4);
            // pushAtBottom(S,32);
            // while(!S.isEmpty()){
            //     System.out.println(S.pop());
            // }

            String str = "Hello";
            System.out.println(ReverseS(str));

            ReverseAStack(S);
            while(!S.isEmpty()){
                System.out.println(S.pop());
            }
        }
    }
}
