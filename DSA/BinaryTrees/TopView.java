package BinaryTrees;
import java.util.*;
public class TopView {
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
    static class Info{
        int hd ;//horizontal distance 
        Node node ;
        public Info(Node node , int hd){//Constructor
            this.node = node ;
            this.hd = hd ;
        }
    }
    public static void Topview(Node root){
        Queue<Info> q = new LinkedList<>();
        HashMap<Integer , Node> maps = new HashMap<>();
        q.add(new Info(root,0));
        q.add(null);
        int min = 0 , max = 0 ;
        while(!q.isEmpty()){
            Info curr = q.remove();
            if( curr == null ){
                if(q.isEmpty()){
                    break ;
                }
                else{
                    q.add(null);
                }
            }
            else{
                if(!maps.containsKey(curr.hd)){
                    maps.put(curr.hd, curr.node);
                }
                if(curr.node.left != null){
                    q.add(new Info(curr.node.left , curr.hd - 1));
                    min = Math.min(min,curr.hd-1);
                }
                if(curr.node.right != null){
                    q.add(new Info(curr.node.right , curr.hd + 1));
                    max = Math.max(max,curr.hd+1);
                }
            }
        }
        for( int i = min ; i <= max ; i++ ){
            System.out.print(maps.get(i).data+" ");
        }
        System.out.println();
    }
    public static void main(String args[]){
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        Topview(root);
    }
}
