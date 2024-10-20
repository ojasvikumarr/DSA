package BinarySearchTree;



public class SearchBST {
    static class Node{
        int data ;
        Node left ;
        Node right ;
        public Node(int data){
            this.data = data ;
            this.left = null ;
            this.right = null ;
        }
    }
    public static boolean Search(Node root , int k ){
        if(root == null){
            return false ;
        }
        if(root.data == k){
            return true ;
        }
        if(root.data > k){
            return Search(root.left , k);
        }
        if(root.data < k){
            return Search(root.right , k);
        }
        return false;

        // return left || right ;
    }
    public static void main( String args[] ){
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        if(Search(root, 3)){
            System.out.println("Found!!");
        }
        else{
            System.out.println("Not Found!!");
        }
    }
}
