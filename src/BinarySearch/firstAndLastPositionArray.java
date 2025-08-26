package BinarySearch;

import java.util.Arrays;

public class firstAndLastPositionArray {
    public static void main(String[] args) {
        int[] arr = { 2, 3, 4, 4, 4, 5, 6, 7};
        int[] result = search(arr, 4);

        System.out.println("Result: " + Arrays.toString(result));

    }

    // In this case we will run binary search to find the first occurrence and then to find the second occurrence so the time complexity will be logN
    public static int[] search(int [] nums, int target){
        int[] ans = {-1, -1};

        int start = checkTarget(nums, target, true);
        int end = checkTarget(nums, target, false);

        ans[0] = start;
        ans[1] = end;
        return ans;
    }

    public static int checkTarget(int[] nums, int target, boolean firstOcc){
        int ans = -1;
        int start = 0;
        int end = nums.length - 1;

        while(start<=end){
            int mid = start + (end - start) / 2;

            if (nums[mid] == target){
                ans = mid;
                if(firstOcc)
                    end = mid - 1;
                else
                    start = mid + 1;
            }
            else if (nums[mid] < target)
                start = mid + 1;
            else
                end = mid - 1;
        }
        return ans;
    }


}
