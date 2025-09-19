package Recursion;

import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation {
    public List<String> letterCasePermutation(String s) {
        ArrayList<String> res = new ArrayList<>();
        String op = "";
        String ip = s;
        solve(op, ip, res);
        return res;
    }

    public void solve(String op, String ip, ArrayList<String> res) {
        if(ip.length() == 0) {
            res.add(op);
            return;
        }
        char currentChar = ip.charAt(0);

        if(Character.isLetter(currentChar)) {
            String op1 = op + Character.toLowerCase(currentChar);
            String op2 = op + Character.toUpperCase(currentChar);

            solve(op1, ip.substring(1), res);
            solve(op2, ip.substring(1), res);
        }

        else {
            String op3 = op + currentChar;
            solve(op3, ip.substring(1), res);
        }
    }
}