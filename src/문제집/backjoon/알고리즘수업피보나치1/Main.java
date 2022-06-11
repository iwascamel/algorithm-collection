package 문제집.backjoon.알고리즘수업피보나치1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * date: 22.06.11
 */

public class Main {
    static int brute;
    static int dp;
    static int[] arr;
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("./src/문제집/backjoon/알고리즘수업피보나치1/input.txt"));
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        arr = new int[45];
        arr[1] = 1;
        arr[2] = 1;

        fiboBrute(N);
        fiboDP(N);

        System.out.println("brute = " + brute);
        System.out.println("dp = " + dp);
    }
    private static int fiboBrute(int n) {
        brute++;
        if(n==1 || n==2) return 1;
        else return fiboBrute(n-1) + fiboBrute(n-2);
    }
    static int fiboDP(int n){
        dp++;
        if(n==1 || n==2) return 1;
        if(arr[n] > 0) return arr[n];
        else return arr[n] = fiboDP(n-1) + fiboDP(n-2);
    }
}
