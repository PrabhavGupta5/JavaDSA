package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinations {
    public List<String> letterCombinations(String digits) {
        // return basically all permutations mapped to digits
        List<String> result = new ArrayList<>();
        String[] map={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        backtrack(digits, 0, result, new StringBuilder(), map);
        return result;

    }

    public void backtrack(String digits, int index, List<String> result, StringBuilder sb, String[] map) {
        if(index == digits.length()){
            result.add(sb.toString());
            return;
        }

        String letters = map[digits.charAt(index) - '0'];

        for(int i = 0; i < letters.length(); i++) {
            char ch = letters.charAt(i);

            sb.append(ch);

            backtrack(digits, index+1, result, sb, map); // because we are checking for next character in digits so index+1

            sb.deleteCharAt(sb.length() - 1);
        }

    }

    // Input: digits = "23"
    // Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]

}
