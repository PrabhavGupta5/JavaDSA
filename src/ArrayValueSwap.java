import java.util.Arrays;
import java.util.HashMap;

public class ArrayValueSwap {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
//        swaparr(arr, arr[1], arr[3]);
//        System.out.println(Arrays.toString(arr));
        reverse(arr);
        System.out.println(Arrays.toString(arr));
    }
    static void swaparr(int[] a, int index1, int index2){
        int temp = a[index1];
        a[index1]= a[index2];
        a[index2] = temp;
    }

    static void reverse(int[] a){
        int start = 0;
        int end = a.length - 1;
        while(end>start){
            swaparr(a, start, end);
            start++;
            end--;
        }
    }

    // naive approach for two sum problem
    // We can solve this problem in O(n) time using HashMap, but here we are solving it in O(n^2) time using brute force approach
    // We can solve this using two pointer approach if the array is sorted, but here we are solving it using brute force approach
    public int[] twoSumTwoPointer(int[] nums, int target) {
            Arrays.sort(nums);

            int left = 0;
            int right = nums.length - 1;

            while(left < right) {
                int sum = nums[left] + nums[right];

                if(sum == target)
                    return new int[]{nums[left], nums[right]};
                else if(sum < target)
                    left++;
                else
                    right--;
            }
            return new int[]{-1,-1};
    }

    // optimal approach for two sum problem using HashMap to store the complement of the current element and its index.
    // We can check if the complement exists in the HashMap,
    // if it does then we have found our pair, and we can return their indices. If it doesn't exist,
    // we can add the current element and its index to the HashMap for future reference.
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        // nums[i] = key
        // index = value

        for(int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if(map.containsKey(complement))
                return new int[]{map.get(complement), i};
            map.put(nums[i], i);

        }
        return new int[]{-1,-1};
    }

    public int[] twoSumNaive(int[] nums, int target) {
        for(int i = 0; i < nums.length; i++){
            for(int j = i; j< nums.length; j++ ){
                if (nums[i] + nums[j] == target){
                    return new int[] {i,j};
                }
            }
        }
        return new int[0];
    }
}
