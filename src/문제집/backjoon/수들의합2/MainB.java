package 문제집.backjoon.수들의합2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * date: 22.04.05
 */

public class MainB {
    static int N;
    static long M;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("./src/backjoon/수들의합2/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int left = 0;
        int right = 0;
        int answer = 0;
        int sum = 0;

        while (true) {
            if (sum == M) answer++;
            if (sum >= M) {
                sum -= arr[left];
                left++;
            } else if(right==N){
                break;
            } else{
                sum += arr[right];
                right++;
            }
        }
        System.out.println(answer);
    }
}
