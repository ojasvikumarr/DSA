public class intro{

    public class Node{
        int data ; 
        int height ; 
        Node left ; 
        Node right ; 
        public Node(int data){
            this.data = data ; 
            this.height = 1 ; 
            this.left = this.right = null ; 
        }
    }

    public Node insert(Node root , int val){
        if(root == null){
            return new Node(val);
        }
        if(root.data < val){
            root.right = insert(root.right , val);
        }else{
            root.left = insert(root.left , val);
        }
        updateHeight(root);
        return balance(root);
    }

    private void updateHeight(Node root){
        root.height = 1 + Math.max(height(root.left) , height(root.right));
    }

    private int height(Node root){
        if(root == null){
            return 0 ;
        }
        return root.height ;
    }

    private Node balance(Node root){
        int balanceOfNode = getBalance(root);

        if(balanceOfNode > 1){

        }else if(balanceOfNode < -1){

        }

        return root ; 
    }

    private void rightRotate(Node root){

    }
    private void leftRotate(Node root){

    }
    
    private int getBalance(Node root){
        if(root == null){
            return 0 ; 
        }
        return height(root.left) - height(root.right);
    }


}