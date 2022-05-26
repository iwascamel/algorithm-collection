package 문제집.backjoon.이즈리얼여눈부터가네;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * date: 22.03.24
 */

public class Main {
    static int N;
    static long MOD = 10000000007L;
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("./src/backjoon/이즈리얼여눈부터가네/input.txt"));
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();


    }
}
