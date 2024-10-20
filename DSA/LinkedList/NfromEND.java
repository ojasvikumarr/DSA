import java.util.*;
public class NfromEND {

    public static class Node{
        int data ;
        Node next ;
        public Node( int data ){
            this.data = data ;
            this.next = null ;
        }
    }
    public static Node head ;
    public static Node tail ;
    public static int size ;
    public static void NthLast( int n ){
        int sz = 0 ;
        Node temp = head ;
        while ( temp!= null ){
        temp = temp.next ;
        sz++ ;
        }
        if( n == sz ){
            System.out.println( "There is no element in the list" ) ;
        }
        int i = 1 ;
        int p = sz - n ;
        Node prev = head ;
        while(i<p){
            prev = prev.next ;
            i++ ;
        }
        prev.next = prev.next.next ;
        return ;

    }
    public void print(){
        if( head == null ){
            System.out.print("Your LL is empty !!");
            return ;
        }
        Node temp = head ;
        while ( temp != null ){
            System.out.print( temp.data + " ");
            temp = temp.next ;
        }
        System.out.println();
        return ;
    }

    public static void main( String args[] ){
        LinkedList ll = new LinkedList();
        // ll.add(1);
        // ll.add(2);
        // ll.add(3);
        // ll.add(4);
        // ll.add(5);
        // ll.add(6);
        // //ll.NthLast(2);
    }
}
