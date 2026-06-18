package Heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class FindMedianDataStream {
    class MedianFinder {
        // we can add numbers in the min heap and whenever we are calling findMedian, we can check the size of heap, if it is even we can pop till size/2 and return
        PriorityQueue<Integer> leftMax;
        PriorityQueue<Integer> rightMin;

        public MedianFinder() {
            leftMax = new PriorityQueue<>(Collections.reverseOrder());
            rightMin = new PriorityQueue<>();
        }

        // After insertion, All numbers in left <= all numbers in right
        public void addNum(int num) {
            leftMax.offer(num);
            rightMin.offer(leftMax.poll());
            // if the diff is greater than one
            if(rightMin.size() > leftMax.size()) // we will pop from right and add to left to maintain the balance
                leftMax.offer(rightMin.poll());
        }

        public double findMedian() {
            if(leftMax.size() > rightMin.size()) // if the size of left is greater than right, then we will return the top of left as median
                return leftMax.peek();

            return (leftMax.peek() + rightMin.peek())/2.0;
        }
    }
}
