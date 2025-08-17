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
    }
}
