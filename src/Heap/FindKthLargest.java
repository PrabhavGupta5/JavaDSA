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

        for (int num : nums) {
            pq.add(num);

            if (pq.size() > k) {
                pq.poll();
            }
        }

        return pq.peek();
    }


    // Heap Type
    //
    //Syntax
    //
    //Min Heap (Integer)
    //
    //new PriorityQueue<>()
    //
    //Max Heap (Integer)
    //
    //new PriorityQueue<>(Collections.reverseOrder())
    //
    //Min Heap (Custom)
    //
    //(a, b) -> Integer.compare(a.x, b.x)
    //
    //Max Heap (Custom)
    //
    //(a, b) -> Integer.compare(b.x, a.x)
    //
    //Min Heap (int[])
    //
    //(a, b) -> Integer.compare(a[1], b[1])
    //
    //Max Heap (int[])
    //
    //(a, b) -> Integer.compare(b[1], a[1])
}
