//import java.util.*;

public class StringBuilder{
    public static char ch[];
    public StringBuilder(String string) {
    }

    public static void main(String args[]){
        StringBuilder sb = new StringBuilder("");
        for ( char ch = 'a' ; ch<='z' ; ch++){
            sb.append(ch);
        }//abcdefghijklmnopqrstubwxyz
        //O(26)
        //O(26*n^2)id we didnt used stringbuilder 
        //System.out.println(ch);
    //char[] ch ;
    }

    public void append(char charAt) {
    }

    public StringBuilder append(String string) {
        return null;
    }

}