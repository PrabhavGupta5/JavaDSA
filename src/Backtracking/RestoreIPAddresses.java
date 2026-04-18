package Backtracking;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/restore-ip-addresses/description/?envType=problem-list-v2&envId=backtracking
public class RestoreIPAddresses {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        backtrack(s, 0, 0, "" , res);
        return res;
    }

    public void backtrack(String s, int index, int parts, String path, List<String> res) {
        // Base conditions to exit
        if (parts == 4 && index == s.length()) {
            res.add(path.substring(0, path.length() - 1)); // remove last dot
            return;
        }

        for(int len = 1; len <= 3; len++) {
            if(index + len > s.length()) break;

            String segment = s.substring(index, index + len);
            // check for leading zero
            if(segment.length() > 1 && segment.charAt(0) == '0') continue;
            // check for valid integer
            int value = Integer.parseInt(segment);
            if(value < 0 || value > 255) continue;

            // backtrack
            backtrack(s, index + len, parts + 1, path + segment + ".", res);

            // here no need to manually remove in string as it is immutable in java
        }

    }
}
