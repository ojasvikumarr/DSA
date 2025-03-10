package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class Day157 {
    class Solution {
    public long countOfSubstringsII(String word, int k) {
        int l = 0 ; 
        int r = 0 ; 
        int n = word.length();
        Map<Character , Integer> vowels = new HashMap<>();
        int consonants = 0 ; 
        long result = 0 ; 

        while(l < n && r < n){
            while(vowels.size() != 5 && r < n ){
                char c = word.charAt(r);
                r++ ; 
                if(checkAlpha(c)){
                    vowels.put(c , vowels.getOrDefault(c , 0)+1);
                }else{
                    consonants++ ; 
                }
            }
            //Once we have all the desired vowels in the window 
            //Now we will check for number of consonants ; 
            while(vowels.size() == 5 && consonants <= k && r < n){
                //we dont have enough desired consonants thus incre r pointer 
                char c = word.charAt(r);
                if(vowels.size() == 5 && consonants == k) result++ ;
                if(checkAlpha(c)){
                    vowels.put(c , vowels.getOrDefault(c , 0)+1);
                }else{
                    consonants++ ; 
                }
                // if(vowels.size() == 5 && consonants == k) result++ ; 
                r++ ;
            }
            // while(vowels.size() == 5 && consonants == k && r < n){
            //     //we dont have enough desired consonants thus incre r pointer 
            //     result++ ; 
            //     char c = word.charAt(r);
            //     if(checkAlpha(c)){
            //         vowels.put(c , vowels.getOrDefault(c , 0)+1);
            //     }else{
            //         consonants++ ; 
            //     }
            //     r++ ;
            // }
            // while(consonants == k && vowels.size() == 5 && l < n){
            //     //we add that window to our answer ;
            //     result++ ; 
            //     //And increment l 
            //     char last = word.charAt(l);
            //     if(checkAlpha(last)){
            //         //that a vowel 
            //         int freq = vowels.get(last);
            //         if(freq == 1){
            //             vowels.remove(last);
            //         }else{
            //             vowels.put(last , freq-1);
            //         }
            //     }else{
            //         //its a consonant 
            //         consonants-- ; 
            //     }
            //     l++ ; 
            // }
            while(consonants >= k && vowels.size() == 5 && l < n){
                //we have excess of consonants thus decrement them 
                char last = word.charAt(l);
                if(vowels.size() == 5 && consonants == k) result++ ;
                if(checkAlpha(last)){
                    //that a vowel 
                    int freq = vowels.get(last);
                    if(freq == 1){
                        vowels.remove(last);
                    }else{
                        vowels.put(last , freq-1);
                    }
                }else{
                    //its a consonant 
                    consonants-- ; 
                }
                
                l++ ;
            }
            
        }
        return result ; 
    }
    public boolean checkAlpha(char c){
        if(c == 'a' || c == 'i' || c == 'o' || c == 'u' || c == 'e'){
            return true ;
        }else{
            return false ;
        }
    }
    public long countOfSubstrings(String word, int k) {
        long numValidSubstrings = 0;
        int start = 0;
        int end = 0;
        // keep track of counts of vowels and consonants
        HashMap<Character, Integer> vowelCount = new HashMap<>();
        int consonantCount = 0;

        // compute index of next consonant for all indices
        int[] nextConsonant = new int[word.length()];
        int nextConsonantIndex = word.length();
        for (int i = word.length() - 1; i >= 0; i--) {
            nextConsonant[i] = nextConsonantIndex;
            if (!checkAlpha(word.charAt(i))) {
                nextConsonantIndex = i;
            }
        }

        // start sliding window
        while (end < word.length()) {
            // insert new letter
            char newLetter = word.charAt(end);

            // update counts
            if (checkAlpha(newLetter)) {
                vowelCount.put(
                    newLetter,
                    vowelCount.getOrDefault(newLetter, 0) + 1
                );
            } else {
                consonantCount++;
            }

            // shrink window if too many consonants in our window
            while (consonantCount > k) {
                char startLetter = word.charAt(start);
                if (checkAlpha(startLetter)) {
                    vowelCount.put(
                        startLetter,
                        vowelCount.get(startLetter) - 1
                    );
                    if (vowelCount.get(startLetter) == 0) {
                        vowelCount.remove(startLetter);
                    }
                } else {
                    consonantCount--;
                }
                start++;
            }

            // while we have a valid window, try to shrink it
            while (
                start < word.length() &&
                vowelCount.keySet().size() == 5 &&
                consonantCount == k
            ) {
                // count the current valid substring, as well as valid substrings produced by appending more vowels
                numValidSubstrings += nextConsonant[end] - end;
                char startLetter = word.charAt(start);
                if (checkAlpha(startLetter)) {
                    vowelCount.put(
                        startLetter,
                        vowelCount.get(startLetter) - 1
                    );
                    if (vowelCount.get(startLetter) == 0) {
                        vowelCount.remove(startLetter);
                    }
                } else {
                    consonantCount--;
                }

                start++;
            }
            end++;
        }

        return numValidSubstrings;
    }
}
}
