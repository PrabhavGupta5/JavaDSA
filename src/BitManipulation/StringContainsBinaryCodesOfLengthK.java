package BitManipulation;

import java.util.HashSet;

// https://leetcode.com/problems/check-if-a-string-contains-all-binary-codes-of-size-k/description/?envType=problem-list-v2&envId=bit-manipulation
public class StringContainsBinaryCodesOfLengthK {
    public boolean hasAllCodes(String s, int k) {
        HashSet<String> set = new HashSet<>();
        for(int i = 0; i <= s.length() - k; i++) {
            set.add(s.substring(i,i+k));
        }
        int total = 1;
        for(int i = 0; i < k; i++) {
            total = 2 * total; // Total number of binary codes of size k = 2^k, for 2 it is 4 (00, 01, 10, 11), for 3 it is 8 (000, 001, 010, 011, 100, 101, 110, 111)
        }
        if(set.size() == total) // If the size of the set is equal to total number of binary codes of size k, then we have all the binary codes in the string
            return true;
        return false;
    }
}
