package BinaryTrees;

public class Rev5 {
    static class Node{
        int data ;
        Node left , right ;
        public Node( int data ){
            this.data = data ;
            this.left = this.right = null ;
        }
    }
    public static int KthAncestor(Node root , int n , int k){
        if( root == null ){
            return -1 ;
        }
        if( root.data == n ){
            return 0 ;
        }
        int leftdist = KthAncestor(root.left , n , k);
        int rightdist = KthAncestor(root.right , n , k);

        if( leftdist==-1 && rightdist==-1 ){
            return -1 ;
        }
        int max = Math.max(leftdist , rightdist);
        if(max+1 == k){
            System.out.println(root.data);
        }
        return max+1 ;
    }

    public static int Sumtree(Node root){
        if( root == null ){
            return 0 ;
        }
        int left = Sumtree(root.left);
        int right = Sumtree( root.right );
        int val = root.data ;
        root.data = left + right ;
        return val + left + right ;
    }   
    public static void preorder( Node root ){
        if( root == null ){
            return  ;
        }
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }
    public static boolean Univalued( Node root ){
        if( root == null ){
            return  true;
        }
        if(root.left != null && root.data != root.left.data){
            return false ;
        }
       if(root.right != null && root.data != root.right.data){
            return false ;
       }

       return Univalued(root.left) && Univalued(root.right);
    }
    public static void main( String args[] ){
        Node root = new Node(1);
        root. left = new Node(2);
        root. right = new Node(3);
        root.left.left = new Node(4);
        root. left. right = new Node (5);
        root. right. left = new Node(6);
        root. right. right = new Node(7);
        root.left.left.left = new Node(8);
        root.left.left.right = new Node(9);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(11);
        root.right.left.left = new Node(12);
        root.right.left.right = new Node(13);
        root.right.right.left = new Node(14);
        root.right.right.right = new Node(15);
        KthAncestor(root , 4 , 2);
        Sumtree(root);
        preorder(root);
    }
}
