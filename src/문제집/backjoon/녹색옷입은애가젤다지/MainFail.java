package 문제집.backjoon.녹색옷입은애가젤다지;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * date : 21.09.29
 * type : bfs + dp
 * fail reason :
 * 1. 단순 dfs 라고 생각해서 4방 탐색했다.
 * 2. stackoverflow 발생하길래 뭐지? 했는데 방문 체크를 안해줬다
 * 3. 아 오른쪽 아래로만 내려가는구나! 하고 방향을 2개만 설정했다 -> 왼쪽 위쪽도 갈 수 있네? 음 뭐지?
 * 4. 왼쪽 위부터 오른쪽 아래까지 갈 수 있는 모든 경우의 수를 따져봐야 겠다라고 생각했다.
 * 5. 근데 그러면 방문 체크를 어떻게 해주지?
 */

public class MainFail {

    static int N;
    static int[][] map;
    static List<Integer> list;
    static int[] dx = {1,0};
    static int[] dy = {0,1};
    static boolean[][] flag;

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("./src/backjoon/녹색옷입은애가젤다지/input.txt"));

        Scanner sc = new Scanner(System.in);
        int number = 1;

        while(true){
            int cnt = 0;
            N = sc.nextInt();
            list = new ArrayList<>();
            if(N == 0) break;
            map = new int[N][N];
            flag = new boolean[N][N];
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    map[i][j] = sc.nextInt();
                }
            }

            dfs(0,0,0);
            Collections.sort(list);
            System.out.println(list);
            System.out.println("Problem " + number++ + " " + cnt);
        }

    }
    private static void dfs(int x, int y,int cnt) {
        if(x==N-1 && y==N-1){
            cnt += map[N-1][N-1];
            list.add(cnt);
            return ;
        }

        cnt += map[x][y];

        for(int d=0;d<2;d++){
            int nx = x+dx[d];
            int ny = y+dy[d];

            if(isOut(nx,ny)) continue;
            dfs(nx,ny,cnt);
        }
    }
    static boolean isOut(int nx,int ny){
        return nx<0 || ny <0 || nx>=N || ny>=N;
    }
}
