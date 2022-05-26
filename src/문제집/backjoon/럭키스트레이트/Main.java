package 문제집.backjoon.럭키스트레이트;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("./src/backjoon/럭키스트레이트/input.txt"));
        Scanner sc = new Scanner(System.in);

        String number = sc.next();

        int preHalf = 0;
        int postHalf = 0;
        for(int i=0;i<number.length()/2;i++){
            int num = Integer.parseInt(String.valueOf(number.charAt(i)));
            preHalf += num;
        }
        for(int i=number.length()/2;i<number.length();i++){
            int num = Integer.parseInt(String.valueOf(number.charAt(i)));
            postHalf += num;
        }
        if(preHalf == postHalf) System.out.println("LUCKY");
        else System.out.println("READY");
    }
}
