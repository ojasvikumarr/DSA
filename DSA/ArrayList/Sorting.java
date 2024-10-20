//import java.util.* ;
import java.util.ArrayList;
import java.util.Collections;
public class Sorting {
    /*Collection is an interface
     while collections is a class*/ 
    public static void main( String args[] ){
    ArrayList<Integer> list = new ArrayList<>();
    list.add(9);
    list.add(2);
    list.add(6);
    list.add(10);
    System.out.println(list);
    Collections.sort(list);
    System.out.println(list);
    //Desending order
    Collections.sort(list,Collections.reverseOrder());
    System.out.println(list);
    }
}
