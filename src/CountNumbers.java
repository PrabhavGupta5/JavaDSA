import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;

public class CountNumbers {
    // count number of digits in a number
    // 67857 -> count(7)=2

    public static void main(String[] args) {
        int number = 67857;
        int count = 0;

        while(number>0){
            int rem = number % 10;
            if (rem == 7)
                count++;
            number /= 10;
        }
        System.out.println(count);

        // count number of digits in a number
        int n = 523;
        int counter = 0;
        while(n > 0) {
            n /= 10;
            counter++;
        }
        System.out.println(counter);

        // print an array in reverse order
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println("Array in normal order: ");
        for (int j : arr) {
            System.out.print(j + " ");
        }
        System.out.println("Array in reverse order: ");
        for(int i = arr.length - 1; i >= 0; i--) {
            System.out.print(arr[i] + " ");
        }

        // There's 1 to n integers, print the sum of all the integers
        // n = 5 -> 1 + 2 + 3 + 4 + 5 = 15
        int num = 10;
        int sum = 0;
        for (int i = 1; i <= num; i++) {
            sum = sum + i;
        }
        System.out.println("Sum of first " + num + " integers is: " + sum); // This is O(n) time complexity

        // Even better way to do this is using the formula n(n+1)/2 which gives us the sum of first n integers in O(1) time complexity
        int sumFormula = num * (num + 1)/ 2;
        System.out.println("Sum of first " + num + " integers using formula is: " + sumFormula);

        int[] a = {2,3,4};
        int[] b = {2,3,6};
        boolean resSwap = swapSum(a, b);
        System.out.println(resSwap);
        int[] res = swapSum2(a,b);
        System.out.println("pair of swap sum : " + Arrays.toString(res));

        int[] sort = {2,2,4,5,5,3,6};

        System.out.println(distinctSort(sort));

        functional();
    }

    // Calculate the sum of two arrays sumA and sumB and swap the numbers in each and return true if the sum of both arrays is equal after swapping, otherwise return false
    public static boolean swapSum(int[] a, int[] b) {
        int sumA = 0;
        int sumB = 0;

        for(int i : a) {
            sumA = sumA + i;
        }
        for(int i : b) {
            sumB = sumB + i;
        }

        if((sumA - sumB) % 2 != 0)
            return false;

        int target = (sumA - sumB) / 2;

        HashSet<Integer> set = new HashSet<>();
        for (int i : a)
            set.add(i);

        for(int j : b) {
            if(set.contains(j+target))
                return true;
        }
        return false;
    }

    // return pair in this case:
    public static int[] swapSum2(int[] a, int[] b) {
        int sumA = 0;
        int sumB = 0;

        for(int i : a) {
            sumA = sumA + i;
        }
        for(int i : b) {
            sumB = sumB + i;
        }

        if((sumA - sumB) % 2 != 0)
            return new int[]{};

        int target = (sumA - sumB) / 2;

        HashSet<Integer> set = new HashSet<>();
        for (int i : a)
            set.add(i);

        for(int j : b) {
            if(set.contains(j+target))
                return new int[]{j + target,j};
        }
        return new int[]{};
    }

    // Given an array A → return number of UNIQUE (distinct) values
    // using a Set
    public int distinct(int[] A) {
        Set<Integer> set = new HashSet<>();
        for (int x : A) {
            set.add(x);
        }
        return set.size();
    }

    // using sorting
    public static int distinctSort(int[] A) {
        Arrays.sort(A);
        int count = 1;
        for(int i = 1; i < A.length; i++) {
            if(A[i] != A[i-1])
                count ++;
        }
        System.out.println("Using Sorting distinct elements in Array are: " + count);
        return count;
    }

    public static void functional() {
        Function<Integer, Integer> half = a -> (a/2);
        Function<Integer,Integer> sub=a->a-3;
//        System.out.println(half.apply(10));
//        System.out.println(half.andThen();
//        System.out.println(half.compose());
        Function<Integer,Integer> result =half.andThen(a->a+5).compose(sub);

        System.out.println("-------------------");
        Consumer<Integer> res = (newres) -> System.out.println(newres);
        res.accept(result.apply(7));
    }

}
