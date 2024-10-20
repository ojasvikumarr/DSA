package BinarySearchTree;

public class R2 {
    static class Node{
        Node left , right ;
        int data ;
        public Node( int data ){
            this.data = data ;
            this.left = null ;
            this.right = null ;
        }
    }
    public static Node insert( Node root , int data ){
        if( root == null ){
            root = new Node( data ) ;
            return root ;
        }
        if( root.data > data ){
            root.left = insert(root.left , data);
        }
        else{
            root.right = insert(root.right , data);
        }
        return root ;
    }
    public static boolean search( Node root , int key ){
        if( root == null ){
            return false ;
        }
        if( root.data == key ){
            return true ;
        }
        if( root.data >key ){
            return search(root.left , key);
        }else{
            return search(root.right , key);
        }
    }
    public static void inorder( Node root ){
        if( root == null ){
            return ;
        }
        inorder( root.left );
        System.out.print(root.data+" ");
        inorder( root.right);
    }

    public static Node deleteNode( Node root , int val ){
        if(root.data < val){
            root.right = deleteNode(root.right, val);
        }
        else if(root.data > val){
            root.left = deleteNode(root.left , val);
        }
        else{
            //voila
            //Case1 : leaf Node
            if( root.left == null && root.right == null ){
                return null ;
            }
            //case 2 : single child
            if( root.left == null ){
                return root.right ;
            }else if(root.right == null){
                return root.left ;
            }
            //case3: both child
            else{
                Node Is = findInorderSuccessor(root.right);
                root.data = findInorderSuccessor(root.right).data;//the smallest in the rightmost tree
                root.right = deleteNode( root.right , Is.data );//deleting that node form the right tree as it is moved to the left one 
            }
        }
        return root ;
    }
    public static Node findInorderSuccessor(Node root){
        //root will never be null as it is already handled above \
        while( root.left != null ){
            root = root.left ;
        }
        return root ;
    }
    public static void printInRange(Node root , int k1 , int k2){
        if( root == null ){
            return ;
        }
        if(root.data <= k2 && root.data >= k1){
            printInRange(root.left, k1, k2);
            System.out.println(root.data+" ");
            printInRange(root.right, k1, k2);
        }
        else if(root.data < k1){
            printInRange(root.left, k1, k2);
        }
        else{
            printInRange(root.right, k1, k2);
        }
    }
    public static void main( String args[] ){
        int val[] = {5,1,3,4,2,7 ,6 ,8 ,9 , 10 ,11 ,14 , 18};
        Node root = null ;
        for( int i = 0 ; i < val.length ;i++ ){
            root = insert(root,val[i]);
        }
        inorder(root);
        if( search(root , 10)){
            System.out.println("Found");
        }
        else{
            System.out.println("Not found");
        }
        deleteNode(root, 4);
        inorder(root);
        System.out.println();
        printInRange(root, 4, 11);
    }
}
