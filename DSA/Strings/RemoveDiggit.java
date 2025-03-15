package Strings;

import java.util.TreeSet;

public class RemoveDiggit {
    class Solution {
    public String removeDigit(String number, char digit) {
        TreeSet<String> set = new TreeSet<>((a , b) ->{
            if(a.length() == b.length()){
                for(int i = 0 ; i < a.length() ; i++){
                    if(a.charAt(i) != b.charAt(i)){
                        return b.charAt(i) - a.charAt(i);
                    }
                }
                return 0 ; 
            }else{
                return b.length() - a.length();
            }
        });
        for(int i = 0 ; i < number.length() ; i++){
            if(number.charAt(i) == digit){
                set.add(number.substring(0 , i)+number.substring(i+1));
            }
        }
        // int result = set.first();
        return set.first();
    } 
}
}
