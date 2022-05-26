package 문제집.backjoon.수들의합2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * date : 21.12.22
 */

public class Main1222 {

    static int N,M;
    static int[] arr;

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("./src/backjoon/수들의합2/input.txt"));

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[N];
        int cnt=0;

        for(int i=0;i<N;i++){
            arr[i] = sc.nextInt();
        }

        int left = 0;
        int right =0;
        int sum = 0;

        sum += arr[left];

        while(left < N && right <N){
            if(right==N-1) break;
            if(sum==M) {
                cnt++;
                sum -= arr[left++];
            }else if(sum < M){
                sum += arr[++right];
            }else { // sum > M
                sum -= arr[left++];
            }
        }
        while(left<N){
            if(sum==M){
                cnt++;
            }
            sum -= arr[left++];
        }

        System.out.println(cnt);
    }
}
