package Arrays;

// https://leetcode.com/problems/average-waiting-time/description/
public class AvgWaitingTime {
    public double averageWaitingTime(int[][] customers) {
        // return the average waiting time
        // customers[i] = [arrival of i, cooking time for i]

        long totalWait = 0, currentTime = 0;
        for(int[] customer : customers) {
            long arrival = customer[0];
            long cooking = customer[1];

            long startTime = Math.max(currentTime, arrival);

            long finishTime = startTime + cooking;

            totalWait = totalWait + finishTime - arrival; // waiting time = finish time - arrival time
            currentTime = finishTime; // update the current time to the finish time of the current customer
        }
        return (double) totalWait/customers.length;
    }
}
