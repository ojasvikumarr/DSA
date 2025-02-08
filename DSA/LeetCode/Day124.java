package LeetCode;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Day124 {
    class NumberContainers {
    Map<Integer , TreeMap<Integer , Integer>> map ;
    Map<Integer , Integer> idxMap ;
    public NumberContainers() {
        map = new HashMap<>();
        idxMap = new HashMap<>();
    }
    
    public void change(int index, int number) {
        if(idxMap.containsKey(index)){
            //This means that theres a number already in the system 
            //We'll have to remove it from there
            int num = idxMap.get(index);
            map.get(num).remove(index);
            idxMap.put(index , number);
            map.putIfAbsent(number , new TreeMap<>());
            map.get(number).put(index , 0);
            // System.out.println(map.get(number).firstKey());
        }else{
            //Its is the first time 
            idxMap.put(index , number);
            map.putIfAbsent(number , new TreeMap<>());
            map.get(number).put(index , 0);
        }
    }
    
    public int find(int number) {
        if(map.containsKey(number) && map.get(number).size() != 0){
            return map.get(number).firstKey();
        }else{
            return -1 ; 
        }
    }
}

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */
}
