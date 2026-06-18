package TwoPointers;

//
public class RemoveDuplicatesFromSortedArray {
    // https://leetcode.com/problems/remove-duplicates-from-sorted-array/
    class Solution {
        public int removeDuplicates(int[] nums) {
            // take two pointers, i should always point to unique elements, j will iterate in the array finding unique elements
            int i = 0;
            for(int j = 0; j < nums.length; j++) {
                if(nums[i] != nums[j]) {
                    i++;
                    nums[i] = nums[j];
                }

            }
            return i+1;
        }
    }

    // https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/
    class Solution2 {
        public int removeDuplicates(int[] nums) {
            int i = 0;
            for (int j = 0; j < nums.length; j++) {
                if (i < 2 || nums[i - 2] != nums[j]) { // here i < 2 will take for the first two elements, and then we will check for the next elements if they are not equal to the element at i-2 then we will update the element at i with the element at j and increment i, this way we will keep at most 2 duplicates in the array.
                    nums[i] = nums[j];
                    i++;

                }
            }
            return i;
        }
    }




}
