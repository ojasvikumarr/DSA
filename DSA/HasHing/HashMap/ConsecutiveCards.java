package HasHing.HashMap;

import java.util.Map;
import java.util.* ; 
public class ConsecutiveCards {
    class Solution {
    public int minimumCardPickup(int[] cards) {
        //if all unique card then return 0 
        // store map key --> indices and get the min difference btw the indices 
        //even better just have a map and store the key with its latest index in it 
        // and take out min diff
        int mini = Integer.MAX_VALUE ;
        Map<Integer , Integer> map = new HashMap<>();
        for(int i = 0 ; i < cards.length ; i++){
            if(map.containsKey(cards[i])){
                mini = Math.min(mini , i - map.get(cards[i]));
            }
            map.put(cards[i] , i);
        }
        mini =( mini == Integer.MAX_VALUE ? -2 : mini ); 
        return mini+1 ; 
    }
}
}
