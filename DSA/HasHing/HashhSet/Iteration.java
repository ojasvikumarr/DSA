package HasHing.HashhSet;
//iteration over HashSet
//a) using iterators
//b) using enhanced for loop 
import java.util.* ;
public class Iteration {
    public static void main(String[]args){
        HashSet<String> cities = new HashSet<>();
        cities.add("Delhi");
        cities.add("Goa");
        cities.add("Mumbai");
        cities.add("Banglore");
        cities.add("Chennai");
        @SuppressWarnings("checked")
        Iterator it = cities.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }

        for (String x : cities) {
            System.out.println(x);
        }//advanced loop
 
        
    }
}


