package Backtracking;

import java.util.ArrayList;
import java.util.List;


// https://leetcode.com/problems/palindrome-partitioning/
public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        backtrack(s, result, new ArrayList<>(), 0);
        return result;
    }

    // Pick a valid substring → move start forward → repeat → store when string is fully consumed
    public void backtrack(String s, List<List<String>> result,  List<String> current, int start){
        if(start == s.length()) { // We used the whole string, it's a valid partition
            result.add(new ArrayList<String>(current));
            return;
        }

        for(int i = start; i < s.length(); i++) {
            String subString = s.substring(start, i+1);

            if(isPalindrome(subString)) {
                // add the substring in the current list
                current.add(subString);

                // explore, we need to pass some smaller input for s right,
                backtrack(s, result, current, i+1); // Each recursive call = "solve for remaining string"

                // remove
                current.remove(current.size() - 1);
            }
        }
    }

    public boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;

        while(left <= right) {
            if(s.charAt(left) != s.charAt(right))
                return false;
            left ++;
            right --;
        }
        return true;
    }
}
