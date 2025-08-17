// https://leetcode.com/problems/richest-customer-wealth/description/

public class RichestCustomerWealth {
    public static void main(String[] args) {
    int[][] wealth = {{1,1,3},{3,2,1}};
    System.out.println(maximumWealth(wealth));
    }

    public static int maximumWealth(int[][] accounts) {
        // row = person
        // col = accounts
        int ans = Integer.MIN_VALUE;
        for (int[] person : accounts){
            int sum = 0;
            for (int account : person)
            {
                sum = sum + account;
            }
            if(sum > ans)
                ans = sum;
        }
        return ans;
    }
}
