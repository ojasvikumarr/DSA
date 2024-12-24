public class ArithemticSlice {
    class Solution {
        public int numberOfArithmeticSlices(int[] arr) {
            if(arr.length < 3) return 0 ; 
    
            int l = 0 ; 
            int diff = arr[1] - arr[0] ; 
            int count = 0 ;
            for(int r = 2 ; r < arr.length ; r++){
                if(arr[r] - arr[r-1] == diff){
                    count += r-l-1 ;
                }else{
                    l = r-1 ;
                    diff = arr[r] - arr[r-1];
                }
            }
            return count ;
        }
    }
}
