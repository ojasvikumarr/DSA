package Queue;

public class Circular {
    static class Queue{
        static int arr[] ;
        static int size ;
        static int rear ;
        static int front ;

        Queue(int n){
            arr = new int[n];
            size = n ;
            rear = -1 ;
            front = -1 ;
        }

        public boolean isEmpty(){
            return rear == -1 && front == -1 ;
        }

        public static boolean isFull(){
            return (rear+1)%size == front ;
        }
        //add
        public void add(int data){
            if(isFull()){
                System.out.println("Queue is empty!!");
                return;
            }
            if(front == -1){
                front++;
            }
            rear = (rear +1)%size ;
            arr[rear] = data ;
        }

        //remove 
        public int remove(){
            if(isEmpty()){
                System.out.println("the Queue is full!!");
                return -1 ;
            }
            int result = arr[front] ;
            if(rear == front){
                rear = front = -1 ;
            }
            else{
                front = (front+1)%size;
            }
            return result ;
        }

        //peek
        public int peek(){
            if( isEmpty()){
                System.out.println("Your Aueue is empty!1");
                return -1 ;
            }
            return arr[front];
        }

    }
    public static void main(String args[]){
        Queue q = new Queue(4);
        q.add(2);
        q.add(4);
        q.add(6);
        q.add(8);
        while(!q.isEmpty()){
            System.out.println(q.peek()+" ");
            q.remove();
        }
    }
}
