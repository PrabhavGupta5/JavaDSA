import java.util.*;
//import java.util.ArrayList;

public class ArrayListExample {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        int[] arrr = new int[5];
        System.out.println(arrr.length);
        arr.add(5);
        arr.remove(0);
        arr.add(65);
        arr.add(53);
        for(int num: arr){
            System.out.print(num + " ");
        }
        System.out.println("Length of an array is " + arr);
        System.out.println("Arraylist size is : " + arr.size());

    }
}
