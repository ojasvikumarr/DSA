package HasHing.HashhSet;
import java.util.* ;

public class UnionNIntersection {
    public static void main(String[] args){
        HashSet<Integer> set = new HashSet<>();
        int arr1[] = {7 , 3 , 9};
        int arr2[] = {6 , 3 , 9 , 2 , 9 , 4};
        for(Integer a : arr1){
            set.add(a);
        }
        for(Integer a : arr2){
            set.add(a);
        }
        System.out.println("Union of these set will be : "+set);
        set.clear();
        for(Integer a : arr1){
            set.add(a);
        }
        int count = 0 ; 
        for(int i = 0 ; i < arr2.length ; i++){
            if(set.contains(arr2[i])){
                count++ ;
                set.remove(arr2[i]);
            }
        }

        System.out.println("Inteersection is equal to : "+ count);
    }
}
