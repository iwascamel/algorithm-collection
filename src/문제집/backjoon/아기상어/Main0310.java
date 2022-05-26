package 문제집.backjoon.아기상어;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * date: 22.03.10
 */

public class Main0310 {
    static int N;
    static int[][] map;

    static class Fish{
        int x;
        int y;
        int cnt;

        public Fish(int x, int y,int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }

        @Override
        public String toString() {
            return "Fish{" +
                    "x=" + x +
                    ", y=" + y +
                    ", cnt=" + cnt +
                    '}';
        }
    }

    static int sharkX;
    static int sharkY;
    static int size;
    static int eat;
    static List<Fish> list;
    static boolean[][] visited;
    static int[][] costs;

    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    static int result;

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("./src/backjoon/아기상어/input.txt"));

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        map = new int[N][N];
        size = 2;

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                int in = sc.nextInt();

                if(in==9){
                    sharkX = i;
                    sharkY = j;
                }
                map[i][j] = in;
            }
        }

        Comparator<Fish> comp = (o1, o2) -> {
            if( o1.cnt == o2.cnt){
                if(o1.x == o2.x){
                    return Integer.compare(o1.y,o2.y);
                }else{
                    return Integer.compare(o1.x,o2.x);
                }
            }else{
                return Integer.compare(o1.cnt,o2.cnt);
            }
        };

        while(true){
            print();
            System.out.println("----------");
            visited = new boolean[N][N];
            costs = new int[N][N];
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    costs[i][j] = Integer.MAX_VALUE;
                }
            }
            list = new ArrayList<>();
            dfs(sharkX,sharkY,0);

            if(list.isEmpty()) break;

            list.sort(comp);

            Fish f = list.get(0);

            result += f.cnt;
            eat +=1;

            if(eat == size){
                size +=1;
                eat = 0;
            }

            map[f.x][f.y] = 9;
            map[sharkX][sharkY] = 0;
            sharkX = f.x;
            sharkY = f.y;
        }
        System.out.println(result);
    }

    static void print(){
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void dfs(int x, int y, int cnt){
        visited[x][y] = true;
        if(map[x][y] != 0 && map[x][y] != 9 && map[x][y] != size){
            list.add(new Fish(x,y,cnt));
        }

        for(int d=0;d<4;d++){
            int nx = x + dx[d];
            int ny = y + dy[d];

            if(isOut(nx,ny) || map[nx][ny] > size ) continue;

            if(cnt < costs[nx][ny]){
                costs[nx][ny] = cnt;
                dfs(nx,ny,cnt+1);
            }
        }
    }
    static boolean isOut(int nx, int ny){
        return nx<0 || ny < 0 || nx>=N || ny >=N;
    }
}
