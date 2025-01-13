package Strings;

public class LexiLargestString {
    class Solution {
        public String answerString(String word, int numFriends) {
            int n = word.length();
            int atMax = n - numFriends + 1;
            String result = "";
            if(numFriends == 1) return word ;
            for(int i = 0 ; i < n ; i++){
                String sub = "";
                if(i+atMax < word.length()){
                    sub = word.substring(i , i+atMax);
                }else{
                    sub = word.substring(i);
                }
                if((result.length() == 0 )|| (sub.length() >= result.length() || sub.charAt(0) - result.charAt(0) >= 0)){
                    if (result.compareTo(sub) <= 0) {
                        result = sub;
                    }
                }
            }
            return result;
        }
        public String answerStringII(String word, int numFriends) {
            int n = word.length();
            int atMax = n - numFriends + 1;
            String result = "";
            if(numFriends == 1) return word ;
            // List<String> ls = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j <= i + atMax && j <= n; j++) { 
                    String sub = word.substring(i, j);
                    // System.out.println(sub);
                    // ls.add(sub);
                    if((result.length() == 0 )|| (sub.length() >= result.length() || sub.charAt(0) - result.charAt(0) >= 0)){
                        if (result.compareTo(sub) <= 0) {
                            result = sub;
                        }
                    }
                }
            }
            // Collections.sort(ls);
            // return ls.get(ls.size()-1);
            return result;
        }
    }
}
