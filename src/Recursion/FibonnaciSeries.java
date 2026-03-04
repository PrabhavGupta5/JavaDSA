package Recursion;

public class FibonnaciSeries {

    // https://leetcode.com/problems/fibonacci-number/description/
    public int fib(int n) {
        // base condition
        if(n == 0)
            return 0;
        if(n == 1)
            return 1;
        // Induction step
        return fib(n-1) + fib(n-2);
    }


    // This is for finding the factorial of a number using recursion
    public int factorial(int n) {
        if(n == 1)
            return 1;
        return n * factorial(n-1);
    }
}
