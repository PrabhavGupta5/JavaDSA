package DynamicProgramming;

import java.util.HashMap;
import java.util.Map;

// https://www.youtube.com/watch?v=SqA0o-DGmEw&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=40&pp=iAQB
// https://leetcode.com/problems/scramble-string/
// here the main trick of this question is to write swap and noSwap conditions, try by forming an example that will be easy
public class ScrambleString {
    Map<String, Boolean> map = new HashMap<>();
    public boolean isScramble(String s1, String s2) {
        // Base Condition
        if(s1.equals(s2))
            return true;

        String key = s1 + "_" + s2;
        if(map.containsKey(key))
            return map.get(key);
        boolean flag = false;
        int n = s1.length() ;
        for(int i = 1; i < n; i++ ){
            boolean swap=(isScramble(s1.substring(0, i),s2.substring(n - i,n)) && isScramble(s1.substring(i,n),s2.substring(0, n-i)));

            boolean noSwap=(isScramble(s1.substring(0, i),s2.substring(0, i))  && isScramble(s1.substring(i, n),s2.substring(i, n)));

            if(swap || noSwap){
                flag = true;
                break;
            }
        }

        map.put(key, flag);
        return flag;

    }
}