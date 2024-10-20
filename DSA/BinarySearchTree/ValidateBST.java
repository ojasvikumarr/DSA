package BinarySearchTree;

public class ValidateBST {
    static class Node{
        int data ;
        Node left ; 
        Node right ; 
        public Node(int d){
            this.data = d ; 
            this.left = this.right = null ;
        }
    }
    public static boolean ValidBST(Node root , int min , int max){
        if(root == null){
            return true ;
        }
        if(root.data >= min && root.data <= max){
            boolean left = ValidBST(root, min, root.data);
            boolean right = ValidBST(root, root.data, max);
            return left && right ;
        }else{
            return false ;
        }
    }
}
