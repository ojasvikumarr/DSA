import java.util.* ;
public class Day23 {
    public static int LeastNumberOfUniqueIntegerAfterKRemovals(int[] arr ,  int k){
        HashMap<Integer , Integer> map = new HashMap<>();
        for(int i : arr){
            map.put(i , map.getOrDefault(i , 0) + 1);
        }
        
    }
}
