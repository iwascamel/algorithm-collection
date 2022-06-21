package 문제집.backjoon.종이의개수;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * date: 22.06.21
 */

public class Main {
    static int N;
    static int[][] map;
    static int[] resCount;
    static Map<Integer,Integer> hash;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("./src/문제집/backjoon/종이의개수/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        // -1 0 1
        resCount = new int[3];
        hash = new HashMap<>();
        hash.put(-1,0);
        hash.put(0,1);
        hash.put(1,2);

        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        divide(0,0,N);

        for(int n : resCount){
            System.out.println(n);
        }

    }

    private static void divide(int sx, int sy, int n) {
        int tell = map[sx][sy];
        boolean flag = true;
        out: for(int i=sx;i<sx+n;i++){
            for(int j=sy;j<sy+n;j++){
                if(map[i][j] != tell){
                    flag = false;
                    continue out;
                }
            }
        }

        if(flag){
            resCount[hash.get(tell)]++;
        }else{
            for(int i=sx;i<sx+n;i+=n/3){
                for(int j=sy;j<sy+n;j+=n/3){
                    divide(i,j,n/3);
                }
            }
        }
    }
}
