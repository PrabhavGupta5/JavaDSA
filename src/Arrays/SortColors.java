package Arrays;

// https://leetcode.com/problems/sort-colors/description/
// This is a Dutch National Flag problem, we have to sort the array in place without using any extra space and in one pass. We can use three pointers to keep track of the position of 0s, 1s and 2s. We can use a switch case to swap the elements based on the value at mid pointer.
// Time Complexity: O(n) because we are traversing the array once
// Space Complexity: O(1) because we are not using any extra space
// https://www.youtube.com/watch?v=6sMssUHgaBs
public class SortColors {
    public void sortColors(int[] nums) {

        int start = 0;
        int mid = 0;
        int end = nums.length - 1;

        while (mid <= end) {

            switch (nums[mid]) {
                case 0:
                    // Swap with start index
                    swap(nums, start, mid);
                    mid++;
                    start++;
                    break;

                case 1:
                    mid++;
                    break;

                case 2:
                    // Swap with end index
                    swap(nums, mid, end);
                    end--;
                    break;
            }
        }

    }

    private void swap(int[] arr, int pos1, int pos2) {
        int temp = arr[pos1];
        arr[pos1] = arr[pos2];
        arr[pos2] = temp;
    }

}
