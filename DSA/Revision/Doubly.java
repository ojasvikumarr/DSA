package Revision;

public class Doubly {
    public static class Node{
        int data  ;
        Node next ;
        Node prev ;
        public Node(int data){
            this.data = data ; 
            this.prev = null ;
            this.next = null ;
        }
    }
    public static Node head ;
    public static Node tail ;
    public static int size ;

    //add
    public void addFirst(int data){
        Node newNode = new Node(data);
        size++;
        if( head == null ){
            head = tail = newNode ;
            return ;
        }

        newNode.next = head ;
        head.prev = newNode ;
        head = newNode ;
        
    }

    public Node removeFirst(){
        if( head == null ){
            System.out.println("Your LL is empty!");
        }

        if(size == 1){
            Node val = head ;
            head = tail = null ;
            size-- ;
            return val ;
        }
        Node val = head ;
        head = head.next ;
        head.prev = null ;
        size-- ;
        return val ;
    }
    public void print(){
        Node curr = head ;
        while( curr != null ){
            System.out.print(curr.data + " <-> ");
            curr = curr.next ;
        }
        System.out.print("null");

    }
    public Node removeLast(){
        if(head == null){
            System.out.println("Your LL is empty!");
        }
        if(size == 1){
            Node val = head ;
            head = tail = null ;
            size-- ;
            return val ;
        }
        Node val = tail ;
        tail = tail.prev ;
        tail.next = null ;
        size-- ;
        return val ;
    }

    public void reverse(){
        Node curr = head ;
        Node prev = null ;
        Node next ;
        while( curr != null ){
            next = curr.next ;
            curr.next = prev ;
            curr.prev = next ;
            prev = curr ;
            curr = next ;
        }
        head = prev ;
    }
    public static void main( String agrs[]){
        Doubly dll = new Doubly();
        dll.addFirst(1);
        dll.addFirst(2);
        dll.addFirst(3);
        dll.print();
        dll.removeFirst();
        System.out.println();
        // System.out.println(dll.size);
        dll.addFirst(12);
        dll.addFirst(13);
        dll.print();
        dll.reverse();
        // System.out.println(dll.size);
        dll.print();
    }
}
