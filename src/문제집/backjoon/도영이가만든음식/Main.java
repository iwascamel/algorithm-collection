package 문제집.backjoon.도영이가만든음식;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    static int[][] arr;
    static boolean[] v;
    static int N;
    static int min ;

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("./src/backjoon/도영이가만든음식/input.txt"));
        Scanner sc = new Scanner(System.in);

        min= Integer.MAX_VALUE;
        N = sc.nextInt();
        v = new boolean[N];

        arr = new int[N][2];

        for(int i=0;i<N;i++){
            for(int j=0;j<2;j++){
                arr[i][j] = sc.nextInt();
            }
        }
        subset(0);
        System.out.println(min);
    }

    static void subset(int count){
        if(count==N){
            int a1=1;
            int a2=0;
            int cnt=0;
            for(int i=0;i<N;i++){
                if(v[i]){
                    cnt++;
                    a1 *= arr[i][0];
                    a2 += arr[i][1];
                }
            }
            // 공집합일 경우 리턴
            if(cnt==0) return;
            min = Math.min(min,Math.abs(a1-a2));
            return ;
        }
        v[count] = true;
        subset(count+1);
        v[count] = false;
        subset(count+1);

    }
}
