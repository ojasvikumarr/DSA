import java.util.ArrayList;
import java.util.List;

public class cf {
     public static int helper(int n, int[] arr) {
        Arrays.sort(arr);
        List<int[]> ranges = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int start = Math.abs(arr[i] - arr[j]) + 1;
                int end = arr[i] + arr[j] - 1;
                ranges.add(new int[]{start, end});
            }
        }
        ranges.sort((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        int mergedStart = ranges.get(0)[0];
        int mergedEnd = ranges.get(0)[1];
        int count = 0;

        for (int i = 1; i < ranges.size(); i++) {
            int[] current = ranges.get(i);
            if (current[0] <= mergedEnd) {
                mergedEnd = Math.max(mergedEnd, current[1]);
            } else {
                count += (mergedEnd - mergedStart + 1);
                mergedStart = current[0];
                mergedEnd = current[1];
            }
        }
        count += (mergedEnd - mergedStart + 1);

        return count;
    }
}
