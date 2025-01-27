package ClassImplementation ;
import java.util.*; 

public class MentionUsers {
    class Solution {
        public int[] countMentions(int n, List<List<String>> events) {
            int[] mentions = new int[n];
            Map<Integer , Integer> map = new HashMap<>();
            //We need to sort the events 
            //First on basis of timestamp 
            //Is timestamp is same then on Offline
            Collections.sort(events , (a , b) ->{
                int compare = Integer.compare(Integer.parseInt(a.get(1)),Integer.parseInt(b.get(1)));
                if(compare == 0){
                    return a.get(0).charAt(0) == 'O' ? -1 : 1 ;
                }
                return compare ;
            });
    
            for(List<String> event : events){
                String msg = event.get(0);
                Integer time = Integer.valueOf(event.get(1));
                String ids = event.get(2);
                // System.out.println(msg+" "+time+" "+ids);
                //If the msg is MESSAGE 
                if(msg.equals("MESSAGE")){
                    //We will check for ALl , Here , Ids 
                    if(ids.equals("ALL")){
                        for(int j = 0 ; j < n ; j++){
                            mentions[j]++ ;
                        }
                    }else if(ids.equals("HERE")){
                        //WE'll mention only online users 
                        for(int j = 0 ; j < n ; j++){
                            if(map.containsKey(j)){
                                if(map.get(j) <= time){
                                    map.remove(j);
                                    mentions[j]++ ;
                                }
                                continue ;
                            }
                            mentions[j]++ ;
                        }
                    }else{
                        //We've Ids that are mentioned 
                        // for(int j = 0 ; j < ids.length() ; j++){
                        //     int idx = j ; 
                        //     while(j < ids.length()){
                        //         int index = ids.charAt(j) -'0' ;
                        //         if(index >=0 && index < n){
                        //             j++ ;
                        //         }else{
                        //             break ;
                        //         }
                        //     }
                        //     if(idx < j){
                        //         int val = Integer.valueOf(ids.substring(idx , j));
                        //         mentions[val]++ ;
                        //         // map.put(val , time+60);
                        //     }
                        // }
    
                        String[] parts = ids.split(" ");
                        for(String part : parts){
                            mentions[Integer.valueOf(part.substring(2))]++ ;
                        }
                        // for(char c : ids.toCharArray()){
                        //     int index = c-'0';
                        //     if(index < n && index >= 0){
                        //         mentions[index]++ ;
                        //     }
                        // }
                    }
                }else if(msg.equals("OFFLINE")){
                    //WE need to add it into the map 
                    //We'll traverse the ids 
                    // for(int j = 0 ; j < ids.length() ; j++){
                    //     int idx = j ; 
                    //     while(j < ids.length()){
                    //         int index = ids.charAt(j) -'0' ;
                    //         if(index >=0 && index < n){
                    //             j++ ;
                    //         }else{
                    //             break ;
                    //         }
                    //     }
                    //     if(idx < j){
                    //         int val = Integer.valueOf(ids.substring(idx , j));
                    //         // mentions[val]++ ;
                    //         map.put(val , time+60);
                    //     }
                    // }
    
                    map.put(Integer.valueOf(ids) , time + 60);
                    // for(char c : ids.toCharArray()){
                    //     int index = c-'0';
                    //     if(index < n && index >= 0){
                    //         map.put(index , time+60);
                    //     }
                    // }
                }
            }
            return mentions ; 
        }
    }
}
