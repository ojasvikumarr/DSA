import java.util.*;

public class OptimalPageReplacement {
    public static int pageFaults(int[] pages, int capacity) {
        Set<Integer> set = new HashSet<>();
        Map<Integer, Integer> map = new HashMap<>();
        int pageFaults = 0;

        for (int i = 0; i < pages.length; i++) {
            if (set.size() < capacity) {
                set.add(pages[i]);
            } else {
                if (!set.contains(pages[i])) {
                    int farthest = Integer.MIN_VALUE, pageToRemove = -1;
                    for (int page : set) {
                        if (!map.containsKey(page)) {
                            return -1; // Error, should not happen
                        }
                        if (map.get(page) > farthest) {
                            farthest = map.get(page);
                            pageToRemove = page;
                        }
                    }
                    set.remove(pageToRemove);
                    set.add(pages[i]);
                    pageFaults++;
                }
            }
            map.put(pages[i], i);
        }
        return pageFaults;
    }

    public static void main(String[] args) {
        int[] pages = {7, 0, 1, 2, 0, 3, 0, 4, 2, 3, 0, 3, 2};
        int capacity = 4;
        int pageFaults = pageFaults(pages, capacity);
        System.out.println("Total Page Faults: " + pageFaults);
    }
}
