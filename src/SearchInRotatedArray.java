public class SearchInRotatedArray {
    public static void main(String[] args) {

    }

//    https://leetcode.com/problems/search-in-rotated-sorted-array/
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target)
                return mid;
            else if (nums[start] <= nums[mid]) {
                // left half is sorted, apply binary search there
                if (nums[start] <= target && target < nums[mid])
                    end = mid - 1;
                else
                    start = mid + 1;
            } else {
                // right half is sorted, apply binary search there
                if (nums[mid] < target && target <= nums[end])
                    start = mid + 1;
                else
                    end = mid - 1;
            }
        }
        return -1;
    }


    // For duplicate values in rotated binary search, we will proceed by shrinking the search
    // space if start, end, and mid points to same element

    //https://leetcode.com/problems/search-in-rotated-sorted-array-ii/description/
    public boolean searchDuplicates(int[] nums, int target) {
        int start = 0;
        int end = nums.length -1;

        while(start <= end){
            int mid = start + (end - start)/2;
            if(nums[mid] == target)
                return true;
            if (nums[start] == nums[mid] && nums[mid] == nums[end]){
                if (nums[start] == target || nums[end] == target)
                    return true;
                start = start + 1;
                end-=1;
                continue;
            }

            else if(nums[start] <= nums[mid]){
                // left half is sorted, apply binary search there
                if(nums[start] <= target && target < nums[mid])
                    end = mid - 1;
                else
                    start = mid + 1;
            }

            else {
                // right half is sorted, apply binary search there
                if(nums[mid] < target && target <= nums[end])
                    start = mid + 1;
                else
                    end = mid - 1;
            }
        }
        return false;
    }
}

