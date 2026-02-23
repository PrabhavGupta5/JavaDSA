package Heap;

import java.util.PriorityQueue;

public class KClosePointsOrigin {
    // https://leetcode.com/problems/k-closest-points-to-origin/description/
    // We are using a max heap to store the k closest points, if the size of the heap exceeds k,
    // We remove the farthest point from the heap. At the end, the heap will contain the k closest points to the origin.
    // Time complexity: O(N log K) where N is the number of points and K is the size of the heap
    // Space complexity: O(K) for the heap
    // The distance of a point (x, y) from the origin (0, 0) can be calculated using the formula: distance = sqrt(x^2 + y^2). However, since we only need to compare distances, we can compare the squares of the distances to avoid the computational overhead of calculating the square root.
    public int[][] kClosest(int[][] points, int k) {
        // here : b[0] = x coordinate, b[1] = y coordinate, and it's a max heap that's why we are doing b - a
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
                (a, b) -> (b[0]*b[0] + b[1]*b[1]) -
                        (a[0]*a[0] + a[1]*a[1])
        );

        for (int[] point : points) {
            maxHeap.add(point);

            if (maxHeap.size() > k) {
                maxHeap.poll();  // remove farthest
            }
        }

        int[][] result = new int[k][2];
        int i = 0;

        while (!maxHeap.isEmpty()) {
            result[i++] = maxHeap.poll();
        }

        return result;

    }
}
