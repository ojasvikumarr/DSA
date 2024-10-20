package BinarySearchTree;

import java.util.ArrayList;

public class Root2Leaf {
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
    public static void inorder(Node root){
        if( root == null ){
            return ;
        }
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);

    }
    public static Node Insert(Node root , int val){
        if(root == null){
            root = new Node(val);
            return root ;
        }
        if(root.data>val){
            root.left = Insert(root.left,val);
        }
        if(root.data<val){
            root.right = Insert(root.right, val);
        }
        return root ;
    }

    public static void printPath(ArrayList<Integer> path){
        for( int i = 0 ; i < path.size() ; i++ ){
            System.out.print(path.get(i)+"->");
        }
        System.out.println("Null");
    }

    public static void PrintRoot2Leaf(Node root, ArrayList<Integer> path){
        if(root == null){
            return ;
        }
        path.add(root.data);

        if(root.left == null && root.right == null){
            printPath(path);
        }
        PrintRoot2Leaf(root.left , path);
        PrintRoot2Leaf(root.right , path);
        path.remove(path.size()-1);
    }
    public static void main(String args[]){
        // int val[] = {8,5,3,6,10,11,14};
        int val[] = {14,8,5,6,3,10,11};
        Node root = null ;
        for(int i = 0 ; i < val.length ; i++){
            root = Insert(root,val[i]);
        }
        inorder(root);
        System.out.println();
        PrintRoot2Leaf(root,new ArrayList<>());
    }
}
