import java.util.ArrayList ;
public class HW {
    public static boolean Order( ArrayList<Integer> H){
        for( int i= 0 ; i< H.size()-1 ; i++){
            if( H.get(i) <= H.get(i+1) ){
                return true ;}
            if( H.get(i) >= H.get(i+1) ){
                return true ;}
        }
        return false ;
    }
    public static void main( String args[]){
        ArrayList <Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(2);
        list.add(3);
        System.out.println(Order(list));
    }
}
