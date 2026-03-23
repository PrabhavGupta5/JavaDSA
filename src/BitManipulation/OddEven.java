package BitManipulation;

public class OddEven {
    public boolean odd(int n) {
        return (n & 1) == 1; // If the last bit is 1, then the number is odd
    }
}
