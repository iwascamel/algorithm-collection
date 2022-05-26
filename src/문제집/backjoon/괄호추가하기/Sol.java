package 문제집.backjoon.괄호추가하기;

import java.io.*;
import java.util.*;

public class Sol {
    static int N;
    static ArrayList<Integer> num;
    static ArrayList<Character> op;
    static int answer = Integer.MIN_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        char[] cArr = br.readLine().toCharArray();
        num = new ArrayList<>();
        op = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            if ((i + 1) % 2 == 1) {
                num.add(Character.getNumericValue(cArr[i]));
            } else {
                op.add(cArr[i]);
            }
        }

        dfs(0, num.get(0));

        bw.write(answer + "\n");

        br.close();
        bw.close();
    }

    public static void dfs(int idx, int sum) {
        if (idx == op.size()) {
            answer = Math.max(answer, sum);
            return;
        }

        dfs(idx + 1, calculate(sum, num.get(idx + 1), op.get(idx))); // 괄호 치고 넘기기

        if (idx + 2 <= op.size()) {
            dfs(idx + 2, calculate(sum, calculate(num.get(idx + 1), num.get(idx + 2), op.get(idx + 1)), op.get(idx))); // 괄호 안 치고 넘기기
        }
    }

    public static int calculate(int a, int b, char op) {
        if (op == '+') {
            return a + b;
        } else if (op == '-') {
            return a - b;
        } else {
            return a * b;
        }
    }

}