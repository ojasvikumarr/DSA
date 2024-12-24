package DynamicProgramming;

import java.util.Arrays;

public class NonOverlapping {
    class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length ;
        Arrays.sort(intervals , (a,b) -> a[1] - b[1]);
        int end = intervals[0][1];
        int count = 0 ;
        for(int i = 1 ; i < n ; i++){
            if(end > intervals[i][0]){
                count++ ;
            }else{
                end = intervals[i][1];
            }
        }
        return count ;
    }
    // public boolean checkOverlapping(List<List<Integer>> list){
    //     Collections.sort(list , (a , b) -> a.get(1) - b.get(1));
    //     int end = list.get(0).get(1);
    //     for(List<Integer> ls : list){
    //         if()
    //     }
    // }
}
}
