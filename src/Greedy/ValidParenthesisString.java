package Greedy;

// This question can be solved by Recursion + Memoization, Bottom up, Stack and Greedy
// https://leetcode.com/problems/valid-parenthesis-string/description/
// https://www.youtube.com/watch?v=Pno2hATcwHA
public class ValidParenthesisString {

    Boolean[][] dp = new Boolean[101][101];

    public boolean checkValidString(String s) {
        return solve(s, 0, 0);
    }

    private boolean solve(String s, int i, int open) {
        // invalid case
        if (open < 0) return false;

        // base case
        if (i == s.length()) { // if we have reached the end of the string, then we need to check if there are any open parentheses left, if there are then it is not a valid string, otherwise it is a valid string.
            return open == 0;
        }

        // memo check
        if (dp[i][open] != null) {
            return dp[i][open];
        }

        boolean isValid = false;

        if (s.charAt(i) == '(') {
            isValid = solve(s, i + 1, open + 1);
        }
        else if (s.charAt(i) == ')') {
            isValid = solve(s, i + 1, open - 1);
        }
        else { // '*'
            isValid = solve(s, i + 1, open + 1) ||  // treat as '('
                      solve(s, i + 1, open - 1) ||  // treat as ')'
                      solve(s, i + 1, open);        // treat as empty
        }

        return dp[i][open] = isValid;
    }


    // Another way to solve this problem is by using a stack, we can use two stacks, one for storing the index of the open parentheses and another for storing the index of the '*' characters, then we can iterate through the string and for each character we will check if it is an open parenthesis, if it is then we will push its index to the open stack, if it is a '*' character then we will push its index to the star stack, if it is a close parenthesis then we will check if there is an open parenthesis in the open stack, if there is then we will pop it from the open stack, if there is no open parenthesis in the open stack then we will check if there is a '*' character in the star stack, if there is then we will pop it from the star stack, if there is no '*' character in the star stack then it means that there is no matching open parenthesis for this close parenthesis and we can return false, after iterating through the string we need to check if there are any open parentheses left in the open stack, if there are then we need to check if there are enough '*' characters in the star stack to match them, if there are not enough '*' characters in the star stack to match all the open parentheses in the open stack then it means that there are some unmatched open parentheses and we can return false, otherwise we can return true.


    // greedy approach
    public boolean greedyApproach(String s) {
        int low = 0, high = 0;

        for (char c : s.toCharArray()) {

            if (c == '(') {
                low++;
                high++;
            }
            else if (c == ')') {
                low--;
                high--;
            }
            else { // '*' // if we encounter a '*' character, we have three options: we can treat it as an open parenthesis '(', we can treat it as a close parenthesis ')', or we can treat it as an empty string. To account for all these possibilities, we will increment the high variable by 1 to represent the case where we treat '*' as '(', and we will decrement the low variable by 1 to represent the case where we treat '*' as ')'. The low variable will represent the minimum number of open parentheses that we need to match, and the high variable will represent the maximum number of open parentheses that we can have at any point in time. By updating these variables accordingly, we can keep track of the range of valid open parentheses counts as we iterate through the string.
                low--;      // treat as ')'
                high++;     // treat as '('
            }

            // invalid case
            if (high < 0)  // if high is less than 0, it means that we have more close parentheses than open parentheses at this point, which is invalid, so we can return false.
                    return false;

            // low should never go below 0
            if (low < 0)  // if low is less than 0, it means that we have more close parentheses than open parentheses at this point, which is invalid, so we can reset low to 0 to represent the case where we treat '*' as an empty string, which allows us to continue checking the rest of the string without considering the unmatched close parentheses as invalid.
                low = 0;
        }

        return low == 0; // if low is 0 at the end, it means that we have matched all open parentheses with close parentheses, and we can return true, otherwise it means that there are some unmatched open parentheses and we can return false.
    }


}
