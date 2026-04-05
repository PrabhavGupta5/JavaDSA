package SlidingWindow;

import java.util.ArrayList;
import java.util.List;

// Array is sorted, first thing in your mind should come is binary search
// number of elements should be equal to k, closest to x
// https://leetcode.com/problems/find-k-closest-elements/description/?envType=problem-list-v2&envId=top-interview-150
public class FindKClosestElements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>(k);
        int left = 0;
        int right = arr.length - 1;
        while (right - left >= k) { // We need to maintain the window of size k, so we will keep moving the left and right pointers until the window size is k
            if (Math.abs(arr[left] - x) > Math.abs(arr[right] - x)) {
                left++;
            } else {
                right--;
            }
        }
        // Now we have the window of size k, we can add the elements in the result list
        // What we are doing is we are comparing the absolute difference of the left and right pointers with x, if the absolute difference of the left pointer is greater than the absolute difference of the right pointer, then we need to move the left pointer to the right, otherwise we need to move the right pointer to the left. This way we are maintaining the window of size k and we are also making sure that we are getting the closest elements to x
        for (int i = left; i <= right; i++) {
            result.add(arr[i]);
        }
        return result;
    }
}
