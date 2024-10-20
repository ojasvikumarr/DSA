package BinarySearchTree;



public class PrintInRange {
    static class Node{
        int data ;
        Node left ;
        Node right ;
        public Node( int data ){
            this.data = data ;
            this.left = null ;
            this.right = null ;
        }
    }
    public static Node BST(Node root , int val){
        if(root == null){
            root = new Node(val);
            return root;
        }
        if(root.data < val){
            root.left = BST(root.right, val);
        }
        if(root.data > val){
            root.right = BST(root.left, val);
        }
        return root ;
    }
    public static void printInRange(Node root , int k , int l){
        if(root == null){
            return ;
        }
        if( root.data <= l && root.data >= k){
            printInRange(root.left, k, l);
            System.out.print(root.data +" ");
            printInRange(root.right, k, l);
        }
        else if(root.data < k){
            printInRange(root.left, k, l);
        }
        else{
            printInRange(root.right, k, l);
        }
    }
    public static void inorder(Node root){
        if(root == null){
            return ;
        }
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }
    public static void main(String args[]){
        int val[] = {8,5,3,1,4,6,10,11,14};
        Node root = null ;
        for( int i = 0 ; i<val.length ; i++){
            root = BST(root, val[i]);
        }
        inorder(root);
        System.out.println();
        printInRange(root, 5, 12);
        System.out.println();
        inorder(root);
    }
}
