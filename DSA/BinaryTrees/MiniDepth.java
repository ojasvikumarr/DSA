package BinaryTrees;

import java.util.*;

public class MiniDepth {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution {
        public int minDepth(TreeNode root) {
            Queue<TreeNode> q = new LinkedList<>();
            q.add(root);
            q.add(null);
            int depth = 0;
            while (!q.isEmpty()) {
                TreeNode curr = q.remove();
                if (curr != null) {
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
    }
}
