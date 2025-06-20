public class Day256{
    class Solution {
    public int maxDistance(String s, int k) {
        int maxi = 0 ; 
        int x = 0 ;
        int y = 0 ;
        int n = s.length();
        for(int i = 0 ; i < n ; i++){
            char c = s.charAt(i);
            if(c == 'N') x++ ; 
            if(c == 'S') x-- ; 
            if(c == 'E') y-- ;
            if(c == 'W') y++ ; 
            int dist = Math.abs(x) + Math.abs(y);
            if(i+1 > dist){
                dist += k*2 ;
                maxi = Math.max(maxi , Math.min(dist , i+1));
            }else{
                maxi = Math.max(maxi , dist);
            }
        }
        return maxi ;
    }
}
}