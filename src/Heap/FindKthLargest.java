package Heap;

import java.util.PriorityQueue;

public class FindKthLargest {
    //  https://leetcode.com/problems/kth-largest-element-in-an-array/description/
    // We are using a min heap to store the k largest elements, if the size of the heap exceeds k,
    // We remove the smallest element from the heap. At the end, the top of the heap will be the kth largest element.
    // Time complexity: O(N log K) where N is the number of elements in the array and K is the size of the heap
    // Space complexity: O(K) for the heap
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i = 0; i < nums.length; i++) {
            pq.add(nums[i]);

            if(pq.size() > k) {
                pq.poll();
            }
        }

        return pq.peek();
    }
}
