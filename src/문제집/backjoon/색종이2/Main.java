package 문제집.backjoon.색종이2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    static int[][] map;

    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static int count;

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("src/backjoon/색종이2/input.txt"));
        map = new int[100][100];

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        count=0;

        for(int t=0;t<T;t++){
            int y = sc.nextInt();
            int x = sc.nextInt();
            int nx;
            int ny;
            for(int i=0;i<10;i++){
                for(int j=0;j<10;j++){
                    nx=x+i;
                    ny=y+j;
                    if(!isOut(nx,ny)){
                        map[nx][ny]=1;
                    }
                }
            }
        }

        for(int i=0;i<100;i++){
            for(int j=0;j<100;j++){
                if(map[i][j]==1){
                    isContactWhiteArea(i,j);
                }
            }
        }
        System.out.println(count);

    }

    static void isContactWhiteArea(int x,int y){
        for(int i=0;i<4;i++){
            int nx = x+dx[i];
            int ny = y+dy[i];

            if(!isOut(nx,ny)){
                if(map[nx][ny] == 0) count++;
            }else{
                count++;
            }
        }
    }

    static boolean isOut(int nx,int ny) {
        return nx < 0 || nx >= 100 || ny < 0 || ny >= 100;
    }
}
