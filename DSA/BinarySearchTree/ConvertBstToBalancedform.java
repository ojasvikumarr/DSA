package BinarySearchTree;
import java.util.*;
public class ConvertBstToBalancedform {
    static class Node{
        int data ;
        Node left ; 
        Node right ;
        public Node(int data){
            this.data = data ;
        }
    }
    public static Node creatBST(ArrayList<Integer> arr , int si , int ei){
        if(si > ei){
            return null ;
        }

        int mid = (si + ei)/2 ;
        Node root = new Node(arr.get(mid));
        root.left = creatBST(arr, si, mid-1);
        root.right = creatBST(arr, mid+1, ei);

        return root ;
    }
    public static void preorder(Node root){
        if(root == null){
            return ;
        }
        System.out.println(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }
    public static int inorder(Node root){
        if(root == null){
            return -1;
        }
        inorder(root.left);
        System.out.println(root.data+" ");
        inorder(root.right);
        return root.data ;
    }
    public static void getInorder(Node root , ArrayList<Integer> inorder){
        if( root == null ){
            return ;
        }
        getInorder(root.left, inorder);
        inorder.add(root.data);
        getInorder(root.right, inorder);

    }
    public static Node BalanceBST(Node root){
        //inorder sequence 
        ArrayList<Integer> inorder = new ArrayList<>();
        getInorder(root,inorder);

        //sorted sequence --> balancedBST
        creatBST(inorder, 0, inorder.size()-1);
        return root ;
    }
    public static void main( String args[] ){
        // Node root = new Node(8);
        // root.left = new Node(5);
        // root.left.left = new Node(3);
        // root.left.right = new Node(6);
        // root.right = new Node(10);
        // root.right.right = new Node(11);
        // root.right.right.right = new Node(14);
        // root.right.right.right.right = new Node(16);
        // root = BalanceBST(root);
        // preorder(root);
        Node root = new Node ( 8);
        root.left = new Node ( 6);
        root. left. left = new Node ( 5);
        root.left.left.left = new Node ( 3) ;
        root.right = new Node ( 10) ;
        root. right. right = new Node( 11);
        root.right.right.right = new Node ( 12) ;
        root = BalanceBST(root);
        preorder(root);
    }
}
