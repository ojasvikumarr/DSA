package BinaryTrees;
import java.util.*;
public class LowestCommonAncestor {
    static class Node{
        int data;
        Node left ;
        Node right ;
        public Node (int data){
            this.data = data ;
            this.left = null ;
            this.right = null ;
        }
    }
    public static boolean getpath(Node root , int n , ArrayList<Node> path){
        if(root == null){
            return false ;
        }
        path.add(root);
        if(root.data == n ){
            return true ;
        }
        boolean foundLeft = getpath(root.left, n, path);
        boolean foundRight = getpath(root.right, n, path);
        
        if(foundLeft || foundRight){
            return true ;
        }

        path.remove(path.size()-1);
        return false ;
    }
    public static Node LCA(Node root , int n , int m){
        ArrayList<Node> path1 = new ArrayList<>();
        ArrayList<Node> path2 = new ArrayList<>();
        getpath(root, n, path1);
        getpath(root, m, path2);
        int i = 0 ;//the i is declared outside because it is also used outside the loop so as to save space of making a variable
        for( ; i<path1.size() && i < path2.size() ; i++){
            if(path1.get(i) != path2.get(i)){
                break ;
            }
        }

        Node lca = path1.get(i-1);
        return  lca ;
        // System.out.println(path1.get(i-1));
    }
    public static void main( String args[] ){
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(7);
        root.right.right = new Node(8);
        System.out.println(LCA(root, 4, 5).data);
        //LCA(root, 4, 5);
    }
}
