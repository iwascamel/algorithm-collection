package 문제집.backjoon.알파벳;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainV2 {

    static int N,M;
    static char[][] map;
    static int count;

    static boolean[] v = new boolean[26];

    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("./src/backjoon/알파벳/input.txt"));

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        count=0;
        map = new char[N][M];

        for(int i=0;i<N;i++){
            char[] chars = sc.next().toCharArray();
            for(int j=0;j<M;j++){
                map[i][j] = chars[j];
            }
        }

        List<Character> list = new ArrayList<>();
        dfs(0,0,list,0);

        System.out.println(count);
    }

    private static void dfs(int x, int y, List<Character> list, int cnt) {
        if(isOut(x,y) || v[map[x][y]-'A']){
            count = Math.max(cnt,count);
            return ;
        }
        v[map[x][y]-'A']=true;
        cnt++;

        for(int i=0;i<4;i++){
            int nx = x+dx[i];
            int ny = y+dy[i];

            dfs(nx,ny,list,cnt);
        }
        v[map[x][y]-'A']=false;
    }

    static void print(){
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    static boolean checkAlphaIsRepeat(int r, int c, List<Character> list){
        for(Character character : list){
            if(map[r][c] == character) return true;
        }
        return false;
    }

    static boolean isOut(int nx, int ny){
        return nx<0 || nx>=N || ny <0 || ny >= M;
    }
}
