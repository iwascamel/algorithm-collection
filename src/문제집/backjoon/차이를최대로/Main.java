package 문제집.backjoon.차이를최대로;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * date: 22.07.06
 */

public class Main {
    static int N;
    static int[] temp;
    static int max;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("./src/문제집/backjoon/차이를최대로/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        temp = new int[N];

        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        perm(0,0);
        System.out.println(max);
    }

    private static void perm(int cnt, int flag) {
        if(cnt==N){
            int sum = 0;
            for(int i=0;i<N-1;i++){
                sum += Math.abs(arr[temp[i]] - arr[temp[i+1]]);
            }
            max = Math.max(max,sum);
            return;
        }

        for(int i=0;i<N;i++){
            if( (flag & 1 << i) != 0) continue;
            temp[cnt] = i;
            perm(cnt+1,flag | 1<< i);
        }
    }
}
