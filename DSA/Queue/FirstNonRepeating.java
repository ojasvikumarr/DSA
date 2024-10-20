package Queue;
import java.util.*;
import java.util.LinkedList;
public class FirstNonRepeating {
    public static void FirstnonRepeating(String str){
        int freq[] = new int[26]; //array to hold the number of reapeting char 
        Queue<Character> q = new LinkedList<>();
        for( int i = 0 ; i<str.length() ; i++ ){
            char ch = str.charAt(i);
            freq[ch - 'a']++ ;
            q.add(ch);
            while( !q.isEmpty() && freq[ch-'a'] > 1){
                q.remove();
            }
            if( q.isEmpty()){
                System.out.print(-1+" ");
            }
            else{
                System.out.print(q.peek()+" ");
            }
        }
        System.out.println();
    }
    public static void main(String args[]){
        String str = "aabccxb";
        FirstnonRepeating(str);
        System.out.println(str);
    }
}
