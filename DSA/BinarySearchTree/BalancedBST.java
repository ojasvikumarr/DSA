package BinarySearchTree;

public class BalancedBST {
    static class Node{
        int data ;
        Node left ; 
        Node right ;
        public Node(int data){
            this.data = data ;
        }
    }
    public static Node creatBST(int arr[] , int si , int ei){
        if(si > ei){
            return null ;
        }

        int mid = (si + ei)/2 ;
        Node root = new Node(arr[mid]);
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
    public static void main( String args[] ){
        int arr[] = {2,5,6,8,10,11,12};
        Node root = creatBST(arr , 0 , arr.length - 1);
        preorder(root);
    }
}
