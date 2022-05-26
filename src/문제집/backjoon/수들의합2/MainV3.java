package 문제집.backjoon.수들의합2;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 * date : 21.10.06
 * type : two pointer
 */

public class MainV3 {

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
            } else if (right >= N){ // while 조건에 거는게 아니라 여기 거는 이유는, sum 이 M보다 같거나 커서 left 를 전진해서 cnt 를 세줘야 하는데도 불구하고, 멈출수 있기 때문
                // 해당 조건을 잘 생각해보자. sum >= M 일 때, 가 아니고 sum < M 일 때
                break;
            } else {
                sum += arr[right++];
            }

            if(sum == M) cnt++;
        }

        System.out.println(cnt);
    }
}
