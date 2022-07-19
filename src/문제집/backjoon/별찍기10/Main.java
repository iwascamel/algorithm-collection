package 문제집.backjoon.별찍기10;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * date: 22.07.20
 * 참조: https://iseunghan.tistory.com/202
 * https://velog.io/@lifeisbeautiful/Java-%EB%B0%B1%EC%A4%80-2447%EB%B2%88-%EB%B3%84-%EC%B0%8D%EA%B8%B0-10-%EC%9E%90%EB%B0%94
 */

public class Main {
    static int N;
    static char[][] template = new char[][]{{'*','*','*'},{'*',' ','*'},{'*','*','*'}};
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("./src/문제집/backjoon/별찍기10/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        char[][] recurse = recurse(0, 0, N);

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                sb.append(recurse[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static char[][] recurse(int x,int y,int n){
        if(n==3){
            return template;
        }
        char[][] res = new char[n][n];
        for(int i=0;i<3;i++){
            int nx = x + n/3*i;
            for(int j=0;j<3;j++){
                int ny = y + n/3*j;

                if(i==1 && j==1){
                    for(int a=nx;a<nx+n/3;a++){
                        for(int b=ny;b<ny+n/3;b++){
                            res[a][b] = ' ';
                        }
                    }
                    continue;
                }
                char[][] recurseArr = recurse(0,0,n/3);
                for(int a=nx;a<nx+n/3;a++){
                    for(int b=ny;b<ny+n/3;b++){
                        char aa = recurseArr[a-nx][b-ny];
                        res[a][b] = aa;
                    }
                }
            }
        }
        return res;
    }
    static void printMap(char[][] map){
        for(int i=0;i<map.length;i++){
            for(int j=0;j<map.length;j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}
