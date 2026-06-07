package Greedy;

public class MinimumNumberOfTapsToOpenToWaterGarden {

    // https://leetcode.com/problems/minimum-number-of-taps-to-open-to-water-a-garden/description/
    // example: n = 5, ranges = [3,4,1,1,0,0]
    // output: 1, because we can open the tap at position 0 which will water the whole garden from 0 to 5, so we only need to open one tap which
    // is the tap at position 0, so the output is 1.
    // The idea is to create a new array startEnd where startEnd[i] will store the maximum range of the tap that can water the garden from position i.
    // We will iterate through the ranges array and populate the startEnd array. Then we will use a greedy approach to find the minimum number of taps needed to water the whole garden.

    // https://www.youtube.com/watch?v=2hzsf3D9Xvw
    public int minTaps(int n, int[] ranges) {
        // new startEnd array that will store the maximum range of ith position
        int[] startEnd = new int[n+1];
        for(int i = 0; i < ranges.length; i++) {
            int start = Math.max(0, i - ranges[i]);
            int end = Math.min(n, i + ranges[i]);

            startEnd[start] = Math.max(end, startEnd[start]); // we will update the startEnd array at the start position with the maximum end position that we can reach from that start position, we will take the maximum of the current end position and the existing value in the startEnd array at that start position because there might be multiple taps that can water the garden from that start position, so we want to take the maximum end position that we can reach from that start position.

        }

        // Now we have populated our startEnd array,
        // we will start greedy approach
        int taps = 0, currEnd = 0, maxEnd = 0;
        for(int i = 0; i <= n; i++) {
            if(i > maxEnd) // if the current position is greater than the maximum end that we can reach from the current position, then it means that we cannot water the whole garden, so we will return -1.
                return -1;
            if(i > currEnd) { // if the current position is greater than the current end, then we need to open a new tap, so we will increment the taps count and update the current end to the maximum end that we can reach from the current position.
                taps++;
                currEnd = maxEnd;
            }

            maxEnd = Math.max(maxEnd, startEnd[i]);
        }

        return taps;
    }
}
