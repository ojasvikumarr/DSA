package Strings;

import java.util.Arrays;

public class BuddyStrings {
    class Solution {
    public boolean buddyStrings(String s, String goal) {
        
        int n = s.length();
        int m = goal.length();
        if(n != m) return false ;
        char[] arr1 = s.toCharArray();
        char[] arr2 = goal.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        boolean duplicate = false ;
        for(int i = 0 ; i < n ; i++){
            if(arr1[i] != arr2[i]) return false ;
            if(i > 0 && arr1[i] == arr1[i-1]) duplicate = true ;
        }

        if(s.equals(goal)){
            //Now check if duplicate exists 
            if(duplicate){
                return true ;
            }else{
                return false ;
            }
        }

        int count = 0 ;
        for(int i = 0 ; i < n ; i++){
            if(s.charAt(i) != goal.charAt(i)) count++ ;
        }
        return count == 2 ;
    }
}
}
