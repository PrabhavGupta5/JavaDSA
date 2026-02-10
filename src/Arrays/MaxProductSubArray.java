package Arrays;

public class MaxProductSubArray {
    // Two pointer Approach
    // Explanation :
    //1.) Through intuition explanation we know that if all the elements are positive or the negative elements are even
    // then ur answer will be product of complete array which u will get in variable l and r at the last iteration.
    //2.) But if negative elements are odd then u have to remove one negative element, and it is certain that it will be either
    // right of max prefix product or left of max suffix product.
    // So u need not modify anything in your code as you're getting prefix product in l and suffix product in r.
    //3.) If array also contains 0 then your l and r will become 0 at that point...then just update it to
    // 1(or else u will keep multiplying with 0) to get the product ahead making another subarray.

    // https://leetcode.com/problems/maximum-product-subarray/
    // https://www.youtube.com/watch?v=Y6B-7ZctiW8
    // this problem is two-way kadane's approach

    class Solution {
        public int maxProduct(int[] nums) {
            int leftProduct = 1;
            int rightProduct = 1;
            int ans = nums[0];

            for (int i = 0; i < nums.length; i++) {

                //if any of leftProduct or rightProduct become 0 then update it to 1
                leftProduct = leftProduct == 0 ? 1 : leftProduct;
                rightProduct = rightProduct == 0 ? 1 : rightProduct;

                //prefix product
                leftProduct *= nums[i];

                //suffix product
                rightProduct *= nums[nums.length - 1 - i];

                ans = Math.max(ans, Math.max(leftProduct, rightProduct));
            }

            return ans;
        }
    }
}
