package BinaryTrees;

public class HW {
    //Check if a Binary Tree is univalued or notWehaveabinarytree,thetaskistocheckifthebinarytreeisunivaluedornot.Iffoundtobetrue, then print “YES”. Otherwise, print “NO
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
/* 
    public static int UniValued(Node root){
        if(root == null){
            return 0;
        }
        int leftchild = UniValued(root.left);
        int rightchild = UniValued(root.right);
        if( leftchild == rightchild && leftchild == root.data && rightchild == root.data){
            System.out.println("YES!");
        }
        if(leftchild == null && rightchild == null){

        }
        System.out.println("No!!");
        return 1 ;
    }
*/
    public static boolean univalued(Node root){
        if(root == null){
            return true ;
        }
        if(root.left != null &&root.data != root.left.data){
            return false ;
        }
        if(root.right != null && root.data != root.right.data){
            return false ;
        }
        return univalued(root.left) && univalued(root.right);
    }

//Invert Binary tree 
    public static int InvertTree(Node root){
        if(root == null){
            return 0;
        }
        int left = InvertTree(root.left);
        int right = InvertTree(root.right);
        
        int a = left ;
        left = right ;
        right = a ;
        return 1;
    }
//Delete Target value from Binary tree
    public static Node Delete(Node root , int k){
        if(root.data > k){
            root.left = Delete(root.left, k);
        }
        if(root.data < k){
            root.right = Delete(root.right, k);
        }
        else{
            //case 1 : no child
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
        }
        return root ;

    }
    public static void main(String args[]){
        Node root =new Node(2);
        root.left = new Node(2);
        root.right = new Node(2);
        root.left.left = new Node(2);
        root.right.left = new Node(2);
        root.right.right = new Node(2);
        if(univalued(root)){
            System.out.println("Yes");
        }
        else{
            System.out.println("No");
        }
    }
}
