package BinaryTrees;

public class LCA2 {
    static class Node{
        int data ;
        Node left ;
        Node right ;
        public Node( int data ){
            this.data = data ;
            this.left = null ;
            this.right = null ;
        }
        public static Node LCA(Node root , int n , int m ){
            if(root == null || root.data == n || root.data == m){
                return root ; 
            }
            Node leftLCA = LCA(root.left, n, m);
            Node rightLCA = LCA(root.right, n, m);

            if(leftLCA == null){
                return rightLCA;
            }
            if(rightLCA == null){
                return leftLCA ;
            }
            return root ;
        }
        public static void main(String args[]){
            Node root = new Node(1);
            root.left = new Node(2);
            root.left.left = new Node(4);
            root.left.right = new Node(5);
            root.right = new Node(3);
            root.right.right = new Node(6);
            System.out.println(LCA(root, 4, 6).data);
        }
    }
}
