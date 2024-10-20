package BinarySearchTree;
import java.util.* ;
public class R4 {
    static class Node{
        int data ;
        Node left , right ;
        public Node( int h){
            data = h ;
            this.left = null ;
            this.right = null ;
        }
    }

    static class Info{
        boolean isBST ;
        int size ;
        int min ;
        int max ;

        public Info(boolean isBST , int size , int min , int max){
            this.isBST = isBST ;
            this.size = size ;
            this.min = min ; 
            this.max = max ;
        }
    }

    public static int maxBST = 0 ;
    public static Info LargestBST(Node root){
        if(root == null){
            return new Info(true , 0 , Integer.MAX_VALUE , Integer.MIN_VALUE);
        }
        Info left = LargestBST(root.left);
        Info right = LargestBST(root.right);

        int size = left.size + right.size + 1 ;
        int min = Math.min(root.data , Math.min(left.min ,right.min));
        int max = Math.max(root.data , Math.max(left.max , right.max));

        if(root.data <= left.max || root.data >= right.min){
            return new Info(false , size , min , max);
        }

        if(left.isBST && right.isBST){
            maxBST = Math.max(maxBST , size);
            return new Info(true , size , min , max);
        }
        
        return new Info(false , size , min , max);
    }

    public static void inorderSeq(Node root , ArrayList<Integer> inorder){
        if( root == null ){
            return ;
        }
        inorderSeq(root.left, inorder);
        inorder.add(root.data);
        inorderSeq(root.right, inorder);
    }
    public static void SelectionSort(ArrayList<Integer> A , ArrayList<Integer> B , ArrayList<Integer> AB){
        int i = 0 ;
        int j = 0 ;

        while(i < A.size() && j < B.size()){
            if(A.get(i) < B.get(j)){
                AB.add(A.get(i));
                i++ ;
            }
            if(A.get(i) > B.get(j)){
                AB.add(B.get(j));
                j++ ;
            }
            else if(A.get(i) == B.get(j)){
                AB.add(B.get(j));
                i++;j++;
            }
        }
        while(i < A.size()){
            AB.add(A.get(i));
            i++;
        }
        while(j < B.size()){
            AB.add(B.get(j));
            j++;
        }
    }

    public static int idx = -1 ;
    public static Node insert(Node root ,ArrayList<Integer> A){
        idx++ ;
        if(root == null){
            root = new Node(A.get(idx));
            return root ;
        }

        if(root.data > A.get(idx)){
            root.left = insert(root.left, A);
        }else if(root.data < A.get(idx)){
            root.right = insert(root.right , A);
        }
        return root ;
    }

    public static Node BalancedBST(ArrayList<Integer> inorder , int st , int end){
        if( st>end ){
            return  null ;
        }
        int mid = (st+end)/2 ;
        Node root = new Node(inorder.get(mid));
        root.left = BalancedBST(inorder, st, mid-1);
        root.right = BalancedBST(inorder , mid+1 , end);
        return root ;
    }

    public static Node merge2BSTs(Node A ,Node B){
        ArrayList<Integer> X = new ArrayList<>();
        ArrayList<Integer> Y = new ArrayList<>();
        ArrayList<Integer> AB = new ArrayList<>();
        inorderSeq(A, X);
        inorderSeq(B, Y);

        SelectionSort(X, Y, AB);
        Node root = null ;
        root = BalancedBST(AB , 0 , AB.size()-1);
        return root ;
    }
    public static void preorder(Node root){
        if( root == null ){
            return ;
        }
        System.out.print(root.data+"->");
        preorder(root.left);
        preorder(root.right);
        // System.out.println("Null");
    }
    public static void main(String args[]){
        Node root = new Node ( 50);
        root. left = new Node ( 30);
        root. left. left = new Node( 5);
        root. left. right = new Node ( 20);
        root. right = new Node ( 60);
        root. right. left = new Node ( 45);
        root. right. right = new Node( 70);
        root. right. right. left = new Node ( 65);
        root. right. right. right = new Node ( 80) ;

        Info info = LargestBST(root);
        System.out.println("Largest BST size : "+maxBST);

        Node A = new Node(2);
        A.left = new Node(1);
        A.right = new Node(4);
        preorder(A);
        System.out.println();
        Node B = new Node(9);
        B.left = new Node(3);
        B.right = new Node(12);
        preorder(B);
        Node merged = merge2BSTs(A, B);
        preorder(merged);
    }
}
