package Arrays;

public class TaskScheduler {
    // https://leetcode.com/problems/task-scheduler/description/
    // We are using a frequency array to count the frequency of each task, then we find the maximum frequency
    // and the number of tasks that have the maximum frequency. The result is calculated by using the formula: (maxFreq - 1) * (n + 1) + countMax,
    // where maxFreq is the maximum frequency and countMax is the number of tasks that have the maximum frequency.
    // Finally, we return the maximum of the length of the tasks array and the result.
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        // tasks = ["A","A","A","B","B","B"], n = 2
        for (char task : tasks) {
            freq[task - 'A']++;
        }

        // Find the maximum frequency and the number of tasks countMax that have the maximum frequency
        int maxFreq = 0;
        for (int f : freq) {
            maxFreq = Math.max(maxFreq, f);
        }

        int countMax = 0;
        for (int f : freq) {
            if (f == maxFreq) countMax++;
        }

        // Calculate the result using the formula: (maxFreq - 1) * (n + 1) + countMax
        int result = (maxFreq - 1) * (n + 1) + countMax;

        // Return the maximum of the length of the tasks array and the result
        // This is because if the result is less than the length of the tasks array, it means that we can schedule all tasks without any idle time so return the length.
        return Math.max(tasks.length, result);
    }
}
