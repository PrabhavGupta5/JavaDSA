package Greedy;

// https://leetcode.com/problems/gas-station/description/
// https://www.youtube.com/watch?v=fOaUh1_fJPw
public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0, totalCost = 0;

        // Calculate total gas and total cost
        for (int i = 0; i < gas.length; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
        }

        // If total gas is less than total cost, return -1
        if (totalGas < totalCost) {
            return -1;
        }

        int currentGas = 0;
        int startIndex = 0;
        // Iterate through the gas stations
        for (int i = 0; i < gas.length; i++) {
            currentGas += gas[i] - cost[i];
            // It is to check whether we can start from this current station or not, if currentGas is negative, it means we cannot start from this station, so we need to reset the start index to the next station and reset currentGas to 0, because we are starting from the next station.

            // If current gas is negative, reset start index and current gas
            if (currentGas < 0) {
                startIndex = i + 1;
                currentGas = 0;
            }
        }

        // Return the starting index if a valid circuit exists
        return startIndex;
    }
}
