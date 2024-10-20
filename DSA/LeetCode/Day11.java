public class Day11 {
    public int trap(int[] height){
        int n = height.length ;
        int[] leftAx = new int[n];
        int[] rightAx = new int[n];
        for(int i = 0 ; i < n ;i++ ){
            for(int j = i ; j >= 0 ; j--){
                if(height[i] <= height[j]){
                    leftAx[i] = height[j];
                }
            }
        }
        for(int i = n-1 ; i >= 0 ; i-- ){
            for(int j = i ; j < n ; j++){
                if(height[i] <= height[j]){
                    rightAx[i] = height[j];
                }
            }
        }
        int water = 0 ;
        for(int i = 0 ; i < n ; i++){
            int diff = Math.min(leftAx[i] , rightAx[i]);
            if((diff-height[i]) > 0 ){
                water += (diff-height[i]);
            }
        }
        return water ;
    }
}
