package Tries;

public class LongestWord {
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
    public static String ans = "";
    public static void LongestWordWithAllItsPrefixIntheList(Node root , StringBuilder temp){
        if(root == null){
            return ;
        }
        for(int i = 0 ; i< 26 ; i++){
            if(root.children[i] != null && root.children[i].eow == true){
                char ch = (char)(i + 'a');
                temp.append(ch);
                if(temp.length() >  ans.length()){
                    ans = temp.toString();
                }
                LongestWordWithAllItsPrefixIntheList(root.children[i], temp);
                temp.deleteCharAt(temp.length()-1);//backtrack
            }
        }
    }
}
