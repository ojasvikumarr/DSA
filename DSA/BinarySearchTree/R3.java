package BinarySearchTree;
import java.util.* ;
public class R3 {
    static class Node{
        int data ;
        Node left , right ;
        public Node( int data ){
            this.data = data ;
            this.left = null ;
            this.right = null ;
        }
    }
    public static boolean getpath( Node root , int n , ArrayList<Node> path ){
        if(root == null){
            return false ;
        }

        path.add(root);

        if(root.data == n){
            return true ;
        }
        boolean left = getpath(root.left, n, path);
        boolean right = getpath(root.right, n, path);

        if(left || right){
            return true ;
        }

        path.remove(path.size() - 1);
        return false ;
    }
    static class Tree{
        static int idx = -1 ;
        public  Node binaryTree(int val[]){
            int idx = 0;
            if(val[idx] == -1){
                return null ;
            }
            Node newNode = new Node(val[idx]);
            newNode.left = binaryTree(val);
            newNode.right = binaryTree(val);
            idx++ ;
            return newNode ;
        }
    }

    public static void printpath(ArrayList<Integer> path){
        for(int i = 0 ; i < path.size(); i++){
            System.out.print(path.get(i)+"->");
        }
        System.out.println("Null");
    }
    public static void printRoot2Leaf(Node root , ArrayList<Integer> path){
        if(root == null){
            return ;
        }
        path.add(root.data);
        if(root.left == null || root.right == null){
            printpath(path);
        }
        printRoot2Leaf(root.left, path);
        printRoot2Leaf(root.right, path);
        path.remove(path.size()-1);
    }
    public static Node insert( Node root , int val ){
        if( root == null ){
            root = new Node(val);
            return root ;
        }
        if(root.data > val){
            root.left = insert(root.left , val);
        }
        else if(root.data < val){
            root.right = insert(root.right , val);
        }
        return root ;
    }

    public static boolean isValid(Node root , Node min , Node max){
        if(root == null){
            return true ;
        }
        if(min != null && root.data <= min.data){
            return false ;
        }
        else if(max != null && root.data >= max.data){
            return false ;
        }
        return isValid(root.left , min , root) && isValid(root.right , root , max);
    }

    public static Node Mirror(Node root){
        if(root == null){
            return null;
        }
        Node left = Mirror(root.left);
        Node right = Mirror(root.right);
        root.right = left ;
        root.left = right ;
        return root ;
    }

    public static Node BalancedBST(int arr[] , int st , int end){
        if( st > end ){
            return null ;
        }
        int mid = (st+end)/2;
        Node root = new Node(arr[mid]);
        root.left = BalancedBST(arr, st, mid-1);
        root.right = BalancedBST(arr, mid+1 , end);
        return root ;
    }

    public static void getInOrder(ArrayList<Integer> inorder , Node root){
        if( root == null ){
            return ;
        }
        getInOrder(inorder, root.left);
        inorder.add(root.data);
        getInOrder(inorder, root.right);
    }

    public static Node balancedBSt(ArrayList<Integer> val , int st , int end){
        if(st > end){
            return null ;
        }
        int mid = (st+end)/2 ;
        Node newNode = new Node(val.get(mid));
        balancedBSt(val, st, mid-1);
        balancedBSt(val, mid+1, end) ;
        return newNode ;
    }

    public static Node convertingToBalancedBst(Node root){
        //get the in order sequence of the tree
        ArrayList<Integer> inorder = new ArrayList<>();
        getInOrder(inorder, root);

        //making the inorder sequence a balanced Bst
        root = balancedBSt(inorder, 0, inorder.size()) ;
        return root ;
    }

    public static void preorder( Node root ){
        if( root == null ){
            return ;
        }
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }
    public static void main(String args[]){
        int val[] = {5 , 1 , 3 ,4 , 6 , 8, 9, 10, 14};
        // Tree t = null ;
        // Node root = t.binaryTree(val);
        // ArrayList<Node> list = new ArrayList<>();
        // getpath(root , 4 , list);
        // int i =0;
        // while(i<list.size()){
        //     System.out.println(list.get(i));
        //     list.remove(i);
        //     i--;
        // }
        Node ro = null ;
        for( int i = 0 ; i < val.length ; i++ ){
            ro = insert(ro,val[i]);
        }
        printRoot2Leaf(ro, new ArrayList<>());
        if(isValid(ro, null, null)){
            System.out.println("Valid it is ");
        }else{
            System.out.println("invalid it is ");
        }

        Node root = new Node ( 8);
        root. left = new Node ( 6);
        root. left. left = new Node( 5) ;
        root. left. left. left = new Node( 3);
        root. right = new Node ( 10);
        root. right. right = new Node  (11);
        root. right. right. right = new Node ( 12);
        root = convertingToBalancedBst(root);
        preorder(root);
    }
}
