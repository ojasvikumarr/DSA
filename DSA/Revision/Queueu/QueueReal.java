package Revision.Queueu;
import java.util.* ;
public class QueueReal {

    static class QUeue{
        static Stack<Integer> s1 = new Stack<>();
        static Stack<Integer> s2 = new Stack<>();

        public static boolean isEmpty(){
            return s1.isEmpty();
        }

        public static void add(int data){
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }

            s2.push(data);

            while(!s2.isEmpty()){
                s1.push(s2.pop());
            }
        }


        public static int remove(){
            if(!s1.isEmpty()){
                System.out.println("Your Queue is Empty!");
                return -1 ;
            }
            return s1.pop();
        }

        public static int peek(){
            if(!s1.isEmpty()){
                System.out.println("Your Queue is Empty!");
                return -1 ;
            }
            return s1.peek();
        }

    }

    public static void printNonRepeating(String str){
        int freq[] = new int[26];
        Queue<Character> q = new LinkedList<>();

        for( int i = 0 ; i< str.length() ; i++){
            char ch = str.charAt(i);
            q.add(ch);
            freq[ch - 'a']++ ;

            while(!q.isEmpty() && freq[q.peek() - 'a']>1){
                q.remove();
            }

            if(q.isEmpty()){
                System.out.print(-1+" ");
            }else{
                System.out.print(q.peek() +" ");
            }
        }
    }

    public static void interLeave( Queue<Integer> q ){
        Queue<Integer> firsthalf = new LinkedList<>();
        int size = q.size();
        for(int i = 0 ; i < size/2 ; i++ ){
            firsthalf.add(q.remove());
        } 
        while(!firsthalf.isEmpty()){
            q.add(firsthalf.remove());
            q.add(q.remove());
        }

    }

    public static void main(String args[]){
        // Queue<Integer> q = new LinkedList<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        queue.add(6);
        queue.add(7);
        queue.add(8);
        queue.add(9);
        queue.add(10);

        interLeave(queue);
        while(!queue.isEmpty()){
            System.out.print(queue.remove()+" ");
        }
        
    }   
}
