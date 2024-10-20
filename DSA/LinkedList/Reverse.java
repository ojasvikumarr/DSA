import java.util.LinkedList;

//import java.util.*;

public class Reverse {
    public static class Node{
        int data ;
        Node next ;
        public Node (int data){
            this.data = data ;
            this.next = null ;
        } 
    }

    public static Node head ;
    public static Node tail ;
    public static int size ;
    public void Reversee(){//O(n)
        Node prev = null ;
        Node curr = tail = head ;
        Node next ;

        while ( curr!=null){
            prev = curr ;
            next = curr.next ;
            curr = next ;
            curr.next = prev ;

        }
        head = prev ;
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
    public static void main(String args[]){
        LinkedList ll = new LinkedList();
        // ll.add(1);
        // ll.add(2);
        // ll.add(3);
        // ll.add(4);
        // ll.add(5);
        // ll.Reversee();
        // ll.print();
    }
}
