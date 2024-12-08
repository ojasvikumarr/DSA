public class Day64 {
    class Solution {
        public int maxTwoEvents(int[][] events) {
            // Arrays.sort(events , (x , y) -> {
            //     if(y[2] == x[2]){
            //         return x[0] - y[0];
            //     }else{
            //         return y[2] - x[2];
            //     }
            // });
            int maxi = 0 ;
            for(int i = 0 ; i < events.length ; i++){
                maxi = Math.max(maxi , events[i][2]);
                for(int j = i+1 ; j < events.length ; j++){
                    if(events[j][1] < events[i][0]){
                        maxi = Math.max(maxi , events[i][2] + events[j][2]);
                    }else if(events[j][0] > events[i][1]){
                        maxi = Math.max(maxi , events[i][2] + events[j][2]);
                    }
                }
            }
            return maxi ;
        }
    }
}
