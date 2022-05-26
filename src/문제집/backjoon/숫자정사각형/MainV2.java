package 문제집.backjoon.숫자정사각형;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * date: 22.04.12
 * link: 정사각형 인데, 직사각형의 경우에도 된다 이 코드는
 */

public class MainV2 {
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

        int answer = 1;
        int size= Math.min(N,M);

        for(int k=1;k<size;k++){
            for(int i=N-1-k;i>=0;i--){
                for(int j=M-1-k;j>=0;j--){
                    int v = map[i][j];

                    if(v == map[i+k][j] && v == map[i][j+k] && v == map[i+k][j+k]){
                        answer = Math.max(answer, (k+1)*(k+1));
                        break;
                    }
                }
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

}
