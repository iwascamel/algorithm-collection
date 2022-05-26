package 문제집.backjoon.야구;

import java.util.Scanner;

/**
 * link : https://m.blog.naver.com/kerochuu/221551554171
 */

public class Sol {

    static int[] player = new int[10];
    static boolean[] picked = new boolean[10];
    static int[][] table;
    static int ining, point = 0;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ining = input.nextInt();

        table = new int[ining + 1][10];

        for (int i = 1; i <= ining; i++) {
            for (int j = 1; j <= 9; j++) {
                table[i][j] = input.nextInt();
            }
        }
        player[4] = 1;
        picked[4] = true;

        nextPermutation(2);
        System.out.println(point);

    }

    private static void nextPermutation(int playerNum) {

        if (playerNum == 10) {
            point = Math.max(point, calc());
            return;
        }

        for (int position = 1; position <= 9; position++) {
            if (!picked[position]) {
                picked[position] = true;
                player[position] = playerNum;
                nextPermutation(playerNum + 1);
                picked[position] = false;
            }
        }
    }

    private static int calc() {
        int startNum = 1;
        int tempSum = 0;
        for (int i = 1; i <= ining; i++) {
            int[] pt = { 0, 0, 0, 0, 0 };

            while (pt[0] < 3) {
                run(pt, table[i][player[startNum]]);
                if (startNum == 9) {
                    startNum = 1;
                } else {
                    startNum++;
                }
            }
            tempSum += pt[4];
        }
        return tempSum;
    }

    private static void run(int[] pt, int num) {
        for (int n = 0; n < num; n++) {
            pt[4] += pt[3];
            pt[3] = pt[2];
            pt[2] = pt[1];
            pt[1] = 0;
        }
        pt[num]++;
    }
}