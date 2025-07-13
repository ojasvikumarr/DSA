class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);
        int i = 0 ; 
        int j = 0 ; 
        int n = players.length ; 
        int m = trainers.length ; 
        int count = 0 ; 
        while(i < n && j < m ){
            if(players[i] <= trainers[j]){
                i++ ;
                j++ ; 
                count++ ; 
            }else{
                j++ ;
            }
        }
        return count ;
    }
    // public boolean binarySearch(int[] trainers , int target){
    //     int lo = 0 ; 
    //     int hi = trainers.length ; 
    //     int idx = -1 ;
    //     while( lo <= hi ){
    //         int mid = lo + (hi - lo)/2 ; 
    //         if(trainers[mid] >= target){
    //             idx = mid ;
    //             hi = mid - 1 ; 
    //         }else{
    //             lo = mid + 1 ;
    //         }
    //     }
    //     if(idx != -1){
    //         trainers[idx] = -1 ;
    //     }
    //     return idx ; 
    // }
}