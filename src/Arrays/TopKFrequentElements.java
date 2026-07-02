package Arrays;

import java.util.*;

public class TopKFrequentElements {
    // HashMap + MinHeap
    static class Solution {
        public int[] topKFrequent(int[] nums, int k) {
            Map<Integer, Integer> freq = new HashMap<>();

            for(int num : nums) {
                freq.put(num, freq.getOrDefault(num, 0) + 1);
            }

            PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> freq.get(a) - freq.get(b)); // min heap according to frequency

            for(int num : freq.keySet()) {
                pq.offer(num);

                if(pq.size() > k) { // removing less frequency element
                    pq.poll();
                }
            }

            int[] ans = new int[k];

            for(int i = k-1; i >= 0; i--) {
                ans[i] = pq.poll(); // this will return me top k freq elements
            }
            return ans;
        }
    }
}
