package SlidingWindow;


// https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/description/
public class MaximumNumberofVowelsIn {
    public int maxVowels(String s, int k) {
        int max = 0, left = 0, count = 0;

        for (int i = 0; i < s.length(); i++) {
            // If current character is a vowel, increment count
            if (s.charAt(i) == 'a' || s.charAt(i) == 'e'
                    || s.charAt(i) == 'i' || s.charAt(i) == 'o' || s.charAt(i) == 'u') {
                count++;
            }

            // If window size is greater than k, slide the window from the left
            if (i - left + 1 > k) {
                // If the left(removing character from the window ) character is vowel, decrement count
                if (s.charAt(left) == 'a' || s.charAt(left) == 'e'
                        || s.charAt(left) == 'i' || s.charAt(left) == 'o' || s.charAt(left) == 'u') {
                    count--;
                    // Early exit optimization: if max reached k, return immediately
                    if (max == k)
                        return max;
                }
                left++; // Move left pointer forward to shrink the window
            }
            // Update max vowels found so far
            max = Math.max(count, max);
        }
        return max;
    }
}
