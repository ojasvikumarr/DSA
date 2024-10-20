package BinaryTrees;
import java.util.*;
public class Rev4 {
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

    public static void KthLevel(Node root , int k){
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while( !q.isEmpty()){
            Node currNode = q.remove();
            if(currNode == null){
                //System.out.println();
                if(q.isEmpty()){
                    break;
                }
                else{
                    q.add(null);
                }
                k--;
            }
            else{
                   if(k==1){ System.out.print(currNode.data+" ");}
                
                if(currNode.left !=null){
                    q.add(currNode.left);
                }
                if(currNode.right != null){
                    q.add(currNode.right);
                }
            }
        }
    }

    public static void Klevel(Node root , int level , int k){
        if(root == null){
            return ;
        }
        if(level == k){
            System.out.print(root.data +" ");
        }
        Klevel(root.left , level+1 , k);
        Klevel(root.right , level+1 , k);
    }
    public static boolean getpath( Node root , int n , ArrayList< Node >path){
        if( root == null ){
            return false ;
        }
        path.add(root);

        if( root.data == n ){
            return true ;
        } 
        boolean foundLeft = getpath(root.left , n , path);
        boolean foundRight = getpath(root.right , n , path);
        if( foundLeft || foundRight){
            return true ;
        }

        path.remove(path.size() - 1);
        return false ;
    }

    public static int lcaDist(Node root, int n){
        if( root == null ){
            return -1 ;
        }
        if( root.data == n ){
            return 0 ;
        }
        int leftDist = lcaDist(root.left , n);
        int rightDist = lcaDist(root.right , n);
        if(leftDist == -1 && rightDist == -1 ){
            return -1 ;
        }
        else if ( leftDist == -1){
            return rightDist ;
        }
        else{
            return leftDist ;
        }
    }
    public static Node Lca( Node root, int n1 , int n2 ){
        ArrayList<Node> path1 = new ArrayList<>();
        ArrayList<Node> path2 = new ArrayList<>();
        getpath(root , n1 , path1);
        getpath(root , n2 , path2);
        int i = 0 ; 
        for(; i <path1.size() && i < path2.size() ; i++ ){
            if( path1.get(i) != path2.get(i) ){
                break ;
            }
        }
        Node lca = path1.get(i-1);
        return lca; 
    }

    public static Node lca2(Node root , int n1 , int m){
        
        if( root == null || root.data == n1 || root.data == m ){
            return root ;
        }

        Node leftLca = lca2(root.left , n1 , m);
        Node rightLca = lca2(root.right , n1 , m);
        if(leftLca == null){
            return rightLca ;
        }
        if(rightLca == null){
            return leftLca ;
        }
        return root ;
    }

    public static int minDist( Node root , int n , int m ){
        Node lca = lca2(root, n , m);
        int dist1 = lcaDist(lca , n);
        int dist2 = lcaDist(lca , m);

        return (dist1 + dist2) ;
    }
    
    public static void main( String args[] ){
        Node root = new Node(1);
        root.left = new Node( 2);
        root.right = new Node(3);
        root.left.left = new Node( 4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        KthLevel(root, 3);
        System.out.println();
        Klevel(root, 1 ,3);
    }
}
