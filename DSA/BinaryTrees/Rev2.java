package BinaryTrees;

public class Rev2 {
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

    public static int Height(Node root) {
        if (root == null) {
            return 0;
        }
        int lh = Height(root.left);
        int rh = Height(root.right);
        return Math.max(lh, rh) + 1;
    }

    public static int Count(Node root) {
        if (root == null) {
            return 0;
        }
        int lh = Count(root.left);
        int rh = Count(root.right);
        return (lh + rh + 1);
    }

    public static int Sum(Node root) {
        if (root == null) {
            return 0;
        }
        int lh = Sum(root.left);
        int rh = Sum(root.right);
        return lh + rh + root.data;
    }

    public static int diameter(Node root) {
        if (root == null) {
            return 0;
        }
        int leftDiam = diameter(root.left);
        int leftHt = Height(root.left);
        int rightDiam = diameter(root.right);
        int rightHt = Height(root.right);

        int selfDiam = leftHt + rightHt;
        return Math.max(selfDiam, Math.max(leftDiam, rightDiam));
    }

    static class Info {
        int diam;
        int ht;

        public Info(int diam, int ht) {
            this.diam = diam;
            this.ht = ht;
        }
    }

    public static Info diameter2(Node root) {
        if (root == null) {
            return new Info(0, 0);
        }
        Info leftInfo = diameter2(root.left);
        Info rightInfo = diameter2(root.right);

        int diam = Math.max(Math.max(leftInfo.diam, rightInfo.diam), leftInfo.ht + rightInfo.ht + 1);
        int ht = Math.max(leftInfo.ht, rightInfo.ht) + 1;
        return new Info(diam, ht);
    }

    public static void main(String args[]) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        System.out.println("Height of the tree is :" + Height(root));
        System.out.println("Count ; " + Count(root));
        System.out.println("The sum is : " + Sum(root));
        System.out.println("The diameter of the tree is : " + diameter(root));
        System.out.println("The diameter of the tree in linear time complexity is  : " + diameter2(root).diam);
    }
}
