package Revision;
import java.util.* ;
public class LinkedList {

    public static class Node{
        int data ; 
        Node next ; 
        public Node(int data){
            this.data = data ; 
            this.next = null ;
        }
    }

    public static Node head ;
    public static Node tail ;

    public void addFirst (int data){
        Node newNode = new Node(data);
        if( head ==null){
            head = tail = newNode ;
            return ;
        }
        newNode.next = head ;

        head = newNode ;
    }
    public void addLast(int data){
        Node newNode = new Node(data) ;
        if(tail == null){
            head = tail = newNode ;
            return ;
        }
        // newNode.next = null ;
	    tail.next = newNode ;
        tail = newNode ;

    }

    public void print(){
        if( head == null){
            System.out.println("ll is empty");
            return ;
            
        }
        Node temp = head ;
        while( temp != null ){
            System.out.print(temp.data+"-> ");
            temp = temp.next ;
        }

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

    public void Size(){
        int count = 0 ;
        Node temp = head ;
        while(temp != null ){
            count++ ;
            temp = temp.next ;
        }
        System.out.println("The size of the LL is "+count);
    }
    public int removeFirst(){
        if( head == null ){
            System.out.println("The LL is Empty!!");
        } 
        int val = head.data ;
        head = head.next ;
        return val ;
    }
    public int removeLast(){
        if(head == null){
            System.out.println("The LL is empty!!");
        }
        int val = tail.data ;
        Node temp = head ;
        while(temp.next.next != null ){
            temp = temp.next ;
        }
        tail = null ;
        temp = tail ;
        return val ;

    }

    public int Search(int key){
        Node temp = head ;
        int i = 0 ;
        while (temp != null){
            if(temp.data == key){   
                return i ;
            }
            temp = temp.next ;
            i++ ;
        }
        return -1 ;
    }
    public int helper(Node head , int key ){
        if( head==null){
            return -1 ;
        }
        if(head.data == key){
            return 0 ;
        }
        int idx = helper(head.next , key);
        if(idx ==-1){
            return -1 ;
        }
        return idx+1 ;

    }
    public int recSearch(int key){
        return helper(head,key);
    }

    public void ReverseLL(){
        Node prev = null ;
        Node curr = tail = head ;
        Node next ;

        while( curr != null ){
            next = curr.next ;
            curr.next = prev ;
            prev = curr ;
            curr = next ;
        }

    }

    public void BackDead( int n ){
        //calculate size 
        int size = 0 ;
        Node temp = head ;
        while( temp != null){
            temp = temp.next ;
            size ++ ;
        }

        if( n == size){
            head = head.next ;
            return ;
        }

        int i =  1; 
        int iTofind = size-n ;
        Node prev = head ;
        while(i < iTofind){
            prev = prev.next ;
            i++ ;
        }
        prev.next = prev.next.next ;
        return ;
    }
    public boolean checkPalindrom(){{
        if( head == null || head.next == null){
        return true ;
        }
        //step1  - find the mid 
        Node midNode = findMid(head);
        //step1 - reverse 2nd half 
        Node prev = null ;
        Node curr = midNode ;
        Node next ;
        while(curr != null){
            next = curr.next ;
            curr.next = prev ;
            prev = curr ;
            curr = next ;
        }

        Node right = prev; 
        Node left = head ;
        //step3 - check left half & right  half
        while(right != null){
            if(left.data != right.data){
                return false ;
            }
            left = left.next ;
            right = right.next ;
        }
        return true ;
    }}
    public Node findMid(Node head){
        Node slow = head ;
        Node fast = head ;

        while( fast != null && fast.next != null ){
            slow = slow.next ;
            fast = fast.next.next ;
        }
        return slow ;
    }
    
    ////////////////////////////////////////////////////////////////////////        

    public static boolean isCycle(){//Floy's cycle 
        Node slow = head; 
        Node fast = head ;
        while(fast != null && fast.next != null){
            slow = slow.next ;
            fast = fast.next.next;
            if(slow == fast){
                return true ;
            }
        }
        return false ;
    } 

    public static void RemoveCycle(){
        Node slow = head ;
        Node fast = head ;

        boolean cycle = false ;
        while(fast != null && fast.next != null){
            slow = slow.next ;
            fast = fast.next.next ;
            if(slow == fast){
                cycle = true ;
                break ;
            }
        }
        if(cycle == false){
            return ;
        }

        slow = head ;
        Node prev = null ;
        while(slow != fast){
            prev = fast ;
            slow = slow.next ;
            fast = fast.next ;
        }
        prev.next = null ;
    }

    //palindrome 
    public static boolean Palidromeisit(Node head){
        Node slow = head ;
        Node fast = head ;
        while( fast != null && fast.next != null ){
            slow = slow.next ;
            fast = fast.next.next ;
        }

        Node curr = slow ;
        Node prev = null ;
        Node next ;
        while( curr != null ){
            next = curr.next ;
            curr.next = prev ;
            prev = curr ;
            curr = next ;
        }

        Node left = head ;
        Node right = prev; 

        while( right != null ){
            if(left.data != right.data){
                return false ;
            }
        }
        return true ;
    }

    public static String Decoder(String str){
        Stack<Integer> IntegerStack = new Stack<>();
        Stack<Character> CharacterStack = new Stack<>();

        String temp ="" , result ="";

        for( int i = 0 ; i < str.length() ;i++){
            int count = 0 ;
            if(Character.isDigit(str.charAt(i))){
                while(Character.isDigit(str.charAt(i))){
                    count = count*10 + str.charAt(i) -'0';
                    i++;
                }
                i--;
                IntegerStack.push(count);
            }
            else if(str.charAt(i) == ']'){
                temp="";
                count = 0 ;
                if(!CharacterStack.isEmpty() && CharacterStack.peek() !='['){
                    temp += CharacterStack.peek() ;
                    CharacterStack.pop();
                }
                if(!CharacterStack.isEmpty() && CharacterStack.peek() =='['){
                    CharacterStack.pop();
                    for(int j = 0 ; j < count ; j++){
                        result += temp ;
                    }
                    for(int j = 0 ; j< result.length() ;j++){
                        CharacterStack.push(result.charAt(j));
                        result="";
                    }
                }
                else if(str.charAt(i)== '['){
                    if(Character.isDigit(str.charAt(i-1))){
                        CharacterStack.push(str.charAt(i));
                    }
                    else{
                        CharacterStack.push(str.charAt(i));
                        IntegerStack.push(1);
                    }
                }
                else{
                    CharacterStack.push(str.charAt(i));
                }
            }
        }
        while(!CharacterStack.isEmpty()){
            result = CharacterStack.peek() + result ;
            CharacterStack.pop();
        }
        return result ;
    }
    public static void main(String args[]){
        LinkedList ll = new LinkedList();
        ll.addFirst(1);
        ll.addFirst(2);
        ll.addFirst(3);
        ll.addFirst(4);
        // ll.print();
        ll.addMid(2  ,10);
        ll.print();
        System.out.println();
        ll.Size();
        ll.removeLast();
        ll.print();
        System.out.println();
        System.out.println(ll.Search(2));
        System.out.println(ll.recSearch(2));


        head = new Node(1);
        Node temp = new Node(2);
        head.next = temp ;
        head.next.next = new Node(3);
        head.next.next.next = temp ;
        System.out.println(isCycle());

        RemoveCycle();
        System.out.println(isCycle());
        String str = "3[b2[ca]]";
        System.out.println(Decoder(str));
    }
    
}
