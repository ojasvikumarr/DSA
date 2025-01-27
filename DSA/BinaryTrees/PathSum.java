package BinaryTrees;

public class PathSum { 
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
 
class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null){
            return false ;
        }
        return solve(root , 0 , targetSum);
    }
    //recursively traverse the tree with sum
    //we'll have a sum variable that will be storing the sum of nodes 
    public boolean solve(TreeNode root , int sum , int target){
        if(root.left == null && root.right == null){
            if(sum+root.val == target){
                return true ;
            }else{
                return false ;
            }
        }
        boolean left = false; 
        if(root.left != null)
         left = solve(root.left , sum + root.val , target);
        boolean right = false ;
        if(root.right != null)
         right = solve(root.right , sum + root.val , target);
        return left || right ; 
    }
}
}
