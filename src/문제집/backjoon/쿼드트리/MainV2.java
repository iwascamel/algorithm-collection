package 문제집.backjoon.쿼드트리;

import java.io.*;

/**
 * date: 22.03.25
 */

public class MainV2 {
    static int N;
    static int[][] map;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("./src/backjoon/쿼드트리/input.txt"));
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

    private static void quad(int x, int y, int width) {
        if(check(x,y,width)){
            sb.append(map[x][y]);
        }else{
            if(width==2){
                sb.append("(");
                for(int i=x;i<x+width;i++){
                    for(int j=y;j<y+width;j++){
                        sb.append(map[i][j]);
                    }
                }
                sb.append(")");
            }else{
                sb.append("(");
                quad(x,y,width/2);
                quad(x,y+width/2,width/2);
                quad(x+width/2,y,width/2);
                quad(x+width/2,y+width/2,width/2);
                sb.append(")");
            }
        }
    }

    static boolean check(int x,int y,int width){
        int first = map[x][y];
        for(int i=x;i<x+width;i++){
            for(int j=y;j<y+width;j++){
                if(map[i][j] != first ) return false;
            }
        }
        return true;
    }
}
