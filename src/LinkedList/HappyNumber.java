package LinkedList;

import java.util.HashSet;

// https://leetcode.com/problems/happy-number/
// happy number is a number which when repeatedly replaced by the sum of the square of its digits, eventually becomes 1. If it loops endlessly in a cycle which does not include 1, then it is not a happy number.
// example: 19 is a happy number, as the process is 1^2 + 9^2 = 82, then 8^2 + 2^2 = 68, then 6^2 + 8^2 = 100, then 1^2 + 0^2 + 0^2 = 1.
public class HappyNumber {

    public boolean isHappy(int n) {
        int slow = n, fast = n; // we are using the same approach as linked list cycle detection, we will use two pointers, one slow and one fast, if they meet then there is a cycle, if they meet at 1 then it is a happy number

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


    // Using Set

    public boolean isHappy2(int n) {
        // First create a set to check if that number is visited or not, if not proceed
        // as if is visited it will be in a loop so not happy number
        // why use set
        HashSet<Integer> set = new HashSet<>();

        while(!set.contains(n)) { // We are iterating for every n which calc calculates, which is not present, it will stop when n becomes n or n is present in the set
            set.add(n);
            n = calc(n);

            if(n == 1)
                return true;
        }
        return false;
    }

    // create a function to calculate the sum of digits and return the number
    public int calc(int n) {
        int sum = 0;

        while(n>0) {
            int digit = n % 10;
            sum = sum + digit * digit;
            n = n / 10;
        }

        return sum;
    }
}