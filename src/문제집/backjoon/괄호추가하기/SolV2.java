package 문제집.backjoon.괄호추가하기;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * https://lotuslee.tistory.com/21
 */

public class SolV2 {
    static int N;
    static int[] num;
    static char[] op;
    static int max = Integer.MIN_VALUE;
    static boolean[] check;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        num = new int[N / 2 + 1];
        op = new char[N / 2];

        String str = br.readLine();
        int idx1 = 0;
        int idx2 = 0;

        for (int i = 0; i < str.length(); i++) {
            if (i % 2 == 0)
                num[idx1++] = str.charAt(i) - '0';
            else
                op[idx2++] = str.charAt(i);
        }

        for (int n = 0; n <= (N / 2 + 1) / 2; n++) {
            check = new boolean[N / 2 + 1];
            attach(n, 0, 1);
        }

        bw.write(max + "\n");
        bw.flush();

    }

    public static void attach(int n,int cnt, int idx) {
        if (cnt == n) {
            int i = 1;
            int res = num[0];

            while (i < num.length) {
                int m = 0;

                if (check[i]) {
                    switch (op[i]) {
                        case '+':
                            m = num[i] + num[i + 1];
                            break;
                        case '-':
                            m = num[i] - num[i + 1];
                            break;
                        case '*':
                            m = num[i] * num[i + 1];
                            break;
                    }
                }

                else
                    m = num[i];

                switch (op[i - 1]) {
                    case '+':
                        res += m;
                        break;
                    case '-':
                        res -= m;
                        break;
                    case '*':
                        res *= m;
                        break;
                }

                if (check[i])
                    i += 2;
                else
                    i++;

            }
            max = Math.max(max, res);
            return;
        }

        for (int i = idx; i < num.length - 1; i++) {
            check[i] = true;
            attach(n, cnt + 1, i + 2);
            check[i] = false;
        }
    }
}
