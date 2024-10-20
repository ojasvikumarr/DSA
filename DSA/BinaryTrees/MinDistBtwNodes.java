package BinaryTrees;

public class MinDistBtwNodes {
    static class Node{
        int data ;
        Node left ;
        Node right ;
        public Node(int data){
            this.data = data ;
            this.left = null ;
            this.right = null ; 
        }
        public static Node LCa( Node root , int n , int m ){
            if( root == null || root.data == n || root.data == m ){
                return root ;
            }

            Node left = LCa(root.left, n, m);
            Node right = LCa(root.right, n, m);

            if(left == null){
                return right ;
            }
            if(right == null){
                return left ;
            }
            return root ;
        }
        public static int distRoot(Node root , int n){
            if( root == null){
                return -1;
            }
            if( root.data == n){
                return 0 ;
            }
            int leftdist = distRoot(root.left, n);
            int rightdist = distRoot(root.right, n);
            if( leftdist == -1 && rightdist == -1){
                return -1 ;
            }else if(leftdist == -1){
                return rightdist+1 ;
            }else{
                return leftdist+1 ;
            }
            
        }
        public static int MinDistance( Node root , int n , int m){
            if(root == null){
                return - 1;
            }
            Node lca = LCa(root, n, m);
            int dist1 = distRoot(lca , n);
            int dist2 = distRoot(lca, m);
            return dist1 + dist2 ;
        }
        public static void main(String args[]){
            Node root = new Node(1);
            root. left = new Node (2) ;
            root. right = new Node (3) ;
            root. left. left = new Node (4) ;
            root. left.right = new Node (5) ;
            root.right. left = new Node (6) ;
            root.right.right = new Node (7) ;
            System.out.println(MinDistance(root, 4, 6));
        }
    }
}
