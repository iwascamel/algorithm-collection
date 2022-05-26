package 문제집.backjoon.ATM;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;


public class Main {

    static int N;
    static int[] arr;

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("./src/backjoon/ATM/input.txt"));

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        arr = new int[N];

        for(int i=0;i<N;i++){
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        int count =0;

        for(int i=0;i<N;i++){
            for(int j=0;j<i+1;j++){
                count += arr[j];
            }
        }
        System.out.println(count);
    }
}
