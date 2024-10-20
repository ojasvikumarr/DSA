class SubsetWithADiffTarget {
    public static int recursion(int[] arr , int idx , int target){
        if(idx == 0){
            if(target == 0){
            return 1 ;
            }else{
            return 0 ;
            }
        }

        int pick = recursion(arr, idx+1, target);
        if(arr[idx] <= target){
            target -= arr[idx];
            pick = recursion(arr, idx+1, target);
        }
        target += arr[idx];
        int notPick = recursion(arr, idx+1, target);

        return pick + notPick ;
    }
    public static int SubSet(int[] arr , int diff ){
        int totSum = 0 ;
        for(int i = 0 ; i < arr.length ; i++){
            totSum += arr[i];
        }
        return recursion(arr, 0, (totSum-diff)/2);
    }
}