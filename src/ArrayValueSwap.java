import java.util.Arrays;

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

    public int[] twoSum(int[] nums, int target) {
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
