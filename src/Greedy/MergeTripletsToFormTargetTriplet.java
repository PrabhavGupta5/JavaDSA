package Greedy;

// https://leetcode.com/problems/merge-triplets-to-form-target-triplet/
public class MergeTripletsToFormTargetTriplet {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        boolean a = false;
        boolean b = false;
        boolean c = false;

        for (int[] t : triplets) {

            if (t[0] > target[0] || t[1] > target[1] || t[2] > target[2])  // if any of the value in triplet is greater than target then we can not use that triplet to merge to form target
                continue;

            if (t[0] == target[0]) a = true; // if the value in triplet is equal to target then we can use that triplet to merge to form target
            if (t[1] == target[1]) b = true; // as we are choosing maximum value of each index in triplet to form target so we can use that triplet to merge to form target
            if (t[2] == target[2]) c = true;
        }

        return a && b && c;
    }
}
