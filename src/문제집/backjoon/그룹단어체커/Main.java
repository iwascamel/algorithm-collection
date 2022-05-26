package 문제집.backjoon.그룹단어체커;

import java.util.Scanner;
import java.util.HashSet;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * date: 22.04.08
 */

public class Main {
    static int N;

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("./input.txt"));
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        int answer = 0;
        out: for (int i = 0; i < N; i++) {
            HashSet<Character> set = new HashSet<>();
            String s = sc.next();
            set.add(s.charAt(0));

            for (int j = 0; j < s.length() - 1; j++) {
                if (s.charAt(j) != s.charAt(j + 1) && set.contains(s.charAt(j + 1))) {
                    continue out;
                }
                set.add(s.charAt(j+1));
            }
            answer++;
            System.out.println(s);
        }
        System.out.println(answer);
    }
}