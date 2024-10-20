import java.util.* ;

public class Pairsum {
//this is CALLED 2 POINTER APPROACH
    //O(n)
    public static boolean Fastsum( ArrayList<Integer> h , int key){
        int lp = 0 ;
        int rp = h.size()-1 ;
        while( lp < rp ){
            if( h.get(lp) + h.get(rp) == key){
                return true ;
            }
            if( h.get(lp) + h.get(rp) > key){
                rp-- ;
            }
            else{
                lp++;
            }
        }
        return false ;
    }

    //O(n^2)
    public static boolean Pairsumm( ArrayList<Integer> h , int target){
        for( int i= 0 ; i< h.size() ; i++){
            for( int j = i+1 ; j<h.size() ; j++){
                if(h.get(i) + h.get(j) == target ){
                    return true ;
                }
            }
        }
        return false;
    }
    public static void main( String args[]){
         ArrayList<Integer> list = new ArrayList<>();
         for( int i= 0  ; i<10 ; i++){
            list.add(i);
         } 
         System.out.println(Pairsumm(list, 5));
         System.out.println(Fastsum(list, 5));
    }
}
