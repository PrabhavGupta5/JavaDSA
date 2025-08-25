// In this question we have to find the element in a sorted array of infinite elements
// https://www.geeksforgeeks.org/dsa/find-position-element-sorted-array-infinite-numbers/

public class InfiniteArrayBinary {
    public static void main(String[] args) {
        int[] arr = {2, 4, 5, 6, 6, 6, 7, 7, 8 , 9, 100 , 523, 655, 890};
        int result = ans(arr, 4);
        System.out.println(result);
    }

    public static int ans(int[] nums, int target){
        int start = 0;
        int end = 1;

        // doubling the size of search space everytime the target element is not found
        while(target > nums[end]){
            int newStart = end + 1;
            end = end + (end - start + 1) * 2;
            start = newStart;
        }
        return binarySearch(nums, target, start, end);
    }

    public static  int binarySearch(int[] arr, int target, int start, int end){
        while ( start <= end) {
            int mid = (start + end) / 2;

            if (arr[mid] == target)
                return mid;

            if (arr[mid] > target)
                end = mid - 1;
            else
                start = mid + 1;
        }
        return  -1;
    }
}
