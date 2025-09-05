package TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


// https://leetcode.com/problems/3sum/
// We did this problem by fixing one index and then moving two pointers just like 2 Sum

public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        for(int i = 0; i < nums.length; i++) {
            if(i>0 && nums[i] == nums[i-1])
                continue;

            int j = i + 1;
            int k = nums.length -1;

            while(j<k){
                int total = nums[i] + nums[j] + nums[k];
                if(total < 0)
                    j++;
                else if(total > 0)
                    k--;
                else{
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;

                    while(nums[j] == nums[j-1] && j<k){
                        j++;
                    }
                }
            }
        }
        return res;
    }
}
