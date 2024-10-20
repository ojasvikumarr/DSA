import java.util.LinkedList ;

public class Cycle {
    public static class Node {
        int data ;
        Node next ;
        public Node( int data ){
            this.data = data ;
            this.next = null ;
        }
    }
    public static Node head ;
    public static Node tail;

    public boolean isCycle(){
        Node slow = head ;
        Node fast = head ;
        while( fast != null || fast.next != null ){
            slow = slow.next ;
            fast = fast.next.next ;
            if( slow == fast.next ){
                return true ;
            }
            break;
        }
        return false ;
    }
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
    }  
}
