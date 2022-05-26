package 문제집.backjoon.탑;

import java.io.*;
import java.util.Scanner;

public class InputTest {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/backjoon/탑/input.txt"));

        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println(sc.nextInt());
        String s = sc.nextLine();
        System.out.println(s);
        System.out.println(br.readLine());
        System.out.println(br.readLine());

    }
}
