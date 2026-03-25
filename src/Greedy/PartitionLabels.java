package Greedy;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/partition-labels/description/
// https://www.youtube.com/watch?v=aUVEMnlcw4E
public class PartitionLabels {
    // Using last occurrence of each character
    public List<Integer> partitionLabels(String str) {
        List<Integer> partitions = new ArrayList<>();

        for (int i = 0; i < str.length(); ) {

            // Get first and last index of first character
            int startIndex = i;
            int endIndex = str.lastIndexOf(str.charAt(startIndex));

            for (int s = startIndex + 1; s <= endIndex - 1; s++) {

                // Find last index of any subsequent characters
                int lastIndexOfNextChar = str.lastIndexOf(str.charAt(s));

                if (lastIndexOfNextChar > endIndex) { // If last index of any subsequent character is greater than current endIndex
                    // Update endIndex if required
                    endIndex = lastIndexOfNextChar;
                }
            }

            partitions.add(endIndex - startIndex + 1);
            i = endIndex + 1;
        }

        return partitions; // Return the list of partition sizes
    }
}

// We can also solve this problem using a HashMap or frequency array, we will store the last occurrence of each character in the string, then we will iterate through the string and for each character we will check if its last occurrence is greater than the current end index, if it is then we will update the end index, if it is not then we will add the length of the partition to the result list and update the start index to the next character.