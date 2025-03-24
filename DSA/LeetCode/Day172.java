package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day172 {
    class Solution {
    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings , (a , b) ->{
            if(a[0] == b[0]){
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });
        //we need to merger the intervals 
        int start = meetings[0][0] ; 
        int end = meetings[0][1] ; 
        List<int[]> sortedMeets = new ArrayList<>();
        for(int i = 1 ; i < meetings.length ; i++){
            int[] meet = meetings[i];

            if(end >= meet[0]){
                if(end < meet[1]){
                    end = meet[1];
                }else{
                    continue ;
                }
            }else{
                sortedMeets.add(new int[]{start , end});
                start = meet[0];
                end = meet[1];
            }
        }
        sortedMeets.add(new int[]{start , end});
        //we cant really travers the days as it is 10^9 
        //now sorted thus we coun the difference 
        int diff = 0 ; 
        end = 0 ; 
        for(int i = 0 ; i < sortedMeets.size() ; i++){
            int[] meet = sortedMeets.get(i);
            start = meet[0];
            diff += (start - end-1) ;
            end = meet[1]; 
        }
        diff += (days - end);
        return diff ; 
    }
}
}
