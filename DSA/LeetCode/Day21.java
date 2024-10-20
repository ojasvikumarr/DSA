import java.util.* ;

class Day21 {
    // public int majorityElement(int[] nums) {
    //     HashMap<Integer , Integer> map = new HashMap<>();
    //     for(int i : nums){
    //         map.put(i , map.getOrDefault(i , 0)+1);
    //     }
    //     int max = 0 ;
    //     for(int i = 0 ; i < map.size() ; i++){
    //         if(max < map.get(i)){
    //             max = map.get(i);
    //         }
    //     }
    //     int maxElement = 0 ;
    //     // for(int i = 0 ; i < map.size() ; i++){
    //     //     if(max == map.get(i)){

    //     //     }
    //     // }
    // }

    public int majorityEleement(int[] nums) {
        HashMap<Integer , Integer> map = new HashMap<>();
        for(int i : nums){
            map.put(i , map.getOrDefault(i , 0)+1);
        }
        Map.Entry<Integer, Integer> maxEntry = null;

        // Iterate through the entries of the HashMap
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            // Check if maxEntry is null or if the frequency of the current entry is greater than the frequency of maxEntry
            if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0) {
                // If yes, update maxEntry
                maxEntry = entry;
            }
        }

        return maxEntry.getValue();
    }

    public int Maj(int[] nums){
        int max = 0 ; 
        // Arrays.sort(nums);
        int count = 0 ;
        for(int i = 0 ; i < nums.length ; i++){
            if(i>0 && nums[i] != nums[i-1]){
                count = 0 ;
            }
            // if(i == 0){
            //     count++ ;
            // }
            // if( i > 0 && nums[i] == nums[i-1] ){
            //     count++ ;
            // }
            count++ ;
            if(count > nums.length/2){
                max = nums[i];
            }
        }
        return max ;
    }
}