package BinarySearchTree;

public class LCA {
    class Node{
        int data ;
        Node left ;
        Node right ;
        public Node( int data ){
            this.data = data ;
            this.left = null ;
            this.right = null ;
        }
    }
    public Node LCAfind(Node root , Node A , Node B){
        if(root == null) return null ; 
        if(root.data < A.data && root.data < B.data){
            return LCAfind(root.right , A , B);
        }
        if(root.data > A.data && root.data > B.data){
            return LCAfind(root.left , A , B);
        }
        return root ;
    }

    public Node iterativeLCA(Node root , Node A , Node B){
        if(root == null) return null ;
        while(root != null){
            if(root.data > A.data && root.data > B.data){
                root = root.left ;
            }
            if(root.data < A.data && root.data < B.data){
                root = root.left ; 
            }else{
                return root ; 
            }
        }
        return root ;
    }
}
