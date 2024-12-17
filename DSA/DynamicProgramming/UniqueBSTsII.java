package DynamicProgramming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UniqueBSTsII {
    
//   Definition for a binary tree node.
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
    Map<String, List<TreeNode>> memo ;
    public List<TreeNode> allPossible(int start , int end){
        List<TreeNode> resultSet = new ArrayList<>();
        if(start > end){
            // return new TreeNode(null);
            resultSet.add(null);
            return resultSet ;
        }
        String key = start + ","+ end ;
        if(memo.containsKey(key)){
            return memo.get(key);
        }
        for(int i = start ; i <=end ; i++){
            List<TreeNode> leftSet = allPossible(start , i-1);
            List<TreeNode> rightSet = allPossible(i+1 , end);
            for(TreeNode left : leftSet){
                for(TreeNode right : rightSet){
                    TreeNode root = new TreeNode(i);
                    root.left = left ; 
                    root.right = right ;
                    resultSet.add(root);
                }
            }
        }
        memo.put(key , resultSet);
        return resultSet ;
    }
    public List<TreeNode> generateTrees(int n) {
        memo = new HashMap<>();
        if(n == 0) return new ArrayList<TreeNode>();
        return allPossible(1 , n);
    }
}
}
