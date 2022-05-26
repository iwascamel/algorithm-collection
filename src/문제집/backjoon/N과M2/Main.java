package 문제집.backjoon.N과M2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * date : 21.12.17
 */

public class Main {

    static int N;
    static int M;
    static int[] arr;
    static List<int[]> list;
    static int[] temp;
    static StringBuilder sb;

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("./src/backjoon/N과M2/input.txt"));
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        list = new ArrayList<>();
        sb = new StringBuilder();

        arr = new int[N];
        temp = new int[M];

        for(int i=0;i<N;i++){
            arr[i] = i+1;
        }

        comb(0);
        System.out.println(sb);
    }

    private static void comb(int cnt) {
        if(cnt == M){
            for(int a : temp){
                sb.append(a).append(" ");
            }
            sb.append('\n');
            return ;
        }

        for(int i=0;i<N;i++){
            temp[cnt] = arr[i];
            comb(cnt+1);
        }
    }
}
