package 문제집.backjoon.부호;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.Scanner;

/**
 * date : 21.10.06
 * type : 구현
 */

public class Main {

    static int T;
    static int N;
    static BigInteger[] arr;

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("./src/backjoon/부호/input.txt"));
        Scanner sc = new Scanner(System.in);

        T = 3;

        for(int t=0;t<T;t++){
            N = sc.nextInt();

            arr = new BigInteger[N];

            for(int i=0;i<N;i++){
                arr[i] = sc.nextBigInteger();
            }

            BigInteger sum = null;

            for(BigInteger i : arr){
            }

        }
    }
}
