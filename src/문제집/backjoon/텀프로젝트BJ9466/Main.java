package 문제집.backjoon.텀프로젝트BJ9466;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * date: 22.08.05
 */

public class Main {
    static int T;
    static int N;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("./src/문제집/backjoon/텀프로젝트BJ9466/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        for(int t=0;t<T;t++){
            N = Integer.parseInt(br.readLine());
            arr = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0;i<N;i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

        }
    }
}
