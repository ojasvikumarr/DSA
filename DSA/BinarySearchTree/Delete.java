package BinarySearchTree;



public class Delete {
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
    public static Node delete(Node root , int val){
        if(root.data > val){
            root.left = delete(root.left , val);
        }
        if(root.data < val){
            root.right = delete(root.right, val);
        }
        else{
            if(root.left == null && root.right == null){
                 return null ;
            }
            //case 2 : single child 
            if(root.left == null){
                return root.right ;
            }
            else if(root.right == null){
                return root.left ;
            }
            //case 3 : two child
            Node IS = firstinorderSuccessor(root.right);
            root.data = IS.data ;
            root.right = delete(root.right , IS.data   );
        }
        return root ;
    }
    public static Node firstinorderSuccessor(Node root){
        while(root.left != null){
            root = root.left ;
        }
        return root ;
    }
    public static void inorder(Node root){
        if( root == null ){
            return ;
        }
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);

    }
    public static Node insert(Node root ,int val){
        if( root == null ){
            root = new Node(val);
            return root ;
        } 
        if(root.data > val ){
            root.left = insert(root.left, val);
        }
        if(root.data < val ){
            root.right = insert(root.right, val);
        }
        return root ;
    }
    public static void main(String args[]){
        int values[] = {1,2,3,4,5,6,7,8,10,11,14};
        Node root = null ;
        for( int i = 0 ; i < values.length ; i++){
            root = insert(root , values[i]);
        }
        inorder(root);
        System.out.println();
        delete(root, 7);
        System.out.println();
        inorder(root);
        delete(root, 10);
        System.out.println();
        inorder(root);
    }
}
