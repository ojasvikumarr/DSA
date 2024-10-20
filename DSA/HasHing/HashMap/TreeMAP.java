package HasHing.HashMap;
import java.util.* ;

//Keys are sorted 
// put , get , remove are O(logn)


public class TreeMAP {
    public static void main( String[] args ){
        TreeMap<String , Integer> TM = new TreeMap<>();
        TM.put("India" , 100);
        TM.put("Us" , 200);
        TM.put("Pakistan" , 29);
        System.out.println(TM);
    }

}
