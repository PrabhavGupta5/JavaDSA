package StacksandQueues;

import java.util.Stack;

// https://www.youtube.com/watch?v=mJWQjJpEMa4
// We are traversing the nums2 from right to left finding the next greatest element
// https://leetcode.com/problems/next-greater-element-i/description/
public class NextGreaterElement1 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // Map from number to its next greater element
        int[] nextGreater = new int[10001];
        Stack<Integer> stack = new Stack<>();

        // Traverse nums2 from right to left
        for (int i = nums2.length - 1; i >= 0; i--) {
            // Pop smaller or equal elements from stack
            while (!stack.isEmpty() && stack.peek() <= nums2[i]) {
                stack.pop();
            }

            // If stack is empty, no greater element to right
            if (stack.isEmpty()) {
                nextGreater[nums2[i]] = -1;
            } else {
                nextGreater[nums2[i]] = stack.peek();
            }

            // Push current element as a candidate for future elements
            stack.push(nums2[i]);
        }

        // Build result for nums1 by looking up precomputed next greater element
        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = nextGreater[nums1[i]];
        }

        return nums1;
    }
}

