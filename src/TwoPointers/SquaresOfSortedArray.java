package TwoPointers;

// https://leetcode.com/problems/squares-of-a-sorted-array/
public class SquaresOfSortedArray {
    public int[] sortedSquares(int[] nums) {
        // use two pointers
        // Largest square will come from: either LEFT (big negative) or RIGHT (big positive)
        int[] res = new int[nums.length];
        int i = 0;
        int j = nums.length - 1;
        int k = nums.length - 1; // to fill the array

        while(i <= j) {
            int leftSq = nums[i] * nums[i];
            int rightSq = nums[j] * nums[j];

            if(leftSq > rightSq) {
                res[k] = leftSq;
                i++;
            }

            else {
                res[k] = rightSq;
                j--;
            }
            k--;
        }
        return res;
    }
}

// Input: nums = [-4,-1,0,3,10]
//Output: [0,1,9,16,100]
//Explanation: After squaring, the array becomes [16,1,0,9,100].
//After sorting, it becomes [0,1,9,16,100].
