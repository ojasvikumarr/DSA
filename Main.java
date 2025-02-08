import java.util.* ; 

public class Main {
        public static void main(String args[]){
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            int[] p = new int[n];
            for(int i = 0 ;i < n; i++) p[i] = sc.nextInt();
            solve(p , n);
            sc.close();
        }
        static class Node{
            int data ; 
            Node next ; 
            Node back ; 
            public Node(int data){
                this.data = data ;
                this.next = this.back = null ; 
            }
        }
        public static void solve(int[] p , int n){
            Node head = new Node(-1);
            Node tail = new Node(-1);
            head.next = tail ;
            tail.back = head ; 

            for(int i = 0 ; i < n; i++){
                int idx = p[i];
                int val = i+1 ; 
                //Now we make the doubly LL 
                int count = 1 ; 
                if(idx > n/2){
                    //we go and start fron back 
                    Node temp = tail ;
                    count = val ; 
                    while(count != idx){
                        temp = temp.back ; 
                        count-- ;
                    }
                    Node newNode = new Node(val);
                    temp.back.next = newNode ; 
                    newNode.next = temp ; 
                    newNode.back = temp.back ; 
                    temp.back = newNode ; 
                }else{
                    //We go from front 
                    Node temp = head ; 
                    count = 1 ; 
                    while(count != idx){
                        temp = temp.next ; 
                        count++ ;
                    }
                    Node newNode = new Node(val);
                    temp.next.back = newNode ; 
                    newNode.next = temp.next ; 
                    newNode.back = temp ; 
                    temp.next = newNode ; 
                }
            }
            Node temp = head.next ; 
            while(temp.data != -1){
                System.out.print(temp.data+" ");
                temp = temp.next ;
            }
            return ; 
        }
    }
   
