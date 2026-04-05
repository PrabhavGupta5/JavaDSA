package SlidingWindow;

public class SubArrayProductLessThank {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k <= 1) return 0;
        int count = 0, prod = 1;
        int i = 0;
        for(int j = 0; j < nums.length; j++) {
            // calculate the product in the window
            prod = prod * nums[j];

            // if product is greater than k, shrink the window
            while(prod >= k) {
                prod = prod / nums[i];
                i++;
            }

            // if product is less than k, increment the count
            count = count + (j-i+1);    //At each j → count all subArrays ending at j
        }

        return count;
    }
}
