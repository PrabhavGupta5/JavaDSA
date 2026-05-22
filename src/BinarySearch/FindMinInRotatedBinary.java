package BinarySearch;

public class FindMinInRotatedBinary {
    public static void main(String[] args) {

    }
    //https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
    public int findMin(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        int ans = Integer.MAX_VALUE;

        while(start <= end){
            int mid = start + (end-start )/2;
            if(nums[start] <= nums[mid]){
                ans = Math.min(nums[start], ans);
                start = mid + 1;
            }
            else {
                ans = Math.min(ans, nums[mid]);
                end = mid - 1;
            }
        }
        return ans;
    }


    // https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/
    // we can have duplicates in this case, so we need to skip the duplicates and then apply the same logic as above
    // https://www.youtube.com/watch?v=N9YDsS9WJmM&t=201s
    public int findMinDuplicates(int[] nums) {
        int resIdx = 0; // we will store the index of the minimum element in this variable
        int l = 0, r = nums.length-1;

        // skipping the duplicates
        while(l < r && nums[l] == nums[l+1])
            l++;
        while(r > l && nums[r] == nums[r-1])
            r--;

        while(l <= r) {
            int mid = l + (r-l) / 2;
            // need to update the result index
            if(nums[mid] < nums[resIdx])
                resIdx = mid;
            if(nums[mid] > nums[r])
                l = mid + 1;
            else
                r = mid - 1;
        }

        return nums[resIdx];
    }
    // for example: if the input array is [2,2,2,0,1,1], then we will skip the duplicates at the beginning and end of the array, and then we will apply the same logic as above to find the minimum element in the rotated sorted array with duplicates, which is 0 in this case.

}
