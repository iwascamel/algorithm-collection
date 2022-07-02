package 문제집.backjoon.하노이탑;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;

/*
 * date: 22.07.02
 */

public class Main {
    static int N;
    static int cnt;
    public static void main(String[] args) throws NumberFormatException, IOException {
        System.setIn(new FileInputStream("./src/문제집/backjoon/하노이탑/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        BigInteger res = BigInteger.valueOf((long) (Math.pow(2,N)-1));
        System.out.println(res);
        if(N<=20){
            hanoi(1,3,N);
        }
    }

    static void hanoi(int start,int end, int n){
        cnt++;
        if(n==1){
            System.out.println(start + " " + end);
            return ;
        }

        hanoi(start, 6-start-end, n-1);
        System.out.println(start + " " + end);
        hanoi(6-start-end, end, n-1);
    }
}
