package BinarySearchTree;

import java.util.Queue;
import java.util.LinkedList;

public class BSTimplementation {
    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int d) {
            this.data = d;
            this.left = this.right = null;
        }
    }

    class BST {
        Node root;

        public BST() {
            root = null;
        }
    }

    public static Node insert(Node root, int val) {
        if (root == null) {
            root = new Node(val);
            return root;
        }
        if(root.data == val) return root ;
        if (root.data > val) {
            root.left = insert(root.left, val);
        } else {
            root.right = insert(root.right, val);
        }
        return root;
    }

    public static boolean Search(Node root , int key){
        if(root == null) return false ;
        if(root.data == key){
            return true ;
        }
        if(key < root.data){
            return Search(root.left , key);
        }
        return Search(root.right , key);
    }
    public static int minValue(Node root){
        if(root.left == null && root.right == null){
            return root.data ;
        }
        if(root.left != null){
            return minValue(root.left);
        }return root.data ;
    }
    public static int maxValue(Node root){
        if(root.left == null && root.right == null){
            return root.data ;
        }
        if(root.right != null){
            return maxValue(root.right);
        }return root.data ;
    }
    public static int minValueWHile(Node root){
        Node temp = root ;
        while(temp.left != null){
            temp = temp.left ;
        }
        return temp.data;
    }
    public static int maxValueWHile(Node root){
        Node temp = root ;
        while(temp.right != null){
            temp = temp.right ;
        }
        return temp.data;
    }
    public static void LevelOrder(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Node curr = q.remove();
                System.out.print(curr.data + " ");
                if (curr.left != null) {
                    q.add(curr.left);
                }
                if (curr.right != null) {
                    q.add(curr.right);
                }
            }
            System.out.println();
        }
    }

    public static Node delete(Node root , int val){
        if(root.data == val){
            if(root.left == null && root.right == null){
                return null; 
            }else if(root.right == null && root.left != null){
                Node temp = root.left ;
                // delete(root);
                return temp ;
            }else if(root.left == null && root.right != null){
                Node temp = root.right ; 
                // delete(root);
                return temp ; 
            }else{
                int mini = minValue(root.right);
                root.data= mini ; 
                root.right = delete(root.right, mini);
                return root ;
            }
        }
        if(root.data < val){
            root.right = delete(root.right, val);
        }else{
            root.left = delete(root.left , val);
        }
        return root ;
    }
    public static Node leftMax(Node root){
        if(root.left == null && root.right == null){
            return root ;
        }
        if(root.left != null){
            root.left = leftMax(root.left);
        }else if(root.right != null){
            root.right = leftMax(root.right);
        }
        return root ;
    }

    public static boolean ValidBST(Node root , int min , int max){
        if(root == null){
            return true ;
        }
        if(root.data >= min && root.data <= max){
            boolean left = ValidBST(root.left, min, root.data);
            boolean right = ValidBST(root.right, root.data, max);
            return left && right ;
        }else{
            return false ;
        }
    }

    static int counter = 1 ; 
    public static int KthSmallest(Node root , int k ){
        if(root == null){
            return -1 ; 
        }
        int left = KthSmallest(root.left , k);
        if(left != -1 ){
            return left ;
        }
        counter++ ;
        if(counter == k){
            return root.data ;
        }
        return KthSmallest(root.right , k);
    }

    public static void main(String[] argv) {
        Node root = new Node(10);
        insert(root, 5);
        insert(root, 20);
        insert(root, 12);
        insert(root, 10);
        insert(root, 3);
        insert(root, 50);
        insert(root, 40);

        LevelOrder(root);

        System.out.println(Search(root , 0));
        System.out.println("Min value is : "+minValue(root) );
        System.out.println("Max value is : "+maxValue(root));

        delete(root, 50);
        LevelOrder(root);
        delete(root, 10);
        LevelOrder(root);
        System.out.println(ValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
        System.out.println(KthSmallest(root , 4));
    }

}
