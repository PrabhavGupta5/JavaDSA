package BitManipulation;

public class SumTwoIntegers {
    public int getSum(int a, int b) {
        int carry; // carry
        while(b != 0) {
            carry = a & b; // carry is the common set bits of a and b
            a = a ^ b; // Xor of a and b gives the sum of bits where at least one of the bits is not set
            b = carry << 1; // but why shifting to b is because carry is added to the left of the bit, so we need to shift it to left by 1
        }
        return a;
    }
}
