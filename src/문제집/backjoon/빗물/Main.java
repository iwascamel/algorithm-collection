package 문제집.backjoon.빗물;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * date: 21.10.22
 * type: idea
 * reference link: https://iamheesoo.github.io/blog/algo-boj14719
 */

public class Main {

    static int H,N;
    static int[] arr;

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("./src/backjoon/빗물/input.txt"));

        Scanner sc = new Scanner(System.in);

        H = sc.nextInt();
        N = sc.nextInt();
        arr = new int[N];

        if(N<=2) System.out.println(0);
        else{
            for(int i=0;i<N;i++){
                arr[i] = sc.nextInt();
            }

            int totalCnt = 0;

            for(int i=1;i<N-1;i++){
                int leftMax = 0;
                int rightMax = 0;

                for(int j=0;j<i;j++){
                    leftMax = Math.max(leftMax,arr[j]);
                }
                for(int j=N-1;j>i;j--){
                    rightMax = Math.max(rightMax,arr[j]);
                }
                int height = Math.min(leftMax,rightMax);
                height -= arr[i];

                if(height>0) totalCnt+= height;
            }
            System.out.println(totalCnt);
        }
    }
}
