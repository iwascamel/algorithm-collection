package 문제집.backjoon.뱀;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class MainV2 {
    static int N,K,L;
    static boolean[][] visited;
    static int[][] map;
    static Map<Integer,String> dirs;
    static int time;

    // 우 하 좌 상
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("./src/백준51제/자료구조/뱀/input.txt"));
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        visited = new boolean[N][N];
        map = new int[N][N];
        K = sc.nextInt();

        for(int i=0;i<K;i++){
            int x = sc.nextInt()-1;
            int y = sc.nextInt()-1;
            map[x][y] = 1;
        }

        L = sc.nextInt();
        dirs = new HashMap<>();

        sc.nextLine();

        for(int i=0;i<L;i++){
            String[] input = sc.nextLine().split(" ");
            int time = Integer.parseInt(input[0]);
            dirs.put(time,input[1]);
        }

        bfs();
        System.out.println(time);
    }

    static boolean isOut(int nx, int ny){
        return nx<0 || ny<0 || nx>=N || ny>=N;
    }

    private static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        int nx = 0;
        int ny = 0;
        int dir = 0;

        while(true){
            nx += dx[dir];
            ny += dy[dir];
            time++;

            if(isOut(nx,ny)) break;
            if(queue.contains(nx*N+ny)) break;

            queue.offer(nx*N+ny);

            if(map[nx][ny] == 1){
                map[nx][ny] = 0;
            }else{
                queue.poll();
            }


            if(dirs.containsKey(time)){
                String d = dirs.get(time);
                if(d.equals("D")){
                    dir += 1;
                    if(dir == 4) dir=0;
                }else{
                    dir -= 1;
                    if(dir == -1 ) dir = 3;
                }
            }
        }
    }
}
