package 문제집.backjoon.수고르기;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * date: 22.03.30
 */

public class Main {
    static int N;
    static long M;
    static long[] arr;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("./src/backjoon/수고르기/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new long[N];

        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        long answer = Long.MAX_VALUE;

        int left = 0;
        int right = 0;

        while(true){
            if(right==N || left == N) break;

            if(arr[right] - arr[left] >= M){
                answer = Math.min(answer,arr[right]-arr[left]);
                left++;
            }else{
                right++;
            }
        }
        System.out.println(answer);
    }
}
