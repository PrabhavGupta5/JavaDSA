import java.util.Arrays;

public class PassingInFunction {
    // Arrays are mutable in java but strings are immutable they can't change
    public static void main(String[] args) {
        String a = "Prabha";
        System.out.println(a);
        change(a);
        System.out.println(a);

        int[] arr = {1,2,3};
        change(arr);
        System.out.println(Arrays.toString(arr));

    }

    static void change(String b){
        b = "Changed";
    }

    static void change(int[] a){
        a[0] = 23;
    }
}
