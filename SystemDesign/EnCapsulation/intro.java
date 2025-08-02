public class intro{
    // encapsulation , keeping variable and methods private and using 
    // public getters and setters to avoid direct access to the data 
    // THus better control over data flow 
    public class TrieNode{
        private TrieNode next[];
        private String word ;

         TrieNode(){
            this.next = new TrieNode[26];
            this.word = null ; public
        }
        public String getWord(){
            return this.word ;
        }
        public void setNext(){
            this.next = new TrieNode[26];
        }
        public void setWord(String word){
            this.word = word ;
        }
    }
}