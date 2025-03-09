package LeetCode;

public class Day156 {
    class Solution {
        public int numberOfAlternatingGroups(int[] colors, int k) {
            int n = colors.length;
            int count = 0;
            int left = 0;
            
            for (int right = 0; right < n + k - 1; right++) {
                if (right > 0 && colors[right % n] == colors[(right - 1) % n]) {
                    left = right;  
                }
                
                if (right - left + 1 >= k) {
                    count++;  
                }
            }
            
            return count;
        }
        public int numberOfAlternatingGroupsIII(int[] colors, int k) {
            int n = colors.length ;
             int result = 0 ; 
            for(int i = 0 ; i < n ; i++){
                int count = 1;
                i++ ; 
                while(colors[i%n] != colors[(i-1)%n]){
                    count++ ; 
                    i++ ; 
                }
                System.out.println(count);
                int diff = count - k + 1 ; 
                result += diff > 0 ? diff : 0 ;
            }
    
            return result ; 
        }
        public int numberOfAlternatingGroupsII(int[] colors, int k) {
            int result = 0 ; 
            int n = colors.length ;
            for(int i = 0 ; i < n ; i++){
                int j = i+1; 
                int count = 1; 
                boolean flag = false ;
                while(count != k){
                    if(colors[j%n] == colors[(j-1)%n]){
                        i = j ; 
                        flag = true ; 
                        break ; 
                    }
                    count++ ; 
                    j++ ; 
                }
                if(count == k) result++; 
                if(flag == false){
                    //that is we got a subarray rigt at index starting at i 
                    //so we just need to track till how much we can accept the subarray length 
                    continue ; 
                    //Or we can simply find the largest sequences lengths in the 
                    //array and simply add then to the answer 
                }
            }
            return result ; 
        }
        public int numberOfAlternatingGroupsI(int[] colors, int k) {
            int result = 0 ; 
            int n = colors.length ; 
            for(int j = 0 ; j < n ; j++){
                int i = j ; 
                int count = 0 ;
                while(colors[i % n] != colors[(i+1) % n]){
                    System.out.print(colors[i%n]);
                    i++ ;
                    count++ ;
                    if(count == k){
                        System.out.println("Break");
                        result++ ; 
                        break ;
                    }
                }
                if(count+1 == k){
                        System.out.println("Break");
                        result++ ; 
                        break ;
                }
                System.out.println();
            }
            return result ; 
        }
    }
}
