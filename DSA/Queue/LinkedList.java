package Queue;

public class LinkedList {
    static class Node{
        int data ;
        Node next ;
        Node( int data ){
            this.data = data ;
            this.next = null ;
        }
    }
    static class Queue{
        static Node head ;
        static Node tail ;
        public boolean isEmpty(){
            return head == tail && tail == null ;
        }
        public void add( int data ){
            Node newNode = new Node(data);
            if(isEmpty()){//head == null 
                head = newNode ;
                tail = newNode ;
                return ;
            }
            tail.next = newNode ;
            tail = newNode ;
        }

        public int remove(){
            if(isEmpty()){
                System.out.println("Empty queue");
                return -1;
            }
            int front = head.data ; // value of front has been stored 
            if(head == tail){
                tail = head = null ;
            }else {
                head = head.next ;
            }
            return front ;
        }
        public int peek(){
            if(isEmpty()){
                System.out.println("Your Queue is empty");
                return - 1;
            }
            return head.data ;
        }
        public void print(Queue q){
            while(!q.isEmpty()){
                System.out.println(q.peek());
                q.remove();
            }
        }
    }

    public static void main( String args[] ){
        Queue q = new Queue();
        // Queue<Integer> qqq = new LinkedList<>();
        // Queue<Integer> qqqq = new ArrayDeque<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.print(q);
        // while(!q.isEmpty()){
        //     System.out.println(q.peek());
        //     q.remove();
        // }
        q.add(10);
        q.add(29);
        q.print(q);
        q.remove();
        q.print(q);
    }
}
