package Tries;

public class UniqueSubstring {
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
    public static int countNodes(Node root){
        if( root == null ){
            return 0 ;
        }
        int count = 0 ; 
        for(int i = 0 ; i < root.children.length ; i++){
            if(root.children[i] != null){
                count+= countNodes(root.children[i]);
            }
        }
        return count+1 ;
    }

    public static void main(String[] args){
        String str = "ababba";
        //sufffix ==> insert to trie 
        for(int i = 0 ; i < str.length() ; i++ ){
            String suffix = str.substring(i);
            insert(suffix);
        }
        System.out.println(countNodes(root));
    }
}
