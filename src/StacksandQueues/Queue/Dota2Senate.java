package StacksandQueues.Queue;
import java.util.*;

// https://leetcode.com/problems/dota2-senate/
// This question is nothing but a simulation of the process of elimination. We can use two queues to keep track of the indices of the Radiant and Dire senators. In each round, we compare the front of both queues, and the senator with the smaller index gets to eliminate the other. The survivor is then scheduled for the next round by adding n (the total number of senators) to their index and adding it back to their respective queue. This process continues until one of the queues is empty, indicating that all senators from that party have been eliminated. The remaining party is declared the winner.
public class Dota2Senate {
    class Solution {
        // Each queue stores the next available turns of all surviving senators.
        //The senator whose turn comes earlier gets to eliminate one opponent.
        //The survivor is scheduled for the next round by adding n.
        public String predictPartyVictory(String senate) {
            Queue<Integer> r = new LinkedList<>();
            Queue<Integer> d = new LinkedList<>();
            int n = senate.length();

            for (int i = 0; i < n; i++) {
                if (senate.charAt(i) == 'R')
                    r.offer(i);
                else
                    d.offer(i);
            }
            // till now, we have added all the indexes of R and D in their respective queues, now we will compare the first index of both queues, the one with smaller index will eliminate the other and will be added back to its queue with index + n, this will continue till one of the queue is empty

            while (!r.isEmpty() && !d.isEmpty()) {
                int rIndex = r.poll();
                int dIndex = d.poll();

                if (rIndex < dIndex)
                    r.offer(rIndex + n);
                else
                    d.offer(dIndex + n);
            }

            return r.isEmpty() ? "Dire" : "Radiant";
        }
    }
}
