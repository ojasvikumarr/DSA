package BinarySearchTree;
import java.util.* ;
public class R5 {
    static class Node{
        int data ;
        Node left , right ;
        public Node( int data ){
            this.data = data ;
            this.left = this.right = null ;
        }
    }
    public static void inorderSeq(Node root , ArrayList<Integer> inorder){
        if(root == null){
            return ;
        }
        inorderSeq(root.left, inorder);
        inorder.add(root.data);
        inorderSeq(root.right, inorder);
    }
    public static int SuminRange(Node root , int L , int R){
        //converting the balanced bst into a sorted array
        ArrayList<Integer> inorder = new ArrayList<>();
        inorderSeq(root, inorder);
        
        //traversing through the sorted array and adding the values between the range L and R
        int i = 0 ;
        int sum = 0 ;

        while( i < inorder.size() ){
            if(inorder.get(i) >= L && inorder.get(i) <= R)
                sum += inorder.get(i);
            i++ ;
        }

        return sum ;
    }

    public static int minDiff(Node root , int k ){
        ArrayList<Integer> inorder = new ArrayList<>();
        inorderSeq(root, inorder);
        int min = 0 ;
        int currLowest = -1 ;
        // int diff = 0 ;
        for( int i = 0 ; i < inorder.size() ; i++ ){
            if( min >= (inorder.get(i)-k)){
                 currLowest = inorder.get(i);
            }
            // diff = Math.min(min , inorder.get(i) - k);
        }
        // min = Math.min(min , diff);
        return currLowest ;
    }
    public static int KthSmallest(Node root , int k){
        ArrayList<Integer> inorder = new ArrayList<>();
        inorderSeq(root, inorder);
        return inorder.get(k-1);
    }
    public static void main(String args[]){
        Node root = new Node(50);
        root.left = new Node(40);
        root.right = new Node(60);
        root.left.left = new Node(30);
        root.right.left = new Node(55);
        root.right.right = new Node(70);
        System.out.println("Sum is: " +SuminRange(root , 40 , 70));
        System.out.println("The minimum value near it is : "+minDiff(root, 35) );
        System.out.println("The Kth smallest is : "+KthSmallest(root, 4));
    }
}
