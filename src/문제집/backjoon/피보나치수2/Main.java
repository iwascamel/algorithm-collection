package 문제집.backjoon.피보나치수2;

import java.util.Arrays;
import java.util.Scanner;

/**
 * date: 22.05.27
 */

public class Main {
    static int N;
    static long[] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new long[N+1];
        if(N==1 || N==2) {
            System.out.println(1);
            return ;
        }
        long fibo = fibo(N);
        System.out.println(fibo);
    }

    private static long fibo(int n) {
        if(n==2) return 1;
        if(n==1) return 1;

        if(arr[n] !=0){
            return arr[n];
        }

        return arr[n] = fibo(n-1) + fibo(n-2);
    }
}
