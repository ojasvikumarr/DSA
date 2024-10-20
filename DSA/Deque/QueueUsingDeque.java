package Deque;
import java.util.*;
public class QueueUsingDeque {
    static class Queue{
        static Deque<Integer> d = new LinkedList<>();
        public void add( int data ){
            d.addLast(data);
        }
        public int remove(){
            return d.removeFirst();
        }
        public int peek(){
            return d.getFirst();
        }
    }
    public static void main(String args[]){
        Queue q = new Queue();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        System.out.println("Peek is = " +q.peek());
        System.out.println(q.remove());
        System.out.println(q.remove());
        System.out.println(q.remove());
        System.out.println(q.remove());
        // System.out.println(q.remove());
    }
}
