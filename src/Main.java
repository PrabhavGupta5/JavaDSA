import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.print("Hello and welcome!");
        System.out.println();
        Scanner input = new Scanner(System.in);
        String nextLine = input.next().trim();
        System.out.println(nextLine);

        ArrayList<Integer> list = new ArrayList<>();
        list.add(78);
        list.add(90);
        Iterator<Integer> iterator = list.iterator(); // we are creating an iterator to iterate through the list, we can also use a for-each loop to iterate through the list, but here we are using an iterator to demonstrate how to use it
        while(iterator.hasNext()) {
            System.out.println(iterator.next()); // we are using the next() method of the iterator to get the next element in the list, and we are printing it out
        }

    }
}