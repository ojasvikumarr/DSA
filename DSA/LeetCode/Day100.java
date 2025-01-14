package LeetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Day100 {
    class Solution {
   public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length ;
        int[] ans = new int[n];
        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            a.add(A[i]);
            b.add(B[i]);
            ans[i] = countCommon(a , b);
        }
        return ans ;
    }
    public int countCommon(List<Integer> a , List<Integer> b ){
        Collections.sort(a);
        Collections.sort(b);
        int i = 0 ;
        int j = 0 ; 
        int count = 0 ;
        while(i < a.size() && j < b.size()){
            if(a.get(i) == b.get(j)){
                i++ ;
                j++ ;
                count++ ;
            }else if(a.get(i) < b.get(j)){
                i++ ;
            }else{
                j++ ;
            }
        }
        return count ;
    }
}
}
