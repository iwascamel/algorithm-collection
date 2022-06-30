package 문제집.backjoon.쿼드트리;

/**
 * date: 22.06.30
 */

import java.util.*;
import java.io.*;

public class MainV3 {
    static int N;
    static int[][] map;
    static StringBuilder sb;
    public static void main(String[] args) throws NumberFormatException, IOException {
        System.setIn(new FileInputStream("./src/문제집/backjoon/쿼드트리/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        sb = new StringBuilder();
        map = new int[N][N];

        for(int i=0;i<N;i++){
            String s = br.readLine();
            for(int j=0;j<N;j++){
                map[i][j] = s.charAt(j) - '0';
            }
        }

        quad(0,0,N);
        System.out.println(sb);
    }
    private static void quad(int x, int y,int n) {
        if(isAvailable(x, y, n)){
            sb.append(map[x][y]);
            return ;
        }

        if(n==2){
            sb.append("(");
            for(int i=x;i<x+n;i++){
                for(int j=y;j<y+n;j++){
                    sb.append(map[i][j]);
                }
            }
            sb.append(")");
            return ;
        }

        sb.append("(");
        quad(x,y,n/2);
        quad(x,y+n/2,n/2);
        quad(x+n/2,y,n/2);
        quad(x+n/2,y+n/2,n/2);
        sb.append(")");
    }
    private static boolean isAvailable(int x, int y, int n) {
        int initValue = map[x][y];
        for(int i=x;i<x+n;i++){
            for(int j=y;j<y+n;j++){
                if(map[i][j] != initValue){
                    return false;
                }
            }
        }
        return true;
    }
}
