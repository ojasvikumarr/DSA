package Strings;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class SortVowels {
    class Solution {
    public String sortVowels(String s) {
        // System.out.println('E' - 'e');
        return solve(s);
    }
    public String solve(String s){
        List<Character> vowels = new ArrayList<>();
        vowels.add('A');
        vowels.add('E');
        vowels.add('I');
        vowels.add('O');
        vowels.add('U');
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');

        // List<Character> ls = new ArrayList<>();
        PriorityQueue<Character> pq = new PriorityQueue<>();

        //O(n)
        for(char c : s.toCharArray()){
            //O(1)
            if(vowels.contains(c)){
                // ls.add(c);
                pq.add(c);
            }
        }
        //O(kLogK)
        // Collections.sort(ls , (a,b) -> a - b);

        StringBuilder t = new StringBuilder();
        //O(n*K)
        for(char c : s.toCharArray()){
            if(vowels.contains(c)){
                // t.append(ls.get(0));
                // O(k) because of removal --> causes shifting 
                // ls.remove(0);

                t.append(pq.poll());
            }else{
                t.append(c);
            }
        }

        //O(n*k)
        return t.toString();
    }
}
}
