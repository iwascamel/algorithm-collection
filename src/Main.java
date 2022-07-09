
import java.util.*;
import java.util.regex.Pattern;

public class Main{
    public static void main(String[] args) {
        String c = "12a";

        System.out.println(Pattern.matches("[\\w]",String.valueOf(c)));
    }
}
