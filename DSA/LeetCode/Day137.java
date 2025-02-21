package LeetCode;

import java.util.HashSet;
import java.util.Set;

public class Day137 {

//  Definition for a binary tree node.
 public class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
 }
 
class FindElements {
    Set<Integer> set ;
    public FindElements(TreeNode root) {
        root.val = 0 ; 
        set = new HashSet<>();
        set.add(0);
        recoverTree(root);
    }
    public boolean find(int target) {
        return set.contains(target);
    }
    public void recoverTree(TreeNode root){
        if(root == null){
            return ; 
        }
        if(root.left != null){
            root.left.val = root.val*2 + 1;
            set.add(root.left.val);
            recoverTree(root.left); 
        }
        if(root.right != null){
            root.right.val = root.val*2 + 2 ;
            set.add(root.right.val);
            recoverTree(root.right);
        }
        return ;
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */
}
