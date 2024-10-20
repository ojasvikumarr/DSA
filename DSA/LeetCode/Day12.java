public class Day12 {
    public int maxSumAfterPartitioning(int[] arr, int k){
        int subarray[] = new int[arr.length];
        for(int i = 0 ; i < arr.length ; i++){
            for(int j = i - k + 1; j <= k + i - 1  ; j++){
                if(j >= 0 && j < arr.length && arr[i] > arr[j]){
                    arr[j] = arr[i];
                }
            }
        }
        int total = 0 ; 
        for(int i = 0 ; i < arr.length ; i++){
            total += subarray[i];
        }
        return total ;
    }
}
