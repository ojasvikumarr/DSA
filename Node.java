class Trie {
    Node root ;
    public Trie() {
        Node root ;
    }
    public void insertUtil(Node root , String word){
        //if word.length ==0 
        if(word.length() == 0){
            root.isTerminal = true;
        }
        int index = word.charAt(0) - 'a';
        Node child ; 
        if(root.children[index] != null){
            child = root.children[index];
        }else{
            child = new Node(word.charAt(0));
            root.children[index] = child ;
        }
        insertUtil(child , word.substring(1));
    }
    public void insert(String word) {
        insertUtil(root , word);
    }
    
    public boolean searchUtil(Node root , String word){
        if(word.length() == 0){
            return root.isTerminal ;
        }
        Node child ;
        int index = word.charAt(0) - 'a';
        if(root.children[index] != null){
            child = root.children[index];
        }else{
            return false ;
        }
        return searchUtil(child , word.substring(1));

    }
    public boolean search(String word) {
        return searchUtil(root , word);
    }
    
    public boolean removeUtil(Node root , String word){
        if(word.length() == 0){
            root.isTerminal = false ;
            root = null ;
            return true ;
        }
        //if the length of the word isnt 0 thus lets check an dreach to the last element 
        int index = word.charAt(0) - 'a';
        Node child ; 
        if(root.children[index] != null){
            child = root.children[index];
            root.children[index] = null ;
        }else{
            return false ;
        }
        return removeUtil(child , word.substring(1));

    }
    public void remove(String word){
        if(removeUtil(root , word)){
            System.out.println("Removed!");

        }else{
            System.out.println("Word doesnot exists");
        }
    }

    // public boolean startsWith(String prefix) {
        
    // }
}
public class Node{
    char data ; 
    Node[] children = new Node[26];
    boolean isTerminal ;
    public Node(char w){
        this.data = w ;
        for(int i = 0; i < 26; i++){
            children[i] = null ;
        }
        isTerminal = false ; 
    }
}
/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */