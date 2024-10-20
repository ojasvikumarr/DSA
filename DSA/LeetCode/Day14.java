import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.HashMap ;

public class Day14 {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> analgram = new ArrayList<>();
        if(strs.length == 0){
            return analgram ;
        }
        for(int i = 0 ; i < strs.length ; i++){
            HashMap<Character , Integer> map1 = new HashMap<>();
            analgram.add(new ArrayList<>());
            char[] ch = strs[i].toCharArray();
            for(Character c : ch){
                map1.put(c , map1.getOrDefault(c , 0)+1);
            }
            for(int j = i+1 ; j < strs.length ; j++){
                char[] chInner = strs[j].toCharArray() ;
                boolean flag = true ;
                for(Character c : chInner){
                    if(!map1.containsKey(c)){
                        flag = false ;
                        break ;
                    }
                }
                if(flag){
                    analgram.get(i).add(strs[j]);
                }
            }
        }
        return analgram ;

//         List<List<String>> anagramGroups = new ArrayList<>();
// if (strs.length == 0) {
//     return anagramGroups;
// }
// Map<String, Integer> map = new HashMap<>(); // Store the index of the group corresponding to each sorted string
// for (String str : strs) {
//     // Convert string to char array, sort it, and then convert back to string
//     char[] charArray = str.toCharArray();
//     Arrays.sort(charArray);
//     String sortedStr = new String(charArray);

//     // Check if the sorted string exists in the map
//     // If not, create a new group, add it to anagramGroups, and store its index in the map
//     if (!map.containsKey(sortedStr)) {
//         List<String> newGroup = new ArrayList<>();
//         newGroup.add(str);
//         anagramGroups.add(newGroup);
//         map.put(sortedStr, anagramGroups.size() - 1);
//     } else {
//         // If the sorted string exists in the map, add the string to the corresponding group
//         int index = map.get(sortedStr);
//         anagramGroups.get(index).add(str);
//     }
// }
// return anagramGroups;
    }
}
