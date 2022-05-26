package 문제집.backjoon.직사각형을만드는방법;

import java.util.Scanner;

public class MainV2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();

        int cnt = 0;
        for(int i=1; i<n+1; i++)
            for(int j=1; j<=i; j++)
                if(i*j <= n){
                    System.out.println("i = " + i);
                    System.out.println("j = " + j);

                    cnt++;
                }


        System.out.println(cnt);
    }
}
