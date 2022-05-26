package 문제집.backjoon.One로만들기;

import java.util.Scanner;

/*
터진다
 */

public class InClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        System.out.println(toOne(N));
    }
    static int toOne(int n){
        if(n==1) return 0;
        if(n==2 || n==3) return 1;

        int min = Integer.MAX_VALUE;

        min = Math.min(min,toOne(n-1)+1);
        if(n%2==0) min = Math.min(min,toOne(n/2)+1);
        if(n%3==0) min = Math.min(min,toOne(n/3)+1);

        return min;
    }
}
