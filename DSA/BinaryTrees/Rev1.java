package BinaryTrees;
import java.util.* ;
public class Rev1 {
    static class Node{
        int data ;
        Node right ;
        Node left ;
        Node(int data){
            this.data= data ;
            this.left = null ;
            this.right = null ;
        }
    }

    static class BinaryTree{
        static int idx = -1 ;//jisse har level pe idx update ho , static will make only one copy of that variable which will be circulated through out the code 
        public Node buildTree( int nodes[] ){
            idx++ ;
            if(nodes[idx] == -1){
                return null ;
            }
            Node newNode = new Node( nodes[idx] );
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);
            return newNode ;
        }

        public static void preorder( Node root ){
            if( root == null ){
                return ;
            }

            System.out.println(root.data + " ");
            preorder(root.left);
            preorder(root.right);
        }
        public static void inorder(Node root){
            if( root == null ){{
                return ; 
            }}
            inorder(root.left);
            System.out.print(root.data+"->");
            inorder(root.right);
        }
        public static void postorder(Node root){
            if(root == null){
                return ;
            }
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data+"->");
        }

        public static void LevelOrder( Node root ){
            if( root == null ){
                return ;
            }
            Queue<Node> q = new LinkedList<>();
            q.add(root);
            q.add(null);
            while(!q.isEmpty()){
                Node currNode = q.remove();
                if(currNode == null){
                    System.out.println();
                    if(q.isEmpty()){
                        break ;
                    }
                    else{
                        q.add(null);
                    }
                }else{
                    System.out.print(currNode.data+" ");
                    if(currNode.left != null){
                        q.add(currNode.left);
                    }
                    if(currNode.right != null){
                        q.add(currNode.right);
                    }
                }
            }
        }

        public static int height(Node root){
            Node curr = root ;
            if(curr.left == null && curr.right == null){
                return 0 ;
            }
            int l = height(curr.left)+1 ;
            int r = height(curr.right)+1 ;

            return l+r ;
        }
    }

    public static void main(String args[]){
        int nodes[] = {1 , 2, 4, -1 , -1 , 5 , -1 , -1 , 3, -1 , 6 };
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);
        System.out.println(root.data);
    }
}
