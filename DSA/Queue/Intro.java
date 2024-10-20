package Queue;

public class Intro {
    static class queue{
        static int arr[] ;
        static int size ;
        static int rear ;
        queue(int n){
            arr = new int[n];
            size = n;
            rear = -1 ;
        }
        public boolean isEmpty(){
            return rear == -1 ;
        }
        //add function 
        public static void add( int data ){
            if( rear == size-1 ){
                System.out.println("Qeueu is full!!!");
                return; 
            }
            rear = rear + 1 ;
            arr[rear] = data ;
        }
        //remove function
        //o(n) it has as each element has to be shifted 
        public int Remove(){
            if(isEmpty()){
                System.out.println("Queue is empty!!");
                return -1;
            }
            int front = arr[0] ;
            for( int i = 0 ; i<rear ; i++){
                arr[i] = arr[i+1];
            }
            rear = rear - 1 ;
            return front ;
        }
        //peek function
        public int peek(){
            // int front = arr[arr.length - 1];
            // return fron t;
            if(isEmpty()){
                System.out.println( " Queue is empty ");
                return -1 ;
            }
            return arr[0];
        }
    }
    public static void main( String args[] ){
        queue q = new queue(5);
        queue.add(1);
        queue.add(2);
        queue.add(3);
        while(!q.isEmpty()){
            System.out.println(q.peek());
            q.Remove();
        }
    }
}
