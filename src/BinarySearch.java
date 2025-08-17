import static java.lang.Boolean.TRUE;

public class BinarySearch {
    public static void main(String[] args) {

        //int[] arr = {2, 5, 7, 9, 12, 16, 20};
        int[] arr = {20, 15, 10, 8, 5, 3};

        int result = binarysrch(arr, 5);
        System.out.println(result);
    }

    public static int binarysrch(int[] arr, int target){
        int start = 0;
        int end = arr.length - 1;
        boolean isAsc = arr[start] < arr[end];

        while(start <= end){
            int mid = (start + end) / 2;

            if(arr[mid]==target)
                return mid;

            if(isAsc){
                if(arr[mid] < target)
                    start = mid + 1;
                else if(arr[mid] > target)
                    end = mid - 1;
            }
            else {
                if(arr[mid] < target)
                    end = mid - 1;
                else
                    start = mid + 1;
            }
        }
        return -1;
    }
}
