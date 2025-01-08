package Strings;

import java.util.ArrayList;
import java.util.List;

public class WordSearchII {
    class Solution {
    class TrieNode{
        TrieNode[] next = new TrieNode[26];
        String word ;
    }
    public TrieNode buildTrie(String[] words){
        TrieNode root = new TrieNode();
        for(String w : words){
            TrieNode p = root ; 
            for(char c : w.toCharArray()){
                int i = c - 'a';
                if(p.next[i] == null){
                    p.next[i] = new TrieNode();
                }
                p = p.next[i];
            }
            p.word = w ;
        }
        return root ;
    }
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        TrieNode root = buildTrie(words);
        for(int i = 0 ; i < board.length ; i++){
            for(int j = 0 ; j < board[0].length ; j++){
                dfs(board , i , j , root , res);
            }
        }
        return res ;
    }
    public void dfs(char[][] board , int i , int j , TrieNode p , List<String> res){
        char c = board[i][j];
        //either the word is visited or there is no trie for the character 
        if(c == '$' || p.next[c - 'a'] == null) return ;
        //We move to the next trie
        p = p.next[c - 'a'];
        //If the terminal is true that its an end for a word then add it in the result 
        if(p.word != null){
            res.add(p.word);
            p.word = null ; //Once added we remove the word from the trie (No duplicates)
        }

        board[i][j] = '$'; //Marks as visited 
        if(i > 0) dfs(board , i-1 , j , p , res);
        if(j > 0) dfs(board , i , j-1 , p , res);
        if(i < board.length - 1) dfs(board , i+1 , j , p , res);
        if(j < board[0].length - 1) dfs(board , i , j+1 , p , res);
        //Now bactrack and replace the character 
        //Or we can say mark the node unvisited 
        board[i][j] = c ;
    }
}
}
