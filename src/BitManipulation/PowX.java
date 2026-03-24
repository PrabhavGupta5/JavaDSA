package BitManipulation;

public class PowX {
    // using Recursion, Time complexity is O(n) and space complexity is O(n) because of recursive stack
    // It will give us TLE for large values of n, because it will make n recursive calls, and for each call it will do a multiplication, so the time complexity is O(n)
//    public double myPow(double x, int n) {
//        if(n==0)
//            return 1;
//        double xnm1 = myPow(x, n-1);
//        return xnm1 * x;
//    }

    // Optimised solution using divide and conquer, Time complexity is O(log n) and space complexity is O(log n) because of recursive stack
    // It will not give us TLE for large values of n, because it will make log n recursive calls, and for each call it will do a multiplication, so the time complexity is O(log n)
    public double myPowOptimised(double x, int n) {

        if (n == 0) return 1;

        long N = n; // handle overflow
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }

        return solve(x, N);
    }

    private double solve(double x, long n) {
        if (n == 0) return 1;

        double half = solve(x, n / 2);

        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }
}
