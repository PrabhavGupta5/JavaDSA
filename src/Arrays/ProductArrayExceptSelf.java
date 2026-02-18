package Arrays;

public class ProductArrayExceptSelf {
    // https://leetcode.com/problems/product-of-array-except-self/description/
    // The idea is to create two arrays, one for the prefix product and one for the suffix product. Then we can multiply the prefix and suffix products to get the final result.
    // Time complexity: O(n)
    // Space complexity: O(n) for the prefix and suffix arrays, O(1) for the result array
    // Step 1: Build prefix array where prefix[i] is the product of all elements to the left of i
    // Step 2: Build suffix array where suffix[i] is the product of all elements to the right of i
    // Step 3: Multiply prefix and suffix arrays to get the final result where result[i] = prefix[i] * suffix[i]
    // We can optimize the space complexity to O(1) by using the result array to store the prefix products and then multiplying it with the suffix products on the fly.
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;

        int[] prefix = new int[n];
        int[] suffix = new int[n];
        int[] result = new int[n];

        // Step 1: Build prefix array
        prefix[0] = 1;
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] * nums[i - 1];
        }

        // Step 2: Build suffix array
        suffix[n - 1] = 1; // to handle the product of last index
        for (int i = n - 2; i >= 0; i--) {
            suffix[i] = suffix[i + 1] * nums[i + 1];
        }

        // Step 3: Multiply both
        for (int i = 0; i < n; i++) {
            result[i] = prefix[i] * suffix[i];
        }

        return result;
    }
}
