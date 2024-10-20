package Revision;

public class ZIGZAG {
    public static class Node{
        int data ;
        Node next ;
        public Node(int data){
            this.data = data ;
            this.next  = null ;
        }
    }
    public static Node head ;
    public static Node tail ;

    public static void addFirst(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = tail = newNode ;
            return ;
        }
        newNode.next = head ;
        head = newNode ;
    }
    public static void addLast(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = tail = newNode ;
            return ;
        }

        tail.next = newNode ;
        tail = newNode ;
    }
    public static void print(){
        if(head == null){
            System.out.println("LL is empty!!!");
        }

        Node curr = head ;
        while(curr != null){
            curr = curr.next ;
            System.out.print(curr.data + " -> ");
        }
        System.out.print("null");
    }
    public static void zigzag(){
        Node slow = head ;
        Node fast = head ;
        while( fast != null&& fast.next != null){
            slow = slow.next ;
            fast = fast.next.next ;
        }
        Node mid = slow ;
        //reverse Second half
        Node curr = mid.next;
        mid.next = null ;
        Node prev = null ;
        Node next ;
        while(curr!=null){
            next = curr.next ;
            curr.next = prev ;
            prev = curr ;
            curr = next ;
        }

        Node left = head; 
        Node right = prev ;
        Node nextR,nextL ;

        //alt merge

        while(left != null && right != null){
            nextL = left.next ;
            left.next = right ;
            nextR = right.next;
            right.next = nextL ;
        //updation
            left = nextL ;
            right = nextR ;
        }
    }
    public static void main(String args[]){
        LinkedList ll = new LinkedList();
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(5);
        ll.addLast(6);
        ll.print();
        // ll.zigzag();
        ll.print();
    }
}
