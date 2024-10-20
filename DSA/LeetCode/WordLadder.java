
import java.util.* ;

public class WordLadder {
    class Pair{
        String str ;
        int count ;
        public Pair(String s , int c){
            this.str = s ;
            this.count = c ;
        }
    }
    public int Ladder(String startWord , String targetWord , List<String> wordList){
        Queue<Pair> q = new LinkedList<>();
        Set<String> st = new HashSet<>();
        for(int i = 0 ; i < wordList.size() ; i++){
            st.add(wordList.get(i));
        }
        q.add(new Pair(startWord , 0));
        while(!q.isEmpty()){
            String word = q.peek().str;
            int count = q.peek().count;
            if(word.equals(targetWord) == true) return count ;
            for(int i = 0 ; i < word.length() ; i++){
                for(char ch = 'a' ; ch <= 'z' ; ch++){
                    char replaceCharArray[] = word.toCharArray();
                    replaceCharArray[i] = ch ;
                    String replacedWord = new String(replaceCharArray);
                    if(st.contains(replacedWord)){
                        st.remove(replacedWord);
                        q.add(new Pair(replacedWord , count + 1));
                    }
                }
            }
        }
        return 0 ;

    }   
}
