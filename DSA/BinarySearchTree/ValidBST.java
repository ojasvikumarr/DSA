package BinarySearchTree;

public class ValidBST {
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
    public static void inorder(Node root){
        if( root == null ){
            return ;
        }
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);

    }
    public static Node Insert(Node root , int val){
        if(root == null){
            root = new Node(val);
            return root ;
        }
        if(root.data>val){
            root.left = Insert(root.left,val);
        }
        if(root.data<val){
            root.right = Insert(root.right, val);
        }
        return root ;
    }

    /*public static boolean Validate(Node root){
        if(root == null){
            return false ;
        }

         Validate(root.left);
         
         if( root.data < root.right.data && root.data > root.left.data){
             return true ;
            }
        Validate(root.right);
            // if(root.left.data < root.data ){
        //     return Validate(root.left); 
        // }
        // else if (root.right.data > root.data){
        //     return Validate(root.right); 
        // }
        // return left && right ;
        return false ;
    }
    */

    public static boolean isValidBST(Node root , Node min , Node max){
        if( root == null ){
            return true ;
        }
        if(min != null && root.data <= min.data){
            return false ;
        }
        else if (max != null && root.data >= max.data){
            return false ;
        }
        return isValidBST(root.left, min , root) && isValidBST(root.right , root, max);
    }
    public static void main(String args[]){
        // int val[] = {8,5,3,6,10,11,14};
        int val[] = {14,8,5,6,3,10,11};
        Node root = null ;
        for(int i = 0 ; i < val.length ; i++){
            root = Insert(root,val[i]);
        }
        inorder(root);
        System.out.println();
        if(isValidBST(root , null , null)){
            System.out.println("BST it is");
        }
        else{
            System.out.println("It's not a BST");
        }
        
        
    }
}
