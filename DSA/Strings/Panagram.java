package Strings;

import java.util.HashSet;
import java.util.Set;

public class Panagram {
    class Solution {
    public boolean checkIfPangram(String sentence) {
        int seen = 0 ; 
        for(char c : sentence.toCharArray()){
            int ci = c - 'a';
            seen = seen | (1 << ci);
        }
        return seen == ((1 << 26) -1) ; 
    }
    public boolean checkIfPangramII(String sentence) {
        Set<Character> set = new HashSet<>();
        for(Character c : sentence.toCharArray()){
            set.add(c);
        }
        return set.size() == 26 ? true : false ;
    }
}
}
