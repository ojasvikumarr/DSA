package LeetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.* ;
public class Day82 {

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
    public List<Integer> largestValues(TreeNode root) {
        if(root == null) return new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        List<Integer> ans = new ArrayList<>();
        while(!q.isEmpty()){
            int size = q.size();
            int maxi = Integer.MIN_VALUE ;
            for(int i = 0 ; i < size ; i++){
                TreeNode curr = q.poll();
                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
                maxi = Math.max(maxi , curr.val);
            }
            ans.add(maxi);
        }
        return ans ;
    }
}
}
