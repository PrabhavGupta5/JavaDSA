import java.util.Scanner;

public class ArmstrongNo {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int num = sc.nextInt();
        //Boolean var = isArmstrong(153);
        //System.out.println(var);
        printAllArmstrong();
    }

    public static Boolean isArmstrong(int n){
        int original = n;
        int sum = 0;
        while(n > 0){
            int rem = n % 10;
            n = n / 10;
            sum = sum + rem*rem*rem;

        }
        return sum == original;
    }

    // print all armstrong number between 100 and 1000
    static void printAllArmstrong(){
        for(int i = 100; i < 1000; i++ ){
            Boolean var = isArmstrong(i);
            if (var)
                System.out.println(i);
        }
    }
}
