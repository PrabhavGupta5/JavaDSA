package Greedy;
import java.util.*;


// https://leetcode.com/problems/divide-array-in-sets-of-k-consecutive-numbers/description/
public class DivideArrayIntoGroupConsecutiveK {
    public boolean isPossibleDivide(int[] nums, int k) {
        // early check
        if(nums.length % k != 0)
            return false;
        Arrays.sort(nums);

        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for(int num : nums) {
            if(map.get(num) == 0) // if the frequency of the current number is 0, then it means that it has already been used in a previous group, so we can skip it
                continue;
            for(int i = 0; i < k ; i++ ) {
                int curr = num + i; // we are trying to form a group of k consecutive numbers starting from the current number, so we will check for the next k-1 numbers, if they are present in the frequency map and if their frequency is greater than 0, then we can form a group of k consecutive numbers starting from the current number, so we will decrement the frequency of those numbers in the map. If any of the next k-1 numbers are not present or their frequency is 0, then we cannot form a group of k consecutive numbers starting from the current number, so we will return false.
                if(map.getOrDefault(curr,0) == 0)
                    return false;
                map.put(curr, map.get(curr) - 1);
            }
        }

        return true;

    }
}

// Explanation:
// We first check if the length of the array is divisible by k, if it is not then we cannot divide the array into groups of k
// consecutive numbers, so we return false. Then we sort the array and create a frequency map to count the occurrences of each number
// in the array. We iterate through the sorted array and for each number, if its frequency is 0, we skip it because it means that it
// has already been used in a previous group. If its frequency is not 0, then we try to form a group of k consecutive numbers starting
// from that number. We check if the next k-1 numbers are present in the frequency map and if their frequency is greater than 0.
// If any of the next k-1 numbers are not present or their frequency is 0, then we cannot form a group of k consecutive numbers starting
// from that number, so we return false. If we can form a group of k consecutive numbers starting from that number, then we decrement
// the frequency of those numbers in the map. If we can iterate through the entire array without returning false, then it means that we
// can divide the array into groups of k consecutive numbers, so we return true.

// Time complexity: O(n log n) because of sorting the array, and then we are iterating through the array once, so it is O(n) and the overall time complexity is O(n log n).
// Space complexity: O(n) because of the frequency map, in the worst case, all numbers in the array are distinct, so the frequency map will have n entries, so it is O

// example : nums = [1,2,3,3,4,4,5,6], k = 4
// After sorting the array, it will look like this: [1,2,3,3,4,4,5,6]
// We will create a frequency map: {1:1, 2:1, 3:2, 4:2, 5:1, 6:1}
// We will iterate through the sorted array and for each number, we