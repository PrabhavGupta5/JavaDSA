package Heap;

import java.util.PriorityQueue;

public class LastStoneWeight {
    // https://leetcode.com/problems/last-stone-weight/
    // We are using a max heap to store the weights of the stones. We keep removing the two heaviest stones and smashing
    // them together until there is at most one stone left. If there are two stones of equal weight, both are destroyed.
    // If there are two stones of different weights, the lighter stone is destroyed and the heavier stone's weight is reduced by the lighter stone's weight.
    // // this problem is solved by using max heap as k is not given, we have to find largest and 2nd largest everytime and insert a new value in the heap
    // Time complexity: O(N log N) where N is the number of stones
    // Space complexity: O(N) for the heap
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

        for(int i = 0; i < stones.length; i++) {
            pq.add(stones[i]);
        }

        while(pq.size() > 1) {
            int stone1 = pq.poll();
            int stone2 = pq.poll();

            if(stone1 != stone2) {
                pq.add(stone1 - stone2);
            }
        }

        return pq.isEmpty() ? 0 : pq.peek();
    }
}
