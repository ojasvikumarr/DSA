package BinaryTrees;
import java.util.* ;

import BinaryTrees.Rev4.Node;
public class Rev3 {

    static class Node{
        int data ;
        Node left , right ;
        public Node(int data){
            this.data = data ;
            this.left = null ;
            this.right = null ;
        }
    }

    public static boolean isIdentical(Node node , Node subroot){
        if( node == null && subroot == null ){
            return true ;
        }
        else if(node == null || subroot == null || node.data != subroot.data){
            return false;
        }

        if(!isIdentical(node.left , subroot.left)){
            return false ;
        }
        if(!isIdentical(node.right , subroot.right)){
            return false ;
        }
        return true ;
    }
    public static boolean isSubtree(Node root , Node subroot){
        if( root == null ){
            return false ;
        }
        if( root.data  == subroot.data){
            if(isIdentical(root,subroot)){
                return true ;
            }
        }
        boolean leftans = isSubtree(root.left,subroot);
        boolean rightans = isSubtree(root.right,subroot);

        return leftans || rightans ;

    }
    static class Info{
        Node node ;
        int hd ;
        public Info(Node node , int hd){
            this.node = node ;
            this.hd = hd ;
        }
    }
    public static void topView(Node root){
        Queue<Info> q = new LinkedList<>();
        HashMap<Integer , Node> map = new HashMap<>();

        int min = 0 , max = 0 ;
        q.add(new Info(root,0));
        q.add(null);
        while(!q.isEmpty()){
            Info curr = q.remove();
            if(curr == null){
                if(q.isEmpty()){
                    break ;
                }
                else{
                    q.add(null);
                }
            }
            else{
                if(!map.containsKey(curr.hd)){
                map.put(curr.hd , curr.node);
            }
            if(curr.node.left != null){
                q.add(new Info(curr.node.left , curr.hd-1));
                min = Math.min(min,curr.hd-1);
            }
            if(curr.node.right != null){
                q.add(new Info(curr.node.right , curr.hd+1));
                max = Math.max(max,curr.hd+1);
            }}

        }
        for( int i = 0 ; i<= max ; i++){
            System.out.print(map.get(i).data);
        }
    }
    public static void main(String args[]){
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);

        Node subroot = new Node(2);
        subroot.left = new Node(4);
        subroot.right = new Node(5);
    }

    public boolean isIdntical(Node p , Node q){
        if(p == null && q == null){
            return true ;
        }
        else if(p == null || q == null || p.data != q.data){
            return false ;
        }
        if(!isIdentical(p.left , q.left)){
            return false ;
        }
        if(!isIdentical(p.right , q.right)){
            return false ;
        }
        return true ;
    }
    public boolean isSameTree(Node p, Node q) {
        if(p.data == q.data){
            if(isIdntical(p , q)){
                return true ;
            }
        }
        return false ;
    }
}
