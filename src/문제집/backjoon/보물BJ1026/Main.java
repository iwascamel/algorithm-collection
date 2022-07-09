package 문제집.backjoon.보물BJ1026;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * date: 22.07.09
 */

public class Main {
    static int N;
    static Integer[] a1,a2;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("./src/문제집/backjoon/보물BJ1026/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        a1 = new Integer[N];
        a2 = new Integer[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            a1[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            a2[i] = Integer.parseInt(st.nextToken());
        }

        Comparator<Integer> comp = (o1, o2) -> Integer.compare(o2,o1);
        Arrays.sort(a1);
        Arrays.sort(a2, comp);

        int res = 0;

        for(int i=0;i<N;i++){
            res += a1[i] * a2[i];
        }
        System.out.println(res);
    }
}
