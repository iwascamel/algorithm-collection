package 문제집.backjoon.용돈관리;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * date: 22.06.22
 * memo: 뭔 문제인지 이해가 안돼서 pass
 */

public class Main {
    static int N,M;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("./src/문제집/backjoon/용돈관리/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];

        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        int start = 0;
        int end = 10000;

        while(start<end){
            int mid = (start+end)/2;

            int sum = 0;
            for(int n : arr){
                sum += n/mid;
            }
            System.out.println("sum = " + sum);
            System.out.println("mid = " + mid);
            System.out.println("---");
            if(sum > M){
                start = mid+1;
            }else{
                end = mid;
            }
        }
        System.out.println(end);
    }
}
