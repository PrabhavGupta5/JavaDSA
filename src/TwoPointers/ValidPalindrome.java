package TwoPointers;

public class ValidPalindrome {
    // https://leetcode.com/problems/valid-palindrome/description/
    // We will use two pointers, one at the start and one at the end of the string, and we will move them towards
    // each other until they meet. We will skip non-alphanumeric characters and compare the characters at the
    // pointers. If they are not equal, then the string is not a palindrome.
    public boolean isPalindrome(String s) {
        // we are returning true at the end because if we have traversed the entire string and we have not found any mismatch, then the string is a palindrome.
        int left = 0, right = s.length() - 1;

        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left)))
                left++;

            while (left < right && !Character.isLetterOrDigit(s.charAt(right)))
                right--;

            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right)))
                return false;

            left++;
            right--;
        }
        return true;
    }
}
