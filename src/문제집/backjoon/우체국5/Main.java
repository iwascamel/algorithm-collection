package 문제집.backjoon.우체국5;

import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * date : 21.10.05
 * memo : ssafy 알고리즘 평가 2번
 */

public class Main {

    static long V, P;
    static long L;
    static long[] arr;
    static long[] choice;
    static long minResult;
    static long[] police;

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);

        V = sc.nextLong();
        P = sc.nextLong();
        L = sc.nextLong();
        minResult = Long.MAX_VALUE;
        police = new long[(int)P];

        arr = new long[(int)V];
        choice = new long[(int)P];

        for (int i = 0; i < V; i++) {
            arr[i] = sc.nextInt();
        }

        comb(0, 0, new boolean[(int)V]);
        System.out.println(minResult);
        for (long a : police) {
            System.out.print(a + " ");
        }
        System.out.println();
    }

    private static void comb(int cnt, int start, boolean[] v) {
        if (cnt == P) {
            long res = 0;
            // 마을 순회
            for (long a : arr) {
                long min = Long.MAX_VALUE;
                // 선택된 경찰서 순회
                for (long c : choice) {
                    // 최소값 도출
                    long distance = (int) Math.min(Math.abs(a - c), Math.abs(Math.abs(a - c) - L));
                    min = Math.min(min, distance);
                }
                res += min;
            }

            // 해당 최소값과 전체의 최소값 비교
            if (minResult > res) {
                // 그때의 경찰서값 설정
                for (int i = 0; i < P; i++) {
                    police[i] = choice[i];
                }
                minResult = res;
            }
            return;
        }

        for (int i = start; i < V; i++) {
            choice[cnt] = arr[i];
            comb(cnt + 1, i + 1, v);
        }
    }
}

