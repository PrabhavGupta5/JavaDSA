package BitManipulation;

import java.util.HashSet;

public class SingleNumber {
    public int singleNumber(int[] nums) {
         // We will use Set in this question, if the key is present in set, delete the existing key and then whatever is left in set return that.
         int n = nums.length;
         HashSet<Integer> set = new HashSet<>();

         for(int i = 0; i<n; i++)
             {
                 if(set.contains(nums[i])){
                     set.remove(nums[i]);
                 }
                 else
                     set.add(nums[i]);
             }

         return set.iterator().next(); // Using iterator to iterate over an element in a set

    }

    // Using XOR
    public int singleeNumber(int [] nums) {
        int res = 0;

        for(int num : nums) {
            res ^= num;
        }

        return res;
    }
}
