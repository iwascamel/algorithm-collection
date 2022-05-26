package 문제집.backjoon.수들의합2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * link : https://maivve.tistory.com/223
 */

public class Sol {
    public static void main(String args[]) throws IOException {
        System.setIn(new FileInputStream("./src/backjoon/수들의합2/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];

        // 입력값 받기
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(twoPointer(arr, m));
    }

    static int twoPointer(int[] arr, int m) {
        int count = 0;
        int startPoint = 0, endPoint = 0;
        int len = arr.length;
        int sum = 0;

        while(true) {
            // M 보다 sum이 크면 값을 줄여서 M을 맞춰야 하므로 현재 startIndex의 값을 빼고 한 칸 앞으로 이동해야 한다.
            if(sum >= m) {
                sum -= arr[startPoint++];

            }
            else if(endPoint >= len) {
                break;
            }
            else { // M 보다 sum이 작으면 값을 늘려서 M을 맞춰야 하므로 현재 endIndex를 한 칸 앞으로 이동시키고 그인덱스의 원소 값을 더해줘야 한다.
                sum += arr[endPoint++];
            }

            if(sum == m) {
                count++;
            }
        }

        return count;
    }
}
