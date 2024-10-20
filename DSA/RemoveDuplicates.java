import java.io.PrintStream;

public class RemoveDuplicates {

    public static void removeDuplicates( String str, int idx , Object object , boolean map[]){// used StringBuilder for fasater//execution
        //base value
        if ( idx== str.length()){
            System.out.println(object);
            return;
        }                                                                            
        //kaam
        char currChar = str.charAt(idx);
        if(map[currChar - 'a']){
            //duplicate
             removeDuplicates(str, idx+1, object, map);
        }
        else{
            map[currChar-'a']=true ;
            removeDuplicates(str, idx+1, ((PrintStream) object).append(currChar), map);
        }

    } 
    public static void main (String args[]){
        String str = "appnnaacolleegge";
        removeDuplicates(str , 0 , new StringBuilder(""), new boolean [26]);
    }
}
