import java.util.*;

public class LRUCache {
    private int capacity;
    private LinkedHashMap<Integer, Integer> cache;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new LinkedHashMap<>(capacity, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return size() > capacity;
            }
        };
    }

    public int get(int key) {
        return cache.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        cache.put(key, value);
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        System.out.println(lruCache.get(1)); // Output: 1
        lruCache.put(3, 3);
        System.out.println(lruCache.get(2)); // Output: -1
        lruCache.put(4, 4);
        System.out.println(lruCache.get(1)); // Output: -1
        System.out.println(lruCache.get(3)); // Output: 3
        System.out.println(lruCache.get(4)); // Output: 4
    }
}
