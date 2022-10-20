
import java.util.*;
import java.util.regex.Pattern;

public class Main{
    public static void main(String[] args) {
        int a = 1;
        int b = 2;

        int[] arr = new int[3];


        arr[a++] = b++;

        System.out.println("a = " + a);
        System.out.println("b = " + b);
        System.out.println(Arrays.toString(arr));
    }
}
