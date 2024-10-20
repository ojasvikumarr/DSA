//package LinkedList;

import java.util.*;

public class INtro {
    public static class Node{
        int data;
        Node next ;

        public Node ( int data ){
            this.data = data ;
            this.next = null ;
        }
    }
    public static Node head ;
    public static Node tail ;
    public static int size ;
    //methods 
    public void addFirst( int data ){
        //step 1 create new node 
        Node newNode = new Node( data );
        if( head == null ){ // if theres only link int the linked list 
            head = tail = newNode ;
            return ;
            
        }
        size++ ;
        //step 2 newNode next = head
        newNode.next = head ;

        //step 3 head = newNode
        head = newNode ; 
    } 

    public void addLast( int data ){
        Node newNode = new Node( data );
        if(head == null){
            head = tail = newNode ;
            return ;
        }
        size++ ;
        newNode.next = tail ;
        tail = newNode ;
    }

    public void print() {
        
        if( head == null){
            System.out.println( "LL is empty!!");
            return ;
        }
        Node temp = head ;
        while ( temp != null ){
            System.out.print( temp.data+ " ");
            temp = temp.next ;
        }
        System.out.println("null" );
    }

    public void add( int idx , int data ){
        Node newNode = new Node( data );
        Node temp = head ;
        if( idx == 0 ){
            addFirst(data);
            return ;
        }
        size++ ;
        for( int i = 0 ; i < idx-1 ; i++){
            temp = temp.next ;
        }
        newNode.next = temp.next ;
        temp.next = newNode ;
    }

    public int removeFirst(){
        if( size == 0 ){
            System.out.println("LL is empty!!");
            return Integer.MIN_VALUE; //this will return -infinity
        }
        else if( size == 1 ){
            int val = head.data ;
            head = tail= null ;
            size = 0 ;
            return val ;
        }
        size -- ;
        int val = head.data ;
        head = head.next ;
        return val ;
    }

    public int removeLast(){
        if( size == 0 ){
            System.out.println( "LL is empty!!");
            return Integer.MAX_VALUE;
        }
        else if( size == 1){
            int val = head.data; 
            head = tail = null ;
            size = 0 ;
            return val ;
        }
        //prev : i = size - 2
        Node prev = head ;
        for( int i = 0 ; i<size-2 ; i++){
            prev = prev.next ;
        }
        int val = prev.next.data ;
        prev.next = null ;
        tail = prev ;
        size-- ;
        return val ;
    }
    public void addMid(int n , int data){
        if(n == 0 ){
            addFirst(data);
            return ;
        }
        Node newNode = new Node(data);
        Node temp = head ;
        for(int i = 0 ; i<n-1 ; i++ ){
            temp = temp.next ;
        }

        newNode.next = temp.next ;
        temp.next = newNode ;
    }
    public static void main ( String args[]){
        @SuppressWarnings("checked")
        LinkedList ll = new LinkedList();
        ll.add(2 , 9);
        ll.addFirst(1);
        //ll.print();
        ll.addFirst(2);
        ll.addLast(2);
        ll.removeLast();
        ll.removeFirst();
        ll.addLast(4);
        ll.addFirst(199);
        // ll.addMid(2 , 10);
        // ll.print();
        //System.out.println(ll.size);

    }
}

