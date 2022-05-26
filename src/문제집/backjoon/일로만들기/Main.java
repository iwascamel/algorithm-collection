package 문제집.backjoon.일로만들기;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * date: 22.05.27
 */

public class Main {
    static int N;
    static int[] arr;
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("./src/문제집/backjoon/일로만들기/input.txt"));
        Scanner sc=  new Scanner(System.in);

        N = sc.nextInt();
        arr = new int[N+1];
        if(N==1 || N==2 || N==3){
            System.out.println(1);
            return ;
        }
        int cal = cal(N,0);
        System.out.println(cal);
    }

    private static int cal(int n, int cnt) {
        if(n==1 || n==2 || n==3){
            return cnt;
        }

        if(arr[n] !=0) {
            return arr[n];
        }

        if(n%3==0){
            return arr[n] = cal(n/3,cnt+1);
        }else if(n%2==0){
            return arr[n] = cal(n/2,cnt+1);
        }else{
            return arr[n] = cal(n-1,cnt+1);
        }
    }
}
