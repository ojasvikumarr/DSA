package HasHing.HashhSet;
//Used to store unique value
//no duplicates 
//unordered
//Null is allowed 
//HashMap is almost same as hashset
// hashset is made using hashmap
import java.util.HashSet;
public class intro {
    public static void main(String[] args){
        HashSet<Integer> hs = new HashSet<>();
        hs.add(1);
        hs.add(2);
        hs.add(4);
        hs.add(2);
        System.out.println(hs);
        if(hs.contains(2)){
            System.out.println("Set contains 2");
        }else{
            System.out.println("False");
        }
        hs.remove(2);
        if(hs.contains(2)){
            System.out.println("Set contains 2");
        }else{
            System.out.println("False");
        }   
        System.out.println(hs.size() +" is it empty?? "+ hs.isEmpty());

    }
}
