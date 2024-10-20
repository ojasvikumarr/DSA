class Solution {
    void merge(int arr[], int l, int mid, int r) {
        // Your code here
        int temp[] = new int[arr.length];
        int i = 0;
        int left = l;
        int right = mid + 1;
        while (left < mid && right < r) {
            if (arr[left] <= arr[right]) {
                temp[i++] = arr[left];
                left++;
            } else {
                temp[i++] = arr[right];
                right++;
            }
        }
        while (left < mid) {
            temp[i++] = arr[left];
            left++;
        }
        while (right < r) {
            temp[i++] = arr[right];
            right++;
        }
        for (int j = 0; j < arr.length; j++) {
            arr[j] = temp[j];
        }

    }

    void mergeSort(int arr[], int l, int r) {
        // code
        if (l >= r) {
            return;
        }
        int mid = l - (l - r) / 2;

        mergeSort(arr, l, mid);
        mergeSort(arr, mid + 1, r);
        merge(arr, l, mid, r);
    }
}