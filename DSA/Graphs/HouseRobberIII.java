package Graphs;

import java.util.HashMap;
import java.util.Map;

public class HouseRobberIII { 
//  Definition for a binary tree node.÷÷
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
 
    Map<TreeNode , Integer[]> memo;
    public int rob(TreeNode root) {
        memo = new HashMap<>();
        return solve(root , true);
    }
    public int solve(TreeNode root , boolean flag){
        if(root == null) return 0 ; 
        int flagIndex = flag ? 1 : 0 ;

        memo.putIfAbsent(root , new Integer[2]);

        if(memo.get(root)[flagIndex] != null){
            return memo.get(root)[flagIndex];
        }
        int pick = 0 ; 
        int notpick = 0 ; 
        //if flag is true it is saying that we can pick or not pick 
        if(flag){
            pick = root.val + solve(root.left , false) + solve(root.right , false);
            notpick = solve(root.left , true) + solve(root.right , true);
        }else{
        //if flag is false we only have option to not not pick and move on and pick next one
            notpick = solve(root.left , true) + solve(root.right , true);
        }
        memo.get(root)[flagIndex] = Math.max(pick , notpick);
        return  memo.get(root)[flagIndex];
    }
}

