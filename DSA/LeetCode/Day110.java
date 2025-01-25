package LeetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Day110 {
    class Solution {
    public class Pair implements Comparable<Pair>{
        int val ; 
        int idx ; 
        public Pair(int v , int i){
            this.val = v ; 
            this.idx = i ; 
        }
        @Override 
        public int compareTo(Pair other){
            return this.val - other.val ; 
        }
    }
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        List<Pair> ls = new ArrayList<>();
        int n = nums.length ;
        for(int i = 0 ; i < n ; i++){
            ls.add(new Pair(nums[i] , i));
        }
        //Sorting on the basis of value 
        Collections.sort(ls);
        // for(int i = 0 ; i < n ; i++){
        //     System.out.println(ls.get(i).val + " " + ls.get(i).idx);
        // }
        //We'll be making sections in the list 
        int i = 0 ; 
        while( i < n ) {
            int j = i ; 
            //This dummy will be storing the indices 
            List<Integer> dummy = new ArrayList<>();

            while((j+1 < n) && (Math.abs(ls.get(j).val - ls.get(j+1).val) <= limit)){
                dummy.add(ls.get(j).idx);
                j++ ;
            }
        
            if(j >= 1 && Math.abs(ls.get(j-1).val - ls.get(j).val) <= limit )dummy.add(ls.get(j).idx);
            Collections.sort(dummy);
            if( j != i ){
                for(Integer index : dummy){
                    // System.out.println(ls.get(i).val );
                    nums[index] = ls.get(i).val ;
                    i++ ;
                }
            }else{
                i++ ;
            }

        }

        return nums ; 
    }
}
}
