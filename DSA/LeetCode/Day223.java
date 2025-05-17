package LeetCode;

public class Day223 {
    class Solution {
    public void selectionSort(int[] nums) {
    int n = nums.length;
    for (int i = 0; i < n - 1; i++) {
        int mini = i;
        for (int j = i + 1; j < n; j++) {
            if (nums[j] < nums[mini]) {
                mini = j;
            }
        }
        // Swap the found minimum element with the first element
        int temp = nums[mini];
        nums[mini] = nums[i];
        nums[i] = temp;
    }
}

    public void swap(int[] arr ,int a , int b ){
        int temp = arr[a] ;
        arr[a] = arr[b] ;
        arr[b] = temp ;
    }
    public void bubbleSort(int[] arr){
        int n = arr.length ;
        for(int i = 0 ; i < n-1 ; i++){
            for(int j = 0 ; j < n-i-1 ; j++ ){
                if(arr[j] > arr[j+1]){
                    swap(arr , j , j+1);
                }
            }
        }
    }
    public void sortColors(int[] nums) {
        selectionSort(nums);
        // bubbleSort(nums);
    }
}
}
