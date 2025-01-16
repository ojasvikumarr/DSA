package Strings ;
public class FirstOcc{
    class Solution {
        public int strStr(String haystack, String needle) {
            // O(n*m)
            // return haystack.indexOf(needle);
            // return solve(haystack , needle);
            return kmp(haystack , needle);
        }
        //O(n*m)
        public int solve(String txt , String pattern){
            int n = txt.length();
            int m = pattern.length();
            if( n < m ) return -1 ; 
            int i = 0 ; 
            int j = 0 ; 
            while(i < n && j < m){
                int curr = i ;
                while(txt.charAt(i) == pattern.charAt(j)){
                    i++ ; 
                    j++ ; 
                    if(j == m){
                        return i - j ;
                    }else if(i == n){
                        return -1 ;
                    }
                }
                i = curr+1 ; 
                j = 0 ; 
            }
            return -1 ; 
        }
        // O(N) in best case 
        public int kmp(String txt , String pattern){
            //Creation of LSP 
            int n = txt.length();
            int m = pattern.length();
            int[] lsp = new int[m];
            lsp[0] = 0 ;
            int i = 1 ; 
            int len = 0 ; 
            while(i < m){
                if(pattern.charAt(i) == pattern.charAt(len)){
                    len++ ;
                    lsp[i] = len ;
                    i++ ;
                }else{
                    if(len != 0){
                        // lsp[i] = len ;
                        len = lsp[len-1];
                    }else{
                        lsp[i] = 0 ; 
                        i++ ;
                    }
                }
            }
    
            i = 0 ; 
            int j = 0; 
    
            while( i < n ){
                if(txt.charAt(i) == pattern.charAt(j)){
                    i++ ; 
                    j++ ; 
                    if(j == m){
                        return i-j ;
                    }
                }else{
                    if(j != 0){
                        j = lsp[j-1];
                    }else{
                        i++ ;
                    }
                }
            }
            return - 1; 
        }
    }
}