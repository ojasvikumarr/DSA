package DpOnBitMasking;
import java.util.* ; 

public class GeneratingSubsets {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        sc.close();
    }    
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> resultSet = new ArrayList<>() ; 
        int n = nums.length ; 
        int mask_cnt = (1<<n);
        for(int mask = 0 ; mask < mask_cnt ; mask++){
            List<Integer> subset = new ArrayList<>();
            for(int i = 0 ; i < n ; i++){
                if((mask & (1<<i)) != 0){
                    //That means its set 
                    //we add it in the ans 
                    subset.add(nums[i]);
                }
            }
            resultSet.add(subset);
        }
        return resultSet ; 
    }
}
