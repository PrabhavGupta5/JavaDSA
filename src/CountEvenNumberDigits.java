//https://leetcode.com/problems/find-numbers-with-even-number-of-digits/description/
public class CountEvenNumberDigits {
    public static void main(String[] args) {
        int[] arr = {12,345,2,6,7896};
        System.out.println(findNum(arr));
    }

    static int findNum(int[] arr){
        int count = 0;
        for (int num : arr){
            if(even(num))
                count ++;
        }
        return count;

    }

    static int digits(int num){

        int count = 0;
        if (num<0)
            num = num *-1;
        if (num == 0)
            return 1;
        while(num>0){
                count++;
                num = num / 10;
        }
        return count;
    }

    static boolean even(int number){
        int numberOfDigits = digits(number);
        return numberOfDigits % 2 == 0;
    }
}
