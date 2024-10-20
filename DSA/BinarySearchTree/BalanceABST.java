package BinarySearchTree;
import java.util.* ;

public class BalanceABST {
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

    // https://www.geeksforgeeks.org/convert-normal-bst-balanced-bst/?ref=lbp 
    
    //To balance the binary search tree 
    //Approach will be to convert the given binary search tree into sorted array 
    //Then convert this sorted array to balanced binary search tree

    public static Node createBalancedTree(ArrayList<Integer> ls , int start , int end){
        if(start > end){
            return null ;
        }
        int mid = (start+end)/2 ;
        Node root = new Node(ls.get(mid));
        root.left = createBalancedTree(ls, start, mid-1);
        root.right = createBalancedTree(ls, mid+1, end);
        return root ;
    }

    public static void inorderTraversal(Node root , ArrayList<Integer> ls){
        if(root == null){
            return ; 
        }
        inorderTraversal(root.left, ls);
        ls.add(root.data);
        inorderTraversal(root.right, ls);
    }
    public static Node balancedTree(Node root){
        ArrayList<Integer> ls = new ArrayList<>();
        inorderTraversal(root, ls);
        root = createBalancedTree(ls, 0, ls.size()-1);
        return root ;
    }
    public static void main(String[] argv){

    }
}
