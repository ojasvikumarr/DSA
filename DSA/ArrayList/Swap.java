
import java.util.ArrayList;

public class Swap{
    public static void main( String args []){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(5);
        list.add(7);
        list.add(9);
        list.add(11);
        list.add(10);

        System.out.println(list.get(2));
        System.out.println(list.get(5));
        System.out.println(list);
        int index1 = 2 , index2 = 5 ; 
        int temp = list.get(index1);
        list.set(index1 , list.get(index2));
        list.set(index2 , temp);

        System.out.println(list);
        System.out.println(list.get(2));
        System.out.println(list.get(5));
    }
}
