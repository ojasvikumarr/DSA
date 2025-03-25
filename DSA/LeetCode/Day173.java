package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day173 {
    class Solution {
    public boolean checkValidCuts(int n, int[][] rectangles) {
        int m = rectangles.length ;
        int[][] x = new int[m][2];
        int[][] y = new int[m][2];
        for(int i = 0 ; i < m ; i++){
            int[] rec = rectangles[i];
            x[i] = new int[]{rec[0] , rec[2]};
            y[i] = new int[]{rec[1] , rec[3]};
        }
        int horizontal = mergeIntervals(x);
        int vertical = mergeIntervals(y);
        if(horizontal >= 3 || vertical >= 3){
            return true ;
        }else{
            return false ;
        }
    }
    public int mergeIntervals(int[][] intervals){
        List<int[]> res = new ArrayList<>();
        Arrays.sort(intervals , (a , b) ->{
            if(a[0] == b[0]){
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });
        int start = intervals[0][0];
        int end = intervals[0][1];
        for(int i = 1 ; i < intervals.length ; i++){
            int[] inter = intervals[i];
            if(end > inter[0]){
                if(end < inter[1]){
                    end = inter[1];
                }else{
                    continue ;
                }
            }else{
                res.add(new int[]{start , end});
                start = inter[0];
                end = inter[1];
            }
        }
        res.add(new int[]{start , end});
        return res.size();
    }
}
}
