package 문제집.backjoon.ContactBJ1013;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * date: 22.07.15
 * link: https://moonsbeen.tistory.com/241
 */

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = "(100+1+|01)+";
        int T = sc.nextInt();

        for(int t=0;t<T;t++){
            String input = sc.next();
            if(Pattern.matches(s,input)){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
    }
}
