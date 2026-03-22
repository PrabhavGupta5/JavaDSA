package BitManipulation;

// https://leetcode.com/problems/plus-one/
public class PlusOne {
    public int[] plusOne(int[] digits) {
        // we have to increment the last digit by 1, carry problem it is :
        int n = digits.length;
        for(int i = n-1; i >= 0; i--) {
            if(digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }

        // for numbers that only contain 9
        int[] res  = new int[digits.length + 1];
        res[0] = 1;
        return res;
    }

    public String addBinary(String a, String b) {
        // we will make a variable sum stringBuilder
        // length of each string a and b, add that ith element to sum, we will make the sum % 2, and carry / 2 as its binary then return sum.

        StringBuilder res = new StringBuilder();

        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;

        while(i>=0 || j >=0 || carry != 0){
            int sum = carry;

            if(i>=0) {
                sum = sum + a.charAt(i) - '0';
                i--;
            }

            if(j>=0) {
                sum = sum + b.charAt(j) - '0';
                j--;
            }

            res.append(sum % 2);
            carry = sum / 2;
        }

        return res.reverse().toString();
    }
}
