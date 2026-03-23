package BitManipulation;

public class MagicNumber {
    public static void main(String[] args) {
        int res = magicNumber(5);
        System.out.println("Magic Number is " + res);
    }

    public static int magicNumber(int n) {
        int ans = 0;
        int base = 5;

        // While my number is greater than 0, I will keep on multiplying the base with 5 and adding to the answer

        while(n>0){
            int lastDigit = n & 1; // Get the last bit of n
            n = n >> 1; // Right shift n by 1 to remove the last bit
            // In my answer, I will only add the base if the last bit is 1, otherwise I will skip it
            ans = ans + lastDigit * base; // If lastDigit is 1, add the base to the answer, otherwise add 0
            base = base * 5; // Multiply the base by 5
        }

        return ans;
    }
}
