package 문제집.backjoon.직사각형을만드는방법;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        System.out.println(N*N/4-1);
    }
}
