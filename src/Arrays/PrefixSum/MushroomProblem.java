package Arrays.PrefixSum;

// This is basically Find the maximum sum of a subArray that you can cover starting from k in m steps
// A = [2, 3, 7, 5, 1]
//k = 2   (you start at index 2 → value = 7)
//m = 2   (you can move 2 times)
// We have to collect maximum mushrooms
public class MushroomProblem {
    public int mushroom(int k, int m, int[] arr){
        int[] prefix = new int[arr.length + 1];
        for (int i : prefix) {
            prefix[i+1] = prefix[i] + arr[i];
        }
        int max = 0;

        // Case 1: go left first
        for (int left = 0; left <= m; left++) {
            int leftPos = k - left;
            if (leftPos < 0) break;

            int rightMoves = m - 2 * left; //  we are moving to left, m moves we have to come back again so thats why * 2
            if (rightMoves < 0) continue;

            int rightPos = Math.min(arr.length - 1, k + rightMoves);

            int sum = prefix[rightPos + 1] - prefix[leftPos];
            max = Math.max(max, sum);
        }

        // Case 2: go right first
        for (int right = 0; right <= m; right++) {
            int rightPos = k + right;
            if (rightPos >= arr.length) break;

            int leftMoves = m - 2 * right;
            if (leftMoves < 0) continue;

            int leftPos = Math.max(0, k - leftMoves);

            int sum = prefix[rightPos + 1] - prefix[leftPos];
            max = Math.max(max, sum);
        }

        return max;

    }
}

// Start at k
//You can go left and right within m steps
//Pick a segment (range) you can cover
//Maximize sum of that segment