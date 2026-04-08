package SlidingWindow;

import java.util.HashMap;

// https://leetcode.com/problems/fruit-into-baskets/

public class FruitsIntoBasket {
    class Solution {
        // Return max continuous subArray that contains at most two distinct elements, digits(fruits)
        public int totalFruit(int[] fruits) {
            HashMap<Integer, Integer> map = new HashMap<>();
            int left = 0;
            int max = 0;

            for(int right = 0; right<fruits.length ; right++) {
                map.put(fruits[right], map.getOrDefault(fruits[right], 0) + 1);

                while(map.size() > 2) {
                    map.put(fruits[left], map.get(fruits[left])-1);

                    if (map.get(fruits[left]) == 0)
                        map.remove(fruits[left]);

                    left++;

                }

                max = Math.max(max, right - left + 1);

            }

            return max;
        }
    }
}
