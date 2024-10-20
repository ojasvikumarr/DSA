package Queue;
import java.util.*;
public class QueueJFC {
    static class Queue{
        static Stack<Integer> s1 = new Stack<>();
        static Stack<Integer> s2 = new Stack<>();

        public void add(int data){
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }
            s1.push(data);
            while(!s2.isEmpty()){
                s1.push(s2.pop());
            }
        }

        public static int remove(){
            if(s1.isEmpty()){
                return -1 ;
            }
            return s1.pop();
        }

        public static int peek (){
            if(s1.isEmpty()){
                System.out.print("Your queue is empty ");
                return -1 ;
            }
            return s1.peek();
        }

        public void print(Queue q){
            while(!s1.isEmpty()){
                System.out.println(s1.peek());
                s1.pop();
            }
        }
    }public static void main( String args[]){
        Queue q  = new Queue();
        q.add(10);

        q.add(20);

        q.print(q);
        
    }
}
