package Revision;
import java.util.* ;
import java.util.LinkedList ;
public class Sorting {
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
    
    public static Node getMid(Node head){
        Node slow = head ;
        Node fast = head.next ;
        while(fast!=null && fast.next != null){
            slow = slow.next ;
            fast = fast.next.next ;
        }
        return slow ;
    }

    public static Node merge(Node head , Node head2){
        Node mergedLL = new Node(-1);
        Node temp = mergedLL;

        while(head != null && head2 != null){
            if(head.data <= head2.data){
                temp.next = head ;
                head = head.next ;
                temp = temp.next ;
            }
            else{
                temp.next = head2 ;
                head2 = head2.next;
                temp = temp.next ; 
            }
        }

        while(head != null){
            temp.next = head ;
                head = head.next ;
                temp = temp.next ;
        }
        while(head2 != null){
            temp.next = head2 ;
                head2 = head2.next;
                temp = temp.next ; 
        }
        return mergedLL.next ;
    }
    public static Node MergeSort(Node head){
        if(head == null || head.next == null ){
            return head ;
        }
        Node mid = getMid(head);
        Node rightHead = mid.next ;
        mid.next = null ;
        Node newLeft = MergeSort(head);
        Node newRight = MergeSort(rightHead);
        return merge(newLeft , newRight);

    }
    public static void main(String args[]){
        LinkedList <Integer> ll = new LinkedList<>();
        ll.addFirst(1);
        ll.addFirst(2);
        ll.addFirst(3);
        ll.addLast(18);
        ll.addLast(32);
        ll.addFirst(22);
        head = new Node(1);
        head.next = new Node(3);
        head.next.next = new Node(32);
        head.next.next.next = new Node(83);
        head.next.next.next.next = new Node(23);


    }
}
