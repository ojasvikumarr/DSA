import java.util.*;

public class FIFOCache {
    private int capacity;
    private Queue<Integer> cache;

    public FIFOCache(int capacity) {
        this.capacity = capacity;
        this.cache = new LinkedList<>();
    }

    public int get(int key) {
        if (cache.contains(key)) {
            return key;
        }
        return -1;
    }

    public void put(int key) {
        if (cache.size() == capacity) {
            cache.poll(); // Remove the first page from the cache
        }
        cache.offer(key); // Add the new page to the cache
    }

    public static void main(String[] args) {
        FIFOCache fifoCache = new FIFOCache(3);
        fifoCache.put(1);
        fifoCache.put(2);
        fifoCache.put(3);
        System.out.println(fifoCache.get(1)); // Output: 1
        fifoCache.put(4);
        System.out.println(fifoCache.get(2)); // Output: -1
        System.out.println(fifoCache.get(3)); // Output: 3
        System.out.println(fifoCache.get(4)); // Output: 4
    }
}
