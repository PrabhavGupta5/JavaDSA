import java.util.Arrays;

public class ShadowingVar {
    static int x;
    public static void main(String[] args) {
        System.out.println(x);
        int x=7550;
        {
           // int x = 67; variable x is already defined in the scope, cant do that
            System.out.println(x);
        }
        System.out.println(x);

    }
}
