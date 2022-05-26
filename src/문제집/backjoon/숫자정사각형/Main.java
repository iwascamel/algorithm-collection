package 문제집.backjoon.숫자정사각형;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * date: 22.04.12
 * link: 정사각형 인데, 직사각형의 경우에도 된다 이 코드는
 */

public class Main {
    static int N,M;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("./src/backjoon/숫자정사각형/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for(int i=0;i<N;i++){
            String s = br.readLine();
            for(int j=0;j<M;j++){
                map[i][j] = s.charAt(j) - '0';
            }
        }

        int answer = 0;
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                System.out.println("i = " + i + " j = " + j);
                int max = cal(i,j);
                if(max >= answer){
                    System.out.println("max = " + max);
                    answer = max;
                }
                System.out.println("--------------------------------");
//                answer = Math.max(max,answer);
            }
        }
        System.out.println(answer);
    }

    private static void print() {
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }

    private static int cal(int x, int y) {
        int[][] dirs = {{x,M-1},{N-1,y},{N-1,M-1}};
        int v = map[x][y];

        System.out.println("x = " + x + " y = " + y);

        out : while(true){
            for(int[] dir : dirs){
                System.out.println(Arrays.toString(dir));
            }
            System.out.println("--------");
            for(int[] dir : dirs){
                int x1 = dir[0];
                int y1 = dir[1];
                if(x1 == x && y1 == y){
                    break out;
                }
            }
            if(map[x][dirs[0][1]] == v || map[dirs[1][0]][y] == v || map[dirs[2][0]][dirs[2][1]] == v){
                int nx = dirs[2][0] - x;
                int ny = dirs[2][1] - y;
                return (nx+1) * (ny+1);
            }else{
                dirs[0][1] -= 1;
                dirs[1][0] -= 1;
                dirs[2][0] -= 1;
                dirs[2][1] -= 1;
            }
        }
        return 1;
    }
}
