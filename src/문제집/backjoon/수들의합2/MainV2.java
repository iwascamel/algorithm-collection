package 문제집.backjoon.수들의합2;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 * date : 21.10.06
 * type : two pointer
 */

public class MainV2 {

    static int N,M;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("./src/backjoon/수들의합2/input.txt"));

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[N];

        for(int i=0;i<N;i++){
            arr[i] = sc.nextInt();
        }

        int left=0,right = 0,cnt =0;
        int sum=0;


        while(true){
            if(sum >= M) {
                sum -= arr[left++];
            }else if(right >= N){
                break;
            } else {
                sum += arr[right++];
            }
            if(sum == M) cnt++;
        }
        System.out.println(cnt);
    }
}
