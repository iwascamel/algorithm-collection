package 문제집.backjoon.로프BJ2217;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * date: 22.07.10
 */

public class Main {
    static int N;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("./src/문제집/backjoon/로프BJ2217/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N  =Integer.parseInt(br.readLine());
        arr = new int[N];

        for(int i=0;i<N;i++){
            int v = Integer.parseInt(br.readLine());
            arr[i] = v;
        }
        Arrays.sort(arr);

        int max = 0;

        for(int i=0;i<N;i++){
            int temp = arr[i] * (N-i);
            max = Math.max(max,temp);
        }
        System.out.println(max);
    }
}
