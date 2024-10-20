import java.util.*;

public class Palindrome{
    public static class Node{
        int data ;
        Node next ;
        public Node( int data ){
            this.data = data ;
            this.next = null ;
        }
    }
    public static Node head;
    public static Node tail; 

    public Node findMid( Node head ){
        Node slow = head ;
        Node fast = head ;
        while( fast != null || fast.next != null ){
            slow = slow.next ;
            fast = fast.next.next ;
        }
        //slow has become the mid Node 
        return slow ;
    }
    public boolean findPalindrome( Node head ){
        if( head == null || head.next == null){
            return true ;
        }
        //Step 1 : find Mid 
        Node midNode = findMid(head);

        //Step 2 : reverse 2nd half 
        Node prev = null ;
        Node curr = midNode ;
        Node next ;
        while ( curr != null ){
            next = curr.next ;
            curr.next = prev ;
            prev = curr ;
            curr = next ;
        }

        Node Right = prev ;
        Node left = head ;
        while( Right != null ){
            if( Right.data != left.data ){
                return false ;
            }
            left = left.next ;
            Right = Right.next ;
        }
        return true ;
    }
    public static void main( String args[] ){
        LinkedList ll = new LinkedList();
        // ll.add(1);
        // ll.add(2);
        // ll.add(2);
        // ll.add(1);
        //System.out.println(ll.findPalindrome());
    }
}//