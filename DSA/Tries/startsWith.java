package Tries;

public class startsWith {
    static class Node{
        Node children[] = new Node[26];
        boolean eow ;
        public Node(){
            for( int i = 0 ; i < children.length ; i++ ){
                children[i] = null ;
            }
            eow = false ;
        }
    }
    public static Node root = new Node() ;
    public static void insert(String words){
        Node curr = root ;
        for( int i = 0 ; i < words.length() ; i++ ){
            int idx = words.charAt(i) - 'a';
            if(curr.children[idx] == null){
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx] ;
        }
        curr.eow = true ;
    }
    public static boolean startWith(String word){
        Node curr = root ;
        for( int i = 0 ; i < word.length() ; i++ ){
            int idx = word.charAt(i) - 'a';
            if(curr.children[idx] == null){
                return false ;
            }
            curr = curr.children[idx];
        }
        return true ;
    }

}
