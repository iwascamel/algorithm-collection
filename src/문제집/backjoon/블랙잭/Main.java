package 문제집.backjoon.블랙잭;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    static int N,M;
    static int[] arr;

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("./src/backjoon/블랙잭/input.txt"));

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[N];

        for(int i=0;i<N;i++){
            arr[i] = sc.nextInt();
        }
        int max=0;
        for(int i=0;i<N-2;i++){
            for(int j=i+1;j<N-1;j++){
                for(int k=j+1;k<N;k++){
                    if(arr[i]+arr[j]+arr[k] <= M){
                        max = Math.max(max,arr[i]+arr[j]+arr[k]);
                    }
                }
            }
        }
        System.out.println(max);
    }
}
