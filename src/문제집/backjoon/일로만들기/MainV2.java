package 문제집.backjoon.일로만들기;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * date: 22.05.27
 */

public class MainV2 {
    static int N;
    static int[] arr;
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("./src/문제집/backjoon/일로만들기/input.txt"));
        Scanner sc=  new Scanner(System.in);

        N = sc.nextInt();
        arr = new int[1000001];

        arr[1] = 0;
        arr[2] = 1;
        arr[3] = 1;

        for(int i=4;i<=N;i++){
            arr[i] = arr[i-1]+1;
            if(i%2==0)arr[i] = Math.min(arr[i],arr[i/2]+1);
            if(i%3==0)arr[i] = Math.min(arr[i],arr[i/3]+1);
        }

        System.out.println(arr[N]);
    }
}
