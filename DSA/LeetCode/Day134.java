package LeetCode ; 

// import java.util.* ; 
public class Day134 {
    class Solution {
        public String smallestNumber(String pattern) {
            int n = pattern.length();
    
            int[] arr = new int[n+1];
            for(int i = 0 ; i <= n ; i++) arr[i] = i+1 ;
    
            int i = 0 ; 
            while( i < n ){
                if(pattern.charAt(i) == 'D'){
                    int itr = i ; 
                    while(itr < n && pattern.charAt(itr) == 'D') itr++ ; 
                    int noOfDs = itr ;
                    //we'll be reverse sort or swap the elements from i to itr ; 
                    swap(arr , i , noOfDs);
                    i = itr ;
                }else{
                    i++ ; 
                }
            } 
    
            // return Arrays.toString(arr);
            StringBuilder sb = new StringBuilder();
            for(Integer it : arr) sb.append(it);
            return sb.toString();
        }
        public void swap(int[] arr , int i , int itr){
            int l = i; 
            int r = itr ; 
            while( l < r ){
                int temp = arr[l];
                arr[l] = arr[r];
                arr[r] = temp ; 
                l++ ; 
                r-- ;
            }
        }
    }
}
