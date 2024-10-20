package Graphs;

import java.util.*;

public class Practise {
    static class Edge {
        int src;
        int dest;

        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    // public static boolean
    // public static boolean cycleBFS(ArrayList<Edge>[] graph , int src , int par){
    // Queue<Integer> q = new LinkedList<>();
    // int vis[] = new int[graph.length];
    // q.add(src);
    // while(!q.isEmpty()){
    // int curr = q.remove();
    // if()
    // }
    // }
    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static int minDepth(Node root) {
        if (root == null) {
            return 0;
        }
        // bfs approach ;
        int depth = 0;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while (!q.isEmpty()) {
            Node curr = q.remove();
            if (curr == null) {
                if (q.isEmpty()) {
                    break;
                }
                q.add(null);
                depth++;
            } else {
                if (curr.left != null) {
                    q.add(curr.left);
                }
                if (curr.right != null) {
                    q.add(curr.right);
                }
                if (curr.left == null && curr.right == null) {
                    return depth;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        System.out.println("The minimum depth will be :  " + minDepth(root));
    }
}
