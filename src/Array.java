import java.util.Arrays;
import java.util.Scanner;

public class Array {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[4];

        for(int i = 0; i < arr.length; i++ ){
            arr[i] = sc.nextInt();
        }

        for(int num : arr){
            System.out.print(num + " ");
        }

        char[] yrr = new char[4];
        yrr[0] = 'a';
        System.out.println(yrr);

    }
}
