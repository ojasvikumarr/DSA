import java.util.List;
import java.util.* ;

public class WordLadderII {
    class Pair{
        String str ;
        List<List<String>> st ;
        public Pair(String s , List<List<String>>st){
            this.str = s ;
            this.st = st ;
        }
    }
    public void findLadders(String beginWord, String endWord, List<String> wordList){
        Queue<Pair> q = new LinkedList<>();
        List<List<String>> st = new ArrayList<>();
        Set<String> set = new HashSet<>();
        for(int i = 0 ; i < wordList.size() ; i++){
            set.add(wordList.get(i));
        }
        int j = 0 ;
        q.add(new Pair(beginWord , st));
        while(!q.isEmpty()){
            String word = q.peek().str;
            List<List<String>> s = q.peek().st ;
            q.remove();
            j++ ;
            for(int i = 0 ; i < word.length() ; i++){
                for(char ch = 'a' ; ch < 'z' ; ch++){
                    char[] replacedWord = word.toCharArray();
                    replacedWord[i] = ch ;
                    String newWord = new String(replacedWord);
                    if(set.contains(newWord)){
                        st.get(i).add(newWord);
                    }
                }
            }
        }
    }
}
