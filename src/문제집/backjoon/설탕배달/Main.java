package 문제집.backjoon.설탕배달;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int count=0;

        while(N%5!=0){
            N-=3;
            count++;
        }
        if(N>=0) {
            count += N/5;
            System.out.println(count);
        }else{
            System.out.println(-1);
        }
    }
}
