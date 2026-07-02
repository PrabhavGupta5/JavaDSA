package TwoPointers;

// https://leetcode.com/problems/trapping-rain-water/
// Time complexity: O(n) because we are traversing the array three times, but each traversal is O(n).
// Space complexity: O(n) because we are using two additional arrays to store the maximum height
// https://www.youtube.com/watch?v=09KF1hjWoSU&t=582s
public class TrappingRainWater {
    public int trap(int[] height) {
        int n = height.length;
        if (n == 0) return 0;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        leftMax[0] = height[0]; // we are filling the leftMax array from left to right, so we need to initialize the first element of the leftMax array with the value of the first element of the height array because there is no element to the left of the first element, so the maximum height to the left of the first element is just the height of the first element itself.
        rightMax[n - 1] = height[n - 1]; // we are filling the rightMax array from right to left, so we need to initialize the last element of the rightMax array with the value of the last element of the height array because there is no element to the right of the last element, so the maximum height to the right of the last element is just the height of the last element itself.

        for (int i = 1; i < n; i++) // we are filling the leftMax array from left to right, so we need to start from the second element and move towards the last element, and we are comparing the current value in the leftMax array with the current height to get the maximum height to the left of the current index, which will help us calculate the amount of water that can be trapped at that index.
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        for (int i = n - 2; i >= 0; i--) // we are filling the rightMax array from right to left, so we need to start from the second last element and move towards the first element, and we are comparing the current value in the rightMax array with the current height to get the maximum height to the right of the current index, which will help us calculate the amount of water that can be trapped at that index.
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);

        int totalWater = 0;
        for (int i = 0; i < n; i++)
            totalWater += Math.min(leftMax[i], rightMax[i]) - height[i]; // Formula to calculate the amount of water that can be trapped at index i is min(leftMax[i], rightMax[i]) - height[i], because the water level at index i can only be as high as the minimum of the maximum height to the left and the maximum height to the right, and we need to subtract the height at index i from this minimum value to get the actual amount of water that can be trapped at that index.

        return totalWater;
    }
}
