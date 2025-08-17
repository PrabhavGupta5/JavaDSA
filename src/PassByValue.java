public class PassByValue {
    public static void main(String[] args) {

        int a = 5;
        inc(a);
        System.out.println(a);

        int[] arr = {11, 3, 69, 6};
        System.out.println(min(arr));
        System.out.println(max(arr));


    }
    static void inc(int x) { x++; }

    static int min(int[] num){
        int min = num[0];
        for (int i= 1 ; i < num.length ; i++ ){
            if(num[i]<min)
                min = num[i];
        }
        return min;

    }

    static int max(int[] num){
        int max = num[0];
        for (int i= 1 ; i < num.length ; i++ ){
            if(num[i]> max)
                max = num[i];
        }
        return max;

    }

}
