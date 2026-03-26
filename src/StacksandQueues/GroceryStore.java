package StacksandQueues;

// Codility Question
// You are given a zero-indexed array A consisting of n integers: a0, a1, . . . , an−1.
//Array A represents a scenario in a grocery store, and contains only 0s and/or 1s:
//• 0 represents the action of a new person joining the line in the grocery store,
//• 1 represents the action of the person at the front of the queue being served and leaving
//the line.
//The goal is to count the minimum number of people who should have been in the line before
//the above scenario, so that the scenario is possible (it is not possible to serve a person if the
//line is empty).
public class GroceryStore {
    public int groceryStore(int[] A) {
        int size = 0;
        int minSize = 0;

        for (int x : A) {
            if (x == 0) { // person arrived, increases the queue size
                size++;
            } else {
                size--; // person served, decrease the size
            }

            minSize = Math.min(minSize, size);
        }

        return -minSize;
    }
}
