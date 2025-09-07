package SlowFastPointer;

// https://leetcode.com/problems/happy-number/
public class HappyNumber {

    public boolean isHappy(int n) {
        int slow = n, fast = n;

        do {
            slow = square(slow);
            fast = square(square(fast));
        }
        while(slow != fast);

        return slow == 1;
    }

    public int square (int num){
        int ans = 0;
        while(num > 0){
            int digit = num % 10;
            ans = ans + digit * digit;
            num /= 10;
        }
        return ans;
    }
}