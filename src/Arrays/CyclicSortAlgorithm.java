package Arrays;

import java.util.ArrayList;
import java.util.List;

public class CyclicSortAlgorithm {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int i = 0;

        while(i < nums.length) {
            int correct = nums[i] - 1;
            if(nums[i] != nums[correct]) {

                int temp = nums[i];
                nums[i] = nums[correct];
                nums[correct] = temp;

            } else {
                i++;
            }
        }

        for(i = 0; i < nums.length; i++) {
            if(nums[i] != i + 1)
                list.add(i + 1);

        }

        return list;
    }

    // example:
    // Input: nums = [4,3,2,7,8,2,3,1]
    // Output: [5,6]
    // Explanation: The numbers 5 and 6 do not appear in the array.
    // In the first pass, we will place each number in its correct position. After the first pass, the array will look like this: [1,2,3,4,3,2,7,8]. In the second pass, we will check for each index if the number at that index is equal to the index + 1. If it is not equal, then it means that the number at that index is missing from the array. In this case, we will add the index + 1 to our list of missing numbers. After the second pass, we will have our final list of missing numbers which is [5,6].





    // Find first missing positive number in an unsorted array
    // https://leetcode.com/problems/first-missing-positive/


    public int firstMissingPositive(int[] nums) {
        int i = 0;

        while(i < nums.length) {
            int correct = nums[i] - 1;
            if(nums[i]>0 && nums[i]<=nums.length && nums[i] != nums[correct]) {
                int temp = nums[i];
                nums[i] = nums[correct];
                nums[correct] = temp;

            } else {
                i++;
            }
        }

        for(i = 0; i < nums.length; i++) {
            if(nums[i] != i + 1)
                return i+1;
        }

        return nums.length + 1;
    }
    // example: [3,4,-1,1]
    // after sort array becomes : [1,-1,3,4]




    // Missing Number
    // Here range is given from 0 to n, and we have to find the missing number in the array, which is the number that is not present in the array, but is present in the range from 0 to n. We can use the same approach as cyclic sort, but instead of placing each number in its correct position, we will place each number in its correct index, which is the index that is equal to the number itself. After placing each number in its correct index, we will check for each index if the number at that index is equal to the index. If it is not equal, then it means that the number at that index is missing from the array. In this case, we will return the index as the missing number. If all numbers are present in their correct index, then it means that the missing number is n, which is the length of the array.
    // https://leetcode.com/problems/missing-number/description/
    public int missingNumber(int[] nums) {
        int i = 0;

        while(i < nums.length) {
            int correct = nums[i];
            if(nums[i]<nums.length && nums[i] != nums[correct]) {

                int temp = nums[i];
                nums[i] = nums[correct];
                nums[correct] = temp;

            } else {
                i++;
            }
        }

        for(i = 0; i < nums.length; i++) {
            if(nums[i] != i)
                return i;

        }

        return nums.length;
    }

    // example: [3,0,1]
    // after sort array becomes : [0,1,3]
    // missing number is 2, which is the index that is not equal to the number at that index, which is 3, so we will return 2 as the missing number.

}
