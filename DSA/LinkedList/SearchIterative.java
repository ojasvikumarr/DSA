
import java.util.LinkedList;
//import java.util.concurrent.RecursiveAction;

public class SearchIterative {
    public static class Node{
        int data ;
        Node next ;
         public Node ( int data ){
            this.data = data ;
            this.next = null ;
         }
    }
    public static Node head ;
    public static Node tail ;
    public static int i ;
    public int itrSearch( int key ){
        Node temp = head ;
        int i= 0 ;
        while( temp != null ){
            if( temp.data == key ){
                return i ;
            }
            temp = temp.next ;
            i++ ;
        }
    //if key not found then 
        return - 1;
    }
    public int Search( int key ){
        Node temp = head ;
        if(temp == null){
            return Integer.MAX_VALUE ;
        }
        while( temp.data != key ){
            temp = temp.next ;
            i++ ;
        }
        return i ;
    }
    public int helper( Node head , int key ){
        if( head == null ){
            return -1 ;
        }

        if( head.data == key ){
            return 0 ;
        }
        int idx = helper ( head.next , key );
        if(idx == -1 ){
            return -1 ;
        }
        return idx + 1 ;
    }
    public int recSearch(int key ){
        return helper( head , key );
    }
    public static void main( String args []){
        LinkedList ll = new LinkedList();
        // ll.addFirst(1);
        // ll.addFirst(2);
        // ll.addFirst(3);
        // ll.addFirst(4);
        //ll.itrSearch(3);
        //System.out.println(recSearch(2));
    }
}
