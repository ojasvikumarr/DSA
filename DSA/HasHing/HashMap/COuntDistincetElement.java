package HasHing.HashMap;

import java.util.* ;

public class COuntDistincetElement {
    public static int DistinctElement(int arr[]){
        HashMap<Integer , Integer> map = new HashMap<>();
        for(Integer a : arr){
            map.put(a , map.getOrDefault(a , 0) + 1);
        }
        int distinct = 0 ;
        for(Integer a : map.keySet()){
            distinct++ ;
        }
        return distinct ;
    }
    public static void main( String[] args ){
        int num[] = {4 , 3, 2, 5 , 6, 7, 3, 4, 2, 1};
        System.out.println("The number of distinct elements : "+DistinctElement(num));
        HashSet<Integer> set = new HashSet<>();

        for( Integer a : num ){
            set.add(a);
        }
        System.out.println("Ans = "+ set.size());
    }
}
