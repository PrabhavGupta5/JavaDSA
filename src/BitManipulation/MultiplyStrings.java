package BitManipulation;

public class MultiplyStrings {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";

        // Step 1: reverse both strings
        String a = new StringBuilder(num1).reverse().toString();
        String b = new StringBuilder(num2).reverse().toString();

        int[] res = new int[a.length() + b.length()];

        // Step 2: multiply
        for (int i = 0; i < a.length(); i++) {
            for (int j = 0; j < b.length(); j++) {
                int mul = (a.charAt(i) - '0') * (b.charAt(j) - '0'); // give me an example of this, if a = "123" and b = "456" then when i = 0 and j = 0 then mul = (1 - '0') * (4 - '0') = 1 * 4 = 4, when i = 0 and j = 1 then mul = (1 - '0') * (5 - '0') = 1 * 5 = 5, when i = 0 and j = 2 then mul = (1 - '0') * (6 - '0') = 1 * 6 = 6, when i = 1 and j = 0 then mul = (2 - '0') * (4 - '0') = 2 * 4 = 8, when i = 1 and j = 1 then mul = (2 - '0') * (5 - '0') = 2 * 5 = 10, when i = 1 and j = 2 then mul = (2 - '0') * (6 - '0') = 2 * 6 = 12, when i = 2 and j = 0 then mul = (3 - '0') * (4 - '0') = 3 * 4 = 12, when i = 2 and j = 1 then mul = (3 - '0') * (5 - '0') = 3 * 5 = 15, when i = 2 and j = 2 then mul = (3 - '0') * (6 - '0') = 3 * 6 = 18
                // then in sum what we are doing is we are adding the mul to the existing value in res[i + j] because we are multiplying two digits and adding it to the existing value in res[i + j], if the sum is greater than 10 then we need to add the carry to the next position in res[i + j + 1], show example
                int sum = res[i + j] + mul; // what is res[i + j] here? it is the existing value in res[i + j] because we are multiplying two digits and adding it to the existing value in res[i + j]
                res[i + j] = sum % 10; // here we are storing the last digit of the sum in res[i + j] because we are multiplying two digits and adding it to the existing value in res[i + j]
                res[i + j + 1] += sum / 10; // here we are adding the carry to the next position in res[i + j + 1] because we are multiplying two digits and adding it to the existing value in res[i + j], if the sum is greater than 10 then we need to add the carry to the next position in res[i + j + 1]
            }
        }

        // Step 3: build result (skip leading zeros), here res will look like [0, 8, 0, 7, 3, 1] for "123" * "456" = "56088"
        StringBuilder sb = new StringBuilder();

        for (int i = res.length - 1; i >= 0; i--) {
            if (!(sb.isEmpty() && res[i] == 0)) {
                sb.append(res[i]); // here
            }
        }

        return sb.toString();
    }
}
