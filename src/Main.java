import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.print("Hello and welcome!");
        System.out.println();
        Scanner input = new Scanner(System.in);
        String nextLine = input.next().trim();
        System.out.println(nextLine);

        int[] arr = {1, 2, 3, 4, 5};

        ArrayList<Integer> list = new ArrayList<>();
        list.add(78);
        list.add(90);
        Iterator<Integer> iterator = list.iterator();
        Iterator<Integer> itr = Arrays.stream(arr).iterator(); // we are creating an iterator for the array arr using the Arrays.stream(arr).iterator() method, which allows us to iterate through the elements of the array using the iterator's method, but why
        while(iterator.hasNext()) {
            System.out.println(iterator.next()); // we are using the next() method of the iterator to get the next element in the list, and we are printing it out
        }

    }
}