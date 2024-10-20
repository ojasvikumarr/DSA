import java.util.*;
public class SortedandRotated {
    public static boolean Target(ArrayList<Integer> H , int target){
        //O(n)
        int n = 0 ;
        for( int i = 0 ; i<H.size() ; i++){
            if(H.get(i)> H.get(i+1) ){
                 n = i ;
                 break;
            }
        }
        int rp = n ;
        int lp = n+1 ;
            while(rp != lp){
                if( H.get(rp) + H.get(lp) == target){
                    return true ;
                }
                if( H.get(rp) + H.get(lp) > target){
                    rp = (rp + H.size() - 1)%H.size() ;
                }
                else{
                    lp = (lp + H.size() )%H.size() ;
                }
        }
        return false ; 
    }
    public static void main( String args[]){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(11);
        list.add(15);
        list.add(6);
        list.add(8);
        list.add(9);
        list.add(10);
        System.out.print( Target(list, 16)) ;
    }
}
