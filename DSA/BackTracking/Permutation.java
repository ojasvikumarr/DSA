package BackTracking;

public class Permutation {
    public static void Perma( String ans , String str){
        if(str.length() == 0){
            System.out.println(ans);
            return;
        }
        for( int i= 0 ; i < str.length() ; i++){
            char curr = str.charAt(i);
            String newStr = str.substring(0, i) + str.substring(i+1);//nothing mentioned means n-1
            Perma(ans+curr, newStr);
        }
    }
    public static void main( String args[]){
        String str = "abc";
        Perma("", str);
    }
}
