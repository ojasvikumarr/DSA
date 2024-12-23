package LeetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.* ;

public class Day81 {

// / * Definition for a binary tree node.*/
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
    public int minimumOperations(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        int count = 0 ; 
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> ls = new ArrayList<>();
            for(int i = 0 ; i < size ; i++){
                TreeNode curr = q.poll();
                ls.add(curr.val);
                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
            }
            count += miniSwaps(ls);
        }

        return count ;
    }
    class Pair{
        int val ; 
        int idx ; 
        public Pair(int v, int i){
            this.val = v ; 
            this.idx = i ;
        }
    }
    public int miniSwaps(List<Integer> ls){
        List<Pair> sorted = new ArrayList<>();
        for(int i = 0 ; i < ls.size() ; i++){
            sorted.add(new Pair(ls.get(i) , i));
        }
        Collections.sort(sorted , (a,b) ->a.val - b.val);
        int n = ls.size();
        boolean[] visited = new boolean[n];
        int swaps = 0;

        for(int i = 0 ; i < n ; i++){
            if(visited[i] || sorted.get(i).idx == i) continue ;

            int cycleSize = 0 ; 
            int j = i ; 

            while(!visited[j]){
                visited[j] = true ; 
                j = sorted.get(j).idx ;
                cycleSize++ ;
            }
            if(cycleSize > 1) swaps += cycleSize - 1 ;
        }
        return swaps ;
    }
    // public int swaps(List<Integer> ls){
    //     int count = 0 ; 
    //     List<Integer> sortedLs = new ArrayList<>(ls);
    //     Collections.sort(sortedLs);
    //     int i = 0 ; 
    //     while(i < ls.size()){
    //         if(ls.get(i) != sortedLs.get(i)){
    //             int idx = sortedLs.index(ls.get(i));
    //             //swapping happens
    //             int temp = ls.get(i);
    //             ls.set(i ,ls.get(idx));
    //             ls.set(idx , temp );
    //             count++ ;
    //         }else{
    //             i++ ;
    //         }
    //     }
    //     return count ;
    // }
}
}
