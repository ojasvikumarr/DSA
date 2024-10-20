package BinaryTrees;
import java.util.* ;

public class SumTree {
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
    public static int SumTreee( Node root ){
        if( root == null ){
            return 0;
        }
        //storing the value of the left node and right node 
        int leftchild = SumTreee(root.left);
        int rightchild = SumTreee(root.right);
        
        int data = root.data ;
        
        int newleft = root.left == null ? 0 : root.left.data ;
        int newright = root.right == null ? 0 : root.right.data ;

        root.data = leftchild + newleft + rightchild + newright ;
        return data ;
    }
    public static void Leveltraversal(Node root){
        if(root == null){
            return  ;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while(!q.isEmpty()){
            Node curr = q.remove();
            if(curr == null){
                System.out.println();
                if(q.isEmpty()){
                    break ;
                }
                else{
                    q.add(null);
                }
            }
            else{
                System.out.print(curr.data+" ");
                if(curr.left != null){
                q.add(root.left);
                }
                if(curr.right != null){
                q.add(root.right);
                }
            }
        }
    }
    public static void preorder(Node root){
        if(root == null){
            return ;
        }
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }
    public static void main(String args[]){
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.left = new Node(7);
        
        //Leveltraversal(root);
        SumTreee(root);
        //Leveltraversal(root);
        preorder(root);
    }
}
