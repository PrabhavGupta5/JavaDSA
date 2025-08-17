import java.util.Scanner;

public class ReverseNumber {
    // print reverse of a number
    // 3456 -> 6543
    // n%10 = rem, rem *10 + rem next line mai

    public static void main(String[] args) {
        int num = 3456;
        int ans = 0;
        while(num>0){
            int rem = num%10;
            ans = ans*10 + rem;
            num=num/10;
        }
        System.out.println(ans);
    }
}
