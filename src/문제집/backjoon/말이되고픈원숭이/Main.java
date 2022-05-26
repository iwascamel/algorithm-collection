package 문제집.backjoon.말이되고픈원숭이;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int K;
    static int W,H;
    static int[][] map;

    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    static int[][] horse = {{-2,-1},{-1,-2},{-2,1},{-1,2},{1,-2},{1,2},{2,-1},{2,1}};

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("./src/backjoon/말이되고픈원숭이/input.txt"));

        Scanner sc = new Scanner(System.in);

        K = sc.nextInt();
        W = sc.nextInt();
        H = sc.nextInt();

        map = new int[W][H];

        for(int i=0;i<W;i++){
            for(int j=0;j<H;j++){
                map[i][j] = sc.nextInt();
            }
        }

        /*
        전체 : K 만큼 이동할 수 없을 때까지 horse 를 돌림
        현재 x,y 에서 말로 이동할 수 있는 위치 구함
        이동했을 때, bfs 를 돌렸을 때 도착점과의 거리가 가장 가까운 지점 선택
        count +1
        k-1
        해당 위치로 현재 x,y 이동
         */




        System.out.println(getDistanceFromEnd(0,0));

    }

    static int getDistanceFromEnd(int nx, int ny){
        int cnt=0;

        Queue<Integer[]> queue = new LinkedList<>();
        boolean[][] v = new boolean[W][H];
        boolean flag = false;

        queue.offer(new Integer[]{nx,ny,0});

        a: while(!queue.isEmpty()){
            Integer[] poll = queue.poll();

            for(int i=0;i<4;i++){
                int a = poll[0] + dx[i];
                int b = poll[1] + dy[i];
                int c = poll[2]+1;

                if(!isOut(a,b) && map[a][b] !=1 && !v[a][b]){
                    if(a== W-1 && b == H-1){
                        cnt = c;
                        flag = true;
                        break a;
                    }
                    queue.offer(new Integer[]{a,b,c});
                    v[a][b] = true;
                }
            }
        }

        if(flag){
            return cnt;
        }else{
            return -1;
        }
    }

    static boolean isOut(int nx,int ny){
        return nx<0 || ny <0 || nx >= W || ny >= H;
    }
}
