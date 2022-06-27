package 문제집.backjoon.행렬곱셈BJ2740;

import java.util.StringTokenizer;

/**
 * date: 22.06.26
 */

 import java.io.*;
 import java.util.*;

public class Main {
    static int N,M,K;

    static int[][] a;
    static int[][] b;
    static int[][] c;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("./src/문제집/backjoon/행렬곱셈BJ2740/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        a = new int[N][M];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        b = new int[M][K];
        c = new int[N][K];

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<K;j++){
                b[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int k=0;k<K;k++){
            for(int i=0;i<N;i++){
                for(int j=0;j<M;j++){
                    c[i][k] += a[i][j] * b[j][k];
                }
            }
        }
        
        print(c);

    }

    static void print(int[][] map){
        for(int i=0;i<map.length;i++){
            for(int j=0;j<map[0].length;j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}
