package DynamicProgramming;
import java.util.Arrays;

// https://leetcode.com/problems/super-egg-drop/
// https://www.youtube.com/watch?v=jkygQmOiCCI&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=45

public class EggDropping {
    int[][] t;

    public int superEggDrop(int e, int f) {
        t = new int[e+1][f+1];
        for(int[] a : t)
            Arrays.fill(a, -1);
        return solve(e,f);
    }

    public int solve(int e, int f){
        if(f==0 || f==1) return f;
        if(e==1) return f;

        if(t[e][f] != -1) return t[e][f];

        int ans = Integer.MAX_VALUE;

        int left = 1, right = f;

        while(left <= right){
            int k = left + (right - left) / 2;

            int low = solve(e-1, k-1);
            int high = solve(e, f-k);
            int temp = 1 + Math.max(low, high);
            ans = Math.min(ans, temp);

            if(low < high)
                left = k + 1;
            else
                right = k - 1;

        }
        return t[e][f] = ans;
    }

}