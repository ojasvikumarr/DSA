package Strings;

import java.util.ArrayList;
import java.util.List;

public class hasMatch {
    class Solution {
    public boolean hasMatch(String s, String p) {
    int idx = p.indexOf('*');

    // If no '*' in pattern, check direct equality
    if (idx == -1) {
        return s.equals(p);
    }

    String prefix = p.substring(0, idx); // Part before '*'
    String suffix = p.substring(idx + 1); // Part after '*'

    // Check prefix and suffix conditions
    int prefixIdx = s.indexOf(prefix);
    //this line starts the search of suffix string after the prefix index 
    int suffixIdx = s.indexOf(suffix, prefixIdx + prefix.length());

    // Both prefix and suffix should exist in order
    if (!prefix.isEmpty() && prefixIdx == -1) return false;
    if (!suffix.isEmpty() && suffixIdx == -1) return false;

    // Ensure suffix comes after prefix
    return prefix.isEmpty() || suffix.isEmpty() || prefixIdx + prefix.length() <= suffixIdx;
}
    public boolean hasMatchVI(String s, String p) {
        int idx = p.indexOf('*');
        String prefix = p.substring(0 , idx);
        String suffix = p.substring(idx+1);
        System.out.println(prefix + " " + suffix);
        if((prefix.length() > 0 && s.contains(prefix) )&& (suffix.length() > 0 && s.contains(suffix)) && s.indexOf(prefix) < s.indexOf(suffix)){
            return true ;
        }else if(prefix.length() == 0 && s.contains(suffix)){
            return true ;
        }else if(suffix.length() == 0 && s.contains(prefix)){
            return true ;
        }else if(suffix.length() == 0 && prefix.length() == 0){
            return true;
        }
        return false ;
    }
    public boolean hasMatchV(String s, String p) {
        int idx = p.indexOf('*');
        if(idx == -1) return s.equals(p);
        // String prefix = p.substring(0 , idx);
        // String suffix = p.substring(idx+1);

        List<String> arr = new ArrayList<>();
        for(int i = 0 ; i < p.length() ; i++){
            if(p.charAt(i) == '*'){
                arr.add(p.substring(0 , i));
                arr.add(p.substring(i+1));
            }
        }
        int l = s.indexOf(arr.get(0));
        if(l == -1){
            return false ;
        }
        int ll = s.indexOf(arr.get(1) , l + arr.get(0).length());
        if(ll == -1){
            return false ;
        }
        return true ;
    }
    public boolean hasMatchIIIII(String s, String p) {
        int sLen = s.length();
        int pLen = p.length();
        
        int i = 0, j = 0;
        int starIdx = -1, matchIdx = 0;

        while (i < sLen) {
            if (j < pLen && (p.charAt(j) == s.charAt(i) || p.charAt(j) == '*')) {
                if (p.charAt(j) == '*') {
                    starIdx = j;
                    matchIdx = i;
                    j++;
                } else {
                    i++;
                    j++;
                }
            } else if (starIdx != -1) {
                j = starIdx + 1;
                matchIdx++;
                i = matchIdx;
            } else {
                return false;
            }
        }

        while (j < pLen && p.charAt(j) == '*') {
            j++;
        }

        return j == pLen;
    }
    public boolean hasMatchII(String s, String p) {
        int idx = p.indexOf('*');
        if(idx == -1) return s.equals(p);
        String prefix = p.substring(0 , idx);
        String suffix = p.substring(idx+1);
        if(s.length() >= prefix.length() + suffix.length()){
            return s.startsWith(prefix) && s.endsWith(suffix) ;
        }

        // int i = 0  ;
        // int j = 0 ; 
        // while(i < s.length()){
        //     if(s.charAt()
        // }
        return false ;
    }
    public boolean hasMatchIII(String s, String p) {
        String[] parts = p.split("\\*");
        String prefix = parts[0];
        String suffix = parts.length > 1 ? parts[1] : "";

        for(int i = 0 ; i <= s.length() - prefix.length() - suffix.length() ; i++){
            if(s.startsWith(prefix, i) && s.startsWith(suffix , i+prefix.length())){
                return true ;
            }
        } 
        return false ;
    }
}
}
