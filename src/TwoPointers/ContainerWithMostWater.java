package TwoPointers;

// https://leetcode.com/problems/container-with-most-water/
// Time complexity: O(n) because we are traversing the array once with two pointers.
// Space complexity: O(1) because we are using constant space to store the pointers and the max area.
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        // have to return the max area

        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;

        while(left < right) {
            int length = right - left;
            int width = Math.min(height[left], height[right]); // the width of the container is determined by the shorter line
            int area = length * width;

            maxArea = Math.max(area, maxArea);

            if(height[left] < height[right]) // if the left line is shorter, we move the left pointer to try to find a taller line
                left++;
            else
                right--;
        }
        return maxArea;
    }
}
