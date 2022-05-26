package 문제집.backjoon.수들의합2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * date : 21.10.06
 * type : two pointer
 */

public class Main {

    static int N,M;
    static int[] arr;

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("./src/backjoon/수들의합2/input.txt"));

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[N];

        for(int i=0;i<N;i++){
            arr[i] = sc.nextInt();
        }

        int left=0,right = 0,cnt =0;

        while(left != N && right != N){
            int sum=0;
            for(int j=left;j<=right;j++){
                sum += arr[j];
            }
            if(sum == M) {
                cnt++;
                right++;
            }
            else if(sum < M && right < N){
                right ++;
            }else if(sum > M && left < right){
                left ++;
            }
        }

        System.out.println(cnt);
    }
}
