package Arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFrequentElements {
    // https://leetcode.com/problems/top-k-frequent-elements/
    // We are using bucket sort to solve this problem in O(n) time complexity
    // Step 1: We create a frequency map to count the frequency of each element in the input array
    // Step 2: We create a bucket array where the index represents the frequency and the value at that index is a list of elements that have that frequency
    // Step 3: We iterate through the bucket array from the end to the beginning and collect the top k frequent elements until
    // we have collected k elements

    public int[] topKFrequent(int[] nums, int k) {
        // Step 1: Frequency Map
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Bucket Array
        List<Integer>[] buckets = new List[nums.length + 1];

        for (int key : freqMap.keySet()) {
            int freq = freqMap.get(key);
            if (buckets[freq] == null) {
                buckets[freq] = new ArrayList<>();
            }
            buckets[freq].add(key);
        }

        // Step 3: Collect Top K
        int[] result = new int[k];
        int index = 0;

        for (int i = buckets.length - 1; i >= 0 && index < k; i--) {
            if (buckets[i] != null) {
                for (int num : buckets[i]) {
                    result[index++] = num;
                    if (index == k) break;
                }
            }
        }

        return result;
    }
}
