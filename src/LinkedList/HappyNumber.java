package LinkedList;

import java.util.HashSet;

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


    // Using Set

    public boolean isHappy2(int n) {
        // First create a set to check if that number is visited or not, if not proceed
        // as if is visited it will be in a loop so not happy number
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