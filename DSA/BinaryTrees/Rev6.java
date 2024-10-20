package BinaryTrees;

public class Rev6 {
    static class Node{
        int data ;
        Node left ;
        Node right ;
        public Node( int data ){
            this.data = data ;
            this.left = this.right = null ;
        }
    }
    public static Node Mirror( Node root ){
        if( root == null ){
            return root;
        }
        
        Node left = Mirror( root.left );
        Node right = Mirror( root.right );
        root.left = right ;
        root.right = left ;

        return root ;
    }
    // public static Node Mirror( Node root ){
    //     if( root == null ){
    //         return root;
    //     }
    //     root.left = Mirror( root.right );
    //     root.right = Mirror( root.left );

    //     return root ;
    // }not to be down as it creates an incorrect mirror image of the original tree 
    
    public static Node Target( Node root , int k ){
        if( root == null ){
            return null;
        }
        root.left = Target( root.left , k );
        root.right = Target( root.right , k );

        if( root.data == k && root.right == null && root.left == null ){
            return null ;
        }
        return root ;
    }
}
