package 문제집.backjoon.빵집;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

public class Main {

    static int R,C;
    static char[][] map;
    static int result;
    static Stack<int[]> stack;

    // 우측 위, 우측, 우측 아래로만 이동 가능
    static int[] dx={-1,0,1};
    static int[] dy={1,1,1};

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("./src/backjoon/빵집/input.txt"));

        Scanner sc = new Scanner(System.in);
        R = sc.nextInt();
        C = sc.nextInt();

        stack = new Stack<>();

        map = new char[R][C];

        for(int i=0;i<R;i++){
            char[] c = sc.next().toCharArray();
            for(int j=0;j<C;j++){
                map[i][j] = c[j];
            }
        }
        result = 0;
        for(int i=0;i<R;i++){
            if(map[i][0] == '.'){
                if(dfs(i,0)) result++;
            }
        }
    }

    private static boolean dfs(int r, int c) {

        if(c == C-1){
            for(int[] loc : stack){
                map[loc[0]][loc[1]] = 'X';
            }
            return true;
        }

        stack.push(new int[]{r,c});

        for(int d=0;d<3;d++){
            int nx = dx[d];
            int ny = dy[d];

            if(check(nx,ny)){
                dfs(nx,ny);
            }else{

            }
        }
        return false;
    }

    private static boolean check(int nx, int ny) {
        return nx >= 0 && nx < R && ny >=0 && ny < C && map[nx][ny] == '.';
    }
}
