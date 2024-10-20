package BinarySearchTree;

public class MirrorBST {
    static class Node{
        int data ;
        Node left ;
        Node right ;
        public Node(int data){
            this.data = data ;
        }
    }
    public static Node insert(Node root , int val){
        if(root == null){
            root = new Node(val);
            return root ;
        }
        if(root.data > val){
            root.left = insert(root.left , val);
        }
        if(root.data < val){
            root.right = insert(root.right, val);
        }
        return root ;
    }
    public static void inorder(Node root){
        if( root == null ){
            return ;
        }
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }
    /*public static Node MirrorBst(Node root){
        if(root == null){
            return null ;
        }
        MirrorBst(root.left);
        Node temp = root.left;
        root.left = root.right ;
        root.right = temp ;
        MirrorBst(root.right);
        return root ;
    }
    */

    public static Node CreateMirror(Node root){
        if(root == null){
            return null ;
        }

        Node leftMirror = CreateMirror(root.left);
        Node rightMirror = CreateMirror(root.right);

        root.left = leftMirror;
        root.right = rightMirror;
        return root ;
    }
    public static void preorder(Node root){
        if( root == null ){
            return  ;
        }
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }
    public static void main( String args[] ){
        int val[] = {8 , 5, 6 , 3, 10 , 11};
        Node r = null ;
        for(int i = 0 ; i<val.length ; i++ ){
            r = insert(r,val[i]);
        }
        inorder(r);
        // Node a = root ;
        // Node rrr = null ;
        // for(int j = 0 ; j<val.length ; j++){
        //      rrr = MirrorBst(a);
        // }
        // System.out.println();
        // inorder(rrr);
            Node root = new Node(8);
            root.left = new Node(5);
            root.right = new Node(10);
            root.left.left = new Node(3);
            root.left.right = new Node(6);
            root.right.right = new Node(11);
        root = CreateMirror(root);
        System.out.println();
        inorder(root);
        System.out.println();
        preorder(root);

    }
}
