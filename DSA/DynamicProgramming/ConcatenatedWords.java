package DynamicProgramming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class ConcatenatedWords {
    class Solution {
//this is a global list for stroing answer 
    private List<String> list ; 
//Set to keep track of words 
//(to check whther the prefix and suffix exists in list or not )
    private HashSet<String> set ;
//THis is to memoize the solution to remove TLE 
    private Map<String , Boolean> memo ;
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        list = new ArrayList<>();
        set = new HashSet<>();
        memo = new HashMap<>();
//We store each word in set 
        for(String word : words) set.add(word);
//we run this function on each word from the list 
        for(String word : words){
//if true we add it in the list 
//Now come to the function down below 
            if(isConcatenated(word)) list.add(word);
        }
        return list ;
    }

//Heres the main recursion
    public boolean isConcatenated(String str){
//this is simple dynamic programming caching the result 
        if(memo.containsKey(str)) return memo.get(str);


//splitting the word at every index and checking whther 
//it exists in the list or not 
        for(int i = 0 ; i < str.length() ; i++){
            String prefix = str.substring(0 , i+1);
            String suffix = str.substring(i+1 , str.length());
            if((set.contains(prefix) && set.contains(suffix) )|| (set.contains(prefix) && isConcatenated(suffix))){
//recursively breaking the suffix into further pieces 
//for the case if the suffix is made up of many small words 
                memo.put(str , true );
                return true ;
            }
        }
        memo.put(str , false);
        return false ; 
    }
}
}
