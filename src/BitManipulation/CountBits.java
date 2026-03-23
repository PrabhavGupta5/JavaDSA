package BitManipulation;

// https://leetcode.com/problems/counting-bits/?envType=problem-list-v2&envId=2jextkyj
public class CountBits {
    public int[] countBits(int n) {
        int[] res = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            res[i] = Integer.bitCount(i);
        }
        return res;

    }

    // 👉 You should instantly know:
    //	•	n & 1 → check last bit
    //	•	n | 1 → set last bit
    //	•	n ^ 1 → toggle last bit
    //	•	n >> 1 → divide by 2
    //	•	n << 1 → multiply by 2

    // n & (n - 1) → removes last set bit
    //n & -n      → isolates last set bit
    //n | (n + 1) → flips rightmost 0


}
