import java.util.ArrayList;

public class CeilingFloorElement {
    public static void main(String[] args) {
        int[] arr = {2, 5, 7, 9, 12, 16, 20};
        char[] letters = {'c','f','j'};
//        String a = null;
//        int num = null;

        ArrayList<Integer> list = new ArrayList<>();
        list.add(5);
        System.out.println(list);
        int result = ceilingElement(arr, 6);
        int result2 = floorElement(arr, 8);
        char letterResult = nextGreatestLetter(letters,'c');


        System.out.println("Result for ceiling element: " + result);
        System.out.println("Result for floor element: " + result2);
        System.out.println("Result for letter element: " + letterResult);
    }
    public static int ceilingElement(int[] arr, int target){
        int start = 0;
        int end = arr.length - 1;

        while(start <= end){
            int mid = (start + end) / 2;

            if(arr[mid]==target)
                return mid;

            if(arr[mid] < target)
                start = mid + 1;
            else if(arr[mid] > target)
                end = mid - 1;
        }
        return arr[start];
    }

    public static int floorElement(int[] arr, int target){
        int start = 0;
        int end = arr.length - 1;

        while(start <= end){
            int mid = (start + end) / 2;

            if(arr[mid]==target)
                return mid;

            if(arr[mid] < target)
                start = mid + 1;
            else if(arr[mid] > target)
                end = mid - 1;
        }
        return arr[end];
    }

    public static char nextGreatestLetter(char[] arr, char target) {
        int start = 0;
        int end = arr.length - 1;

        while(start <= end){
            int mid = (start + end) / 2;

            if(arr[mid]==target)
                return arr[mid+1];

            if(arr[mid] < target)
                start = mid + 1;
            else if(arr[mid] > target)
                end = mid - 1;
        }
        return arr[start % arr.length];
    }

}
