package BinarySearchTree;

public class BuildingBST {
    static class Node{
        int data ;
        Node left ;
        Node right ;
        public Node(int data){
            this.data = data ;
            this.left = this.right = null ;
        }
    }
    public static void inorder(Node root){
        if( root == null ){
            return ;
        }
        inorder(root.left);
        System.out.println(root.data);
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
    public static void main(String args[]){
        int value[] = {5,1,3,4,2,7};
        Node root = null ;
        for(int i = 0 ; i < value.length ; i++){
            root = Insert(root,value[i]);
        }
        inorder(root);
    }
}
