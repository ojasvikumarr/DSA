package HasHing.HashMap;
// Given two strings s and t, return true if t is an anagram of s, and false otherwise.
// An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
// s = "race" t="care"  TRUE
// S= "heart" †="earth"   TRUE
// s= "tulip" t = "lipid"  FALSE
import java.util.* ;
public class ValidAnagram {

    // public static boolean isAnangram(String s , String t){
    //     if(s.length() != t.length()){
    //         return false ;
    //     }
    //     HashMap<Character , Integer> map = new HashMap<>();

    //     for( int i = 0 ; i < s.length() ; i++ ){
    //         char ch = s.charAt(i);
    //         map.put(ch , map.getOrDefault(ch , 0 )+1);
    //     }

    //     for(int i = 0 ; i < t.length() ; i++ ){
    //         char ch = t.charAt(i);
    //         if(map.get(ch) != null){
    //             if(map.get(ch) == 1){
    //                 map.remove(ch);
    //             }

    //             else{
    //                 map.put(ch , map.get(ch)-1);
    //             }
    //         }else{
    //             return false ;
    //         }
    //     }
    //     return map.isEmpty() ;
    // }
    // public static void main(String args[]){
    //     String s = "race";
    //     String t = "care";
    //     System.out.println(isAnangram(s, t));
    // }   

    public static boolean ValidAnaddram(String s , String t){
        if(s.length() != t.length()){
            return false ;
        }

        HashMap<Character , Integer> SS = new HashMap<>();

        for( int i = 0 ; i < s.length() ; i++ ){
            SS.put(s.charAt(i) , SS.getOrDefault(s.charAt(i) , 0)+1);
        }
        for(int i = 0 ; i < t.length() ; i++ ){
            char ch = t.charAt(i);
            if(SS.get(ch) != null){
                if(SS.get(ch) == 1){
                    SS.remove(ch);
                }else{
                    SS.put(ch , SS.get(ch)-1);
                }
            }else{
                return false ;
            }
        }
        return SS.isEmpty();
    }
    public static void main(String [] args){

    }
}
