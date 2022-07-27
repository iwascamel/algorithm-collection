package 문제집.backjoon.성냥개비BJ3687;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class SolV2 {

    static int N;
    static long[] minDp;
    static int M;

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("./src/문제집/backjoon/성냥개비/input.txt"));
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();

        while (testCase-- > 0) {

            N = sc.nextInt();

            minDp = new long[101];

            Arrays.fill(minDp, Long.MAX_VALUE);
            minDp[2] = 1;
            minDp[3] = 7;
            minDp[4] = 4;
            minDp[5] = 2;
            minDp[6] = 6;
            minDp[7] = 8;
            minDp[8] = 10;

            String[] add = { "1", "7", "4", "2", "0", "8" };

            for (int i = 9; i <= 100; i++) {
                //9부터 (7 , 0) (6,1)
                for (int j = 2; j <= 7; j++) {
                    String line = "" + minDp[i - j] + add[j - 2];
                    minDp[i] = Math.min(Long.parseLong(line), minDp[i]);
                }
            }

            StringBuilder max = new StringBuilder();
            long a = N / 2;
            long b = N % 2;

            if(b == 1) {
                max.append("7");
            }else {
                max.append("1");
            }

            for(int i = 1; i < a; i++) {
                max.append("1");
            }
            System.out.println(minDp[N] + " " + max.toString());
        }
        sc.close();
    }
}