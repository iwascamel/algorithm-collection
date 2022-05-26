package 문제집.backjoon.색종이만들기;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int oneCount,zeroCount;

    static int[][] map;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("./src/backjoon/색종이만들기/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        oneCount =0;
        zeroCount =0;

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];

        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0,0,N);
        System.out.println(zeroCount);
        System.out.println(oneCount);
    }

    private static void dfs(int x,int y,int width) {
        if(width == 1){
            if(map[x][y] == 1) oneCount ++;
            else if(map[x][y] == 0) zeroCount ++;
            return ;
        }

        if(!checkIsSame(x,y,width)){
            dfs(x,y,width/2);
            dfs(x,y+width/2,width/2);
            dfs(x+width/2,y,width/2);
            dfs(x+width/2,y+width/2,width/2);
        }else{
            if(map[x][y] == 1) oneCount ++;
            else if(map[x][y] == 0) zeroCount ++;
        }
    }

    static boolean checkIsSame(int nx,int ny,int width){
        for(int i=nx;i<nx+width;i++){
            for(int j=ny;j<ny+width;j++){
                if(map[nx][ny] != map[i][j]) return false;
            }
        }
        return true;
    }

    static boolean isOut(int nx,int ny){
        return nx<0 || ny <0 || nx>=N || ny>=N;
    }

    static void print(){
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                System.out.print(map[i][j]+ " ");
            }
            System.out.println();
        }
    }
}
