package BinaryTrees;

public class Intro {
    static class Node {
        int data ;
        Node left ;
        Node right ;
        Node ( int data ){
            this.data = data ;
            this.left = null ;
            this.right = null ;
        }
        static class BinaryTree{
            static int idx = - 1 ;
            public Node buildTree(int nodes[]){
                idx++ ;
                if(nodes[idx] == -1){
                    return null ;
                }
                Node newNode = new Node(nodes[idx]);
                newNode.left = buildTree(nodes);
                newNode.right = buildTree(nodes);
                return newNode ;
            }
            public void preorder(Node root){
                if(root == null){
                    return ;
                }
                System.out.print(root.data+" ");
                preorder(root.left);
                preorder(root.right);
            }
            public void inorder(Node root){
                if(root == null){
                    return ;
                }
                inorder(root.left);
                System.out.print(root.data+" ");
                inorder(root.right);
            }
            public void postorder(Node root){
                if( root == null ){
                    return ;
                }
                postorder(root.left);
                postorder(root.right);
                System.out.print(root.data+" ");

            }
            public void pstorder(Node root){
                if( root == null ){
                    return ;
                }
                postorder(root.right);
                postorder(root.left);
                System.out.print(root.data+" ");

            }
            public int height(Node root){
                if(root == null){
                    return 0 ;
                }
                int lh = height(root.left);
                int rh = height(root.right);
                return (Math.max(lh,rh)+1) ;
            }
            public int NoNodes(Node root){
                if(root == null){
                    return 0 ;
                }
                int lh = NoNodes(root.left);
                int rh = NoNodes(root.right);
                return (lh+rh)+1;
            }
            public int SumNodes(Node root){
                if(root == null){
                    return 0 ;
                }
                int leftSum = SumNodes(root.left);
                int rightSum = SumNodes(root.right);
                return leftSum + rightSum + root.data ;
            }
            public int Diameter(Node root){//O(n^2)
                if(root == null){
                    return 0 ;
                }
                int leftdiam = Diameter(root.left);
                int rightdiam = Diameter(root.right);
                int leftHeight = height(root.left);
                int rightHeight = height(root.right);

                int selfDiam = leftHeight+rightHeight+1;
                return Math.max(selfDiam, Math.max(leftdiam , rightdiam));
            }
        }
        static class Info{
            int diam ;
            int ht ;
            public Info(int diam , int ht){
                this.diam = diam ;
                this.ht = ht ;
            }
        }
        public static Info Diameter2(Node root){//O(n)
            if(root == null){
                return new Info(0,0);
            }
            Info leftInfo = Diameter2(root.left);
            Info rightInfo = Diameter2(root.right);
        
            int diam = Math.max(Math.max(leftInfo.diam , rightInfo.diam), leftInfo.ht + rightInfo.ht + 1);
            int ht = Math.max(leftInfo.ht , rightInfo.ht)+1;
        
            return new Info(diam , ht);
        }
        public static void main(String args[]){
            int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
            BinaryTree tree = new BinaryTree();
            Node root = tree.buildTree(nodes);
            System.out.println(root.data);
            tree.preorder(root);
            System.out.println();
            tree.inorder(root);
            System.out.println();
            tree.postorder(root);
            System.out.println();
            tree.pstorder(root);
            System.out.println();
            System.out.println(tree.height(root));
            System.out.println(tree.NoNodes(root));
            System.out.println(tree.SumNodes(root));
            System.out.println(tree.Diameter(root));
            System.out.println(Diameter2(root).diam);
        }
    }
}
