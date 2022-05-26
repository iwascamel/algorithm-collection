package 문제집.backjoon.마법사상어와비바라기;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    static int N,M;
    static int[][] map;
    static int[] dx = {0,-1,-1,-1,0,1,1,1};
    static int[] dy = {-1,-1,0,1,1,1,0,-1};

    static int[] cx = {-1,-1,1,1};
    static int[] cy = {-1,1,-1,1};
    static boolean[][] checked;

    static class MoveInfo{
        int dir;
        int degree;

        public MoveInfo(int dir, int degree) {
            this.dir = dir;
            this.degree = degree;
        }
    }

    static MoveInfo[] infos;
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("./src/backjoon/마법사상어와비바라기/input.txt"));
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        map = new int[N][N];

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                map[i][j] = sc.nextInt();
            }
        }
        infos = new MoveInfo[M];

        for(int i=0;i<M;i++){
            int dir = sc.nextInt()-1;
            int move = sc.nextInt();

            infos[i] = new MoveInfo(dir,move);
        }

        int startPointX = N-2;
        int startPointY = 0;

        for(MoveInfo info : infos){
            checked = new boolean[N][N];
            int nx = startPointX + dx[info.dir]*info.degree;
            nx %= N;

            int ny = startPointY + dy[info.dir]*info.degree;
            ny %= N;

            if(nx<0) nx = N+nx;
            if(ny<0) ny = N+ny;

            startPointX = nx;
            startPointY = ny;

            for(int i=nx;i<nx+2;i++){
                for(int j=ny;j<ny+2;j++){
                    int ni = i%N;
                    int nj = j%N;

                    map[ni][nj] +=1;
                    checked[ni][nj] = true;
                }
            }

            for(int i=nx;i<nx+2;i++){
                for(int j=ny;j<ny+2;j++){
                    int ni = i%N;
                    int nj = j%N;

                    for(int d=0;d<4;d++){
                        int nni = ni + cx[d];
                        int nny = nj + cy[d];

                        if(isOut(nni,nny)) continue;

                        if(map[nni][nny] > 0){
                            map[ni][nj] += 1;
                        }
                    }
                }
            }

            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    if(checked[i][j]) continue;
                    if(map[i][j] >=2) map[i][j] -= 2;
                }
            }

        }

        int answer = 0;


        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                answer += map[i][j];
            }
        }

        System.out.println(answer);
    }

    private static void printChecked() {
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                System.out.print(checked[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void print() {
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    static boolean isOut(int nx,int ny){
        return nx<0 || ny<0 || nx>=N || ny>=N;
    }
}
