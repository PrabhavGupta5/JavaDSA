package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


// https://leetcode.com/problems/group-anagrams/

// We are using frequency array to store the count of characters in the string
// and then comparing the frequency array for each string to group anagrams together
// We can't compare the frequency array directly as it is an int array, so we convert it to a
// string using Arrays.toString() method to get a unique key for each group of anagrams
// Time complexity : O(N*K) where N is the number of strings and K is the maximum length of a string
// Space complexity : O(N*K) for the hashmap and the result list
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map  = new HashMap<>();

        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }

        for(String s : strs) {

            int[] count = new int[26];
            for(char c : s.toCharArray()) {
                count[c-'a']++;
            }

            // Convert freq array to unique key to compare as int array can't be compared
            String key = Arrays.toString(count);

            List<String> list = map.get(key);

            if (list == null) {
                list = new ArrayList<>();
                map.put(key, list);
            }

            list.add(s);
        }

        return new ArrayList<>(map.values());
    }
}
