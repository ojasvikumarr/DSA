import java.util.* ;

class Day18{
    public static void sum(int idx , ArrayList<Integer> arr , int sum , ArrayList<Integer> ans , int N){
        if(idx == arr.size()){
            ans.add(sum);
            return ;
        }
        sum += arr.get(idx);
        sum(idx+1, arr, sum, ans , N);
        sum -= arr.get(idx);
        sum(idx+1, arr, sum, ans , N);
    }
    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N){
        ArrayList<Integer> ans = new ArrayList<>();
        int sum = 0 ; 
        sum(0, arr, sum , ans , N);
        Collections.sort(ans);
        return ans ;
    }

    public static void HelperSubset(int[] nums , int idx , List<Integer> ans){
        if(idx == nums.length){
            return ;
        }
        if(ans.size() == 0){
            ans.add(nums[0]);
        }
        for(int j = 0 ; j < ans.size() ; j++){
            if(ans.get(j) % nums[idx] == 0 && nums[idx] % ans.get(idx) % nums[idx] == 0){
                if(ans.get(j) != nums[idx]){
                    ans.add(nums[idx]); 
                }
                HelperSubset(nums , idx++ , ans);
            }
            HelperSubset(nums, idx++, ans);
        }
    }
    public static List<Integer> LargestDivSubset(int[] nums){
        List<Integer> ans = new ArrayList<>();
        HelperSubset(nums, 0, ans);
        return ans ;
    }


    public void Helper(int[] nums , int idx , List<List<Integer>> ans , List<Integer> ds){
        if(idx == nums.length){
            ans.add(new ArrayList<>(ds));
            return ; 
        }
        ds.add(nums[idx]);
        Helper(nums , idx+1 , ans , ds);
        ds.remove(ds.size()-1);
        Helper(nums , idx+1 , ans , ds);
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Helper(nums , 0 , ans , new ArrayList<>());
        return ans ;
    }
}