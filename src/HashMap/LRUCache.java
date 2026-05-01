package HashMap;

import java.util.LinkedHashMap;

public class LRUCache {
    LinkedHashMap<Integer,Integer> cache;
    int capacity = 0;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new LinkedHashMap<>();
    }
    public int get(int key) {
        if(cache.containsKey(key)) { // Move key to END → mark as most recently used
            int value=cache.get(key);
            cache.remove(key);
            cache.put(key,value);
            return value;
        }
        return -1;
    }
    public void put(int key, int value) {
        if(cache.containsKey(key)) { // update the value, make it most recent
            cache.remove(key);
            cache.put(key,value);
        }
        else if(cache.size() == capacity)
            cache.remove(cache.entrySet().iterator().next().getKey()); // this line is giving first element in the map, creates entrySet, then iterates over them using iterator next, then get that key and remove it
        cache.put(key,value);
    }
}
