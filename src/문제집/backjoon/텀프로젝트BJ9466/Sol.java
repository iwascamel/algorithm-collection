package 문제집.backjoon.텀프로젝트BJ9466;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sol {
    static int n, cnt;
    static int[] link;
    static boolean[] check, isSearchEnd;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int t = Integer.parseInt(br.readLine());

        for (int test = 0; test < t; test++) {
            n = Integer.parseInt(br.readLine());
            link = new int[n + 1];
            check = new boolean[n + 1];
            isSearchEnd = new boolean[n + 1];

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i < n + 1; i++) {
                int to = Integer.parseInt(st.nextToken());
                link[i] = to;
            }
            cnt = 0;
            for (int i = 1; i < n + 1; i++) {
                dfs(i);
            }
            System.out.println(n - cnt);
        }

    }

    static void dfs(int pos) {
        check[pos] = true;
        int next = link[pos];
        if (!check[next]) {
            dfs(next);
        } else {
            if (!isSearchEnd[next]) {
                cnt++;
                while (next != pos) {
                    cnt++;
                    next = link[next];
                }
            }
        }
        isSearchEnd[pos] = true;
    }
}
